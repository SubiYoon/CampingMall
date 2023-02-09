package com.camp.admin.Controller;

import com.camp.admin.utility.MakeMainGraph;
import com.camp.admin.utility.MakeYearGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.GraphDTO;
import com.camp.admin.service.BookService;
import com.camp.admin.service.PaymentService;

@RestController
public class AjaxController {

	@Autowired
	PaymentService service;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/refundBook")
	public List<Map<String, Object>> bookEdit(){
		List<Map<String, Object>> books=null;
        
		try {
			books = bookService.selectAllState(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return books;
	}
	
	@PostMapping("refund")
	public int refundOk(@RequestBody JSONObject jsonobject) {
		int result=0;
		
		int state=Integer.parseInt(jsonobject.get("state")+"");
		String merchant_uid=(String)jsonobject.get("merchant_uid");
		
		if(state==3) {
			String importToken=service.getImportToken();
			result=service.cancelPayment(importToken,merchant_uid);
			if(result==1) {
				result=bookService.updateBookState(merchant_uid,3);
			}
		}else if(state==4){
			result=bookService.updateBookState(merchant_uid,4);
		}
		return result;
	}
	
    

    @RequestMapping("main/graphData")
    public Object reviewUpload(HttpSession session, String stringDate, String dataScale) {
        JSONObject json = new JSONObject();
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");
        int companyCode = company.getCompany_code();
        if (dataScale==null||dataScale.contains("M")) {
            try {
                List<GraphDTO> graphs = new ArrayList<>();
                MakeMainGraph monthGraph = bookService.getMonthGraph(companyCode,stringDate);
                Map<String, String> ScZn = bookService.SiteCodeAndZoneNameMap(companyCode);
                GraphDTO graphDTO = monthGraph.MakeRevenueGraph();
                graphs.add(graphDTO);
                graphDTO = monthGraph.MakeBookGraph();
                graphs.add(graphDTO);
                graphDTO = monthGraph.MakeVisitorGraph();
                graphs.add(graphDTO);
                graphDTO = monthGraph.MakeZoneRevenueGraph(ScZn);
                graphs.add(graphDTO);
                graphDTO = monthGraph.MakeZoneVisitorGraph(ScZn);
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                String stringDate2 = stringDate.split("-")[0];
                List<MakeMainGraph> graphList = new ArrayList<>();
                for (int i = 1; i <= 12; i++) {
                    String stringYearAndMonth = stringDate2;
                    if (i / 10 < 1) {
                        stringYearAndMonth += "-0" + i;
                    } else {
                        stringYearAndMonth += "-" + i;
                    }
                    graphList.add(bookService.getMonthGraph(companyCode, stringYearAndMonth));
                }
                Map<String, String> ScZn = bookService.SiteCodeAndZoneNameMap(companyCode);
                MakeYearGraph yearGraph = new MakeYearGraph(stringDate2,ScZn,graphList);
                List<GraphDTO> graphs = new ArrayList<>();
                GraphDTO graphDTO = yearGraph.MakeYearRevenueGraph();
                graphs.add(graphDTO);
                graphDTO = yearGraph.MakeYearBookGraph();
                graphs.add(graphDTO);
                graphDTO = yearGraph.MakeYearVisitorGraph();
                graphs.add(graphDTO);
                graphDTO = yearGraph.MakeYearZoneRevenueGraph();
                graphs.add(graphDTO);
                graphDTO = yearGraph.MakeYearZoneVisitorGraph();
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}

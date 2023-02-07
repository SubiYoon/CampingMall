package com.camp.admin.Controller;

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
                System.out.println(stringDate);
                GraphDTO graphDTO = bookService.MonthSalesGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.MonthlyBookGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.MonthlyUserGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.MonthlyZoneSalesGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.MonthlyZoneUserGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                String stringDate2 = stringDate.split("-")[0];
                System.out.println(stringDate2);
                List<GraphDTO> graphs = new ArrayList<>();
                GraphDTO graphDTO = bookService.YearSalesGraph(stringDate2,companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.YearlyBookGraph(stringDate2,companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.YearlyUserGraph(stringDate2,companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.YearlyZoneSalesGraph(stringDate2, companyCode);
                graphs.add(graphDTO);
                graphDTO = bookService.YearlyZoneUserGraph(stringDate2, companyCode);
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}

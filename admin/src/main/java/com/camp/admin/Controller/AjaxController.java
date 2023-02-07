package com.camp.admin.Controller;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.GraphDTO;
import com.camp.admin.service.BookService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @Autowired
    BookService bService;

    @RequestMapping("main/graphData")
    public Object reviewUpload(HttpSession session, String stringDate, String dataScale) {
        JSONObject json = new JSONObject();
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");
        int companyCode = company.getCompany_code();
        if (dataScale.contains("M")) {
            try {
                List<GraphDTO> graphs = new ArrayList<>();
                GraphDTO graphDTO = bService.MonthSalesGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthlyBookGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthlyUserGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthlyZoneSalesGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthlyZoneUserGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<GraphDTO> graphs = new ArrayList<>();
                GraphDTO graphDTO = bService.YearSalesGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.YearlyBookGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.YearlyUserGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.YearlyZoneSalesGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.YearlyZoneUserGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return json;
    }
}

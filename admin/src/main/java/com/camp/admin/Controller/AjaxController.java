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
        if (dataScale.equals("Monthly")) {
            try {
                List<GraphDTO> graphs = new ArrayList<>();
                GraphDTO graphDTO = bService.MonthlyZoneSalesGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthlyZoneUserGraph(stringDate, companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthSalesGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                graphDTO = bService.MonthlyUserGraph(stringDate,companyCode);
                graphs.add(graphDTO);
                json.put("Graph", graphs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                GraphDTO graphDTO = bService.MonthlyZoneSalesGraph(stringDate,
                    company.getCompany_code());
                json.put("Graph", graphDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return json;
    }
}

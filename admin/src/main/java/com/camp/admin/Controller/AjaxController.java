package com.camp.admin.Controller;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.GraphDTO;
import com.camp.admin.service.BookService;
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
    public Object reviewUpload(HttpSession session, String stringDate){
        JSONObject json = new JSONObject();
        CompanyDTO company = (CompanyDTO)session.getAttribute("company");
        try {
            GraphDTO graphDTO = bService.MonthlyZoneSalesGraph(stringDate,company.getCompany_code());
            json.put("Graph", graphDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }
}

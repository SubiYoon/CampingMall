package com.camp.admin.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.admin.DTO.AdminDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.ScheduleDTO;
import com.camp.admin.service.ScheduleService;
import com.camp.admin.utility.Utility;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
    
    String dir = "schedule/";

    @Autowired
    ScheduleService serviceS;

    @RequestMapping("")
    public String select(Model model, HttpSession session){

        CompanyDTO company = (CompanyDTO)session.getAttribute("company");

        try{
            List<ScheduleDTO> scheduleList = serviceS.selectByCompany(company.getCompany_code());
            for(int i=0; i<scheduleList.size(); i++){
                scheduleList.get(i).setStrDate(Utility.DateToString(scheduleList.get(i).getSchedule_date()));
            }
            model.addAttribute("scheduleList", scheduleList);
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("center", dir+"select");

        return "main";
    }

    @RequestMapping("insert")
    public String insert(Model model){

        model.addAttribute("center", dir+"insert");

        return "main";
    }


    @RequestMapping("insertOk")
    public String insertOk(HttpSession session, ScheduleDTO scheduleDTO, String selectDate){

        Date selectDate1;
        AdminDTO admin = (AdminDTO)session.getAttribute("admin");
        try {
            selectDate1 = Utility.StringToDate(selectDate);
            scheduleDTO.setSchedule_date(selectDate1);
            scheduleDTO.setAdmin_code(admin.getAdmin_code());
            serviceS.insert(scheduleDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/schedule";
    }

    @RequestMapping("update")
    public String update(Model model, int schedule_code){

        try{
            ScheduleDTO sDTO = serviceS.select(schedule_code);
            model.addAttribute("schedule", sDTO);
        }catch(Exception e){
            e.printStackTrace();
        }

        model.addAttribute("center", dir+"update");

        return "main";
    }

    @RequestMapping("updateOk")
    public String updateOk(HttpSession session, ScheduleDTO scheduleDTO, String selectDate){

        Date selectDate1 = null;

        try {
            selectDate1 = Utility.StringToDate(selectDate);
            scheduleDTO.setSchedule_date(selectDate1);
            serviceS.update(scheduleDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/schedule";
    }

    @RequestMapping("delete")
    public String delete(ScheduleDTO scheduleDTO){

        try{
            serviceS.delete(scheduleDTO.getSchedule_code());
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/schedule";
    }
}

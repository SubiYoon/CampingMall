package com.camp.camping.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.ReviewDTO;
import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.DTO.UserDTO;
import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.service.BookService;
import com.camp.camping.service.HomeService;
import com.camp.camping.service.ReviewService;
import com.camp.camping.service.SiteService;
import com.camp.camping.service.ZoneService;

@RestController
public class AjaxController {

    @Autowired
    SiteService sService;
    @Autowired
    ZoneService zService;
    @Autowired
    BookService bService;
    @Autowired
    HomeService hService;
    @Autowired
    ReviewService rService;

    @RequestMapping("selectDate")
    public Object selectDate(String selectDate1, String selectDate2, int company_code) {
        String change = null;
        List<SiteDTO> sites = null;
        List<ZoneDTO> zones = null;
        JSONObject json = new JSONObject();

        Date date1 = new Date(Integer.parseInt(selectDate1.split("-")[0]), Integer.parseInt(selectDate1.split("-")[1]),
                Integer.parseInt(selectDate1.split("-")[2]));
        Date date2 = new Date(Integer.parseInt(selectDate2.split("-")[0]), Integer.parseInt(selectDate2.split("-")[1]),
                Integer.parseInt(selectDate2.split("-")[2]));

        if (date1.after(date2)) {
            change = selectDate1;
            selectDate1 = selectDate2;
            selectDate2 = change;
        }

        try {
            sites = sService.AvailableSite(company_code, selectDate1, selectDate2);
            zones = zService.selectZone(company_code);
            json.put("availableSite", sites);
            json.put("zoneList", zones);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("실패");
        }

        json.put("book_checkin", selectDate1);
        json.put("book_checkout", selectDate2);

        return json;
    }

    @RequestMapping("userBook")
    public Object userBookList(HttpSession session) {
        JSONObject json = new JSONObject();
        List<BookDTO> userBookList = null;

        UserDTO user = (UserDTO) session.getAttribute("user");

        userBookList = bService.selectUserAll(user.getUser_code());

        int result = 1;

        for (int i = 0; i < userBookList.size(); i++) {
            try {
                result = bService.IsAvailableRequestRefund(userBookList.get(i).getBook_code());
                if (result == 0) {
                    userBookList.get(i).setBook_car_number(userBookList.get(i).getBook_car_number() + "," + result);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (userBookList.size() > 10) {
            List<BookDTO> userBookListLimit = new ArrayList<BookDTO>();
            for (int i = 0; i < 12; i++) {
                userBookListLimit.add(userBookList.get(i));
            }
            json.put("userBookList", userBookListLimit);
        } else {
            json.put("userBookList", userBookList);
        }

        return json;
    }

    @RequestMapping("reviewUpload")
    public int reviewUpload(HttpSession session, int site_code, ReviewDTO review) {
        int result = 0;
        UserDTO user = (UserDTO) session.getAttribute("user");

        if (bService.availableUserWriteReview(site_code, user.getUser_code())) {
            List<BookDTO> bookCode = bService.getReviewAvailableCode(site_code, user.getUser_code());
            review.setBook_code(bookCode.get(0).getBook_code());

            try {
                rService.insert(review);
                System.out.println("성공");
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println("실패");
            }

        } else
            result = 1;

        return result;
    }

    @RequestMapping("siteReview")
    public List<ReviewDTO> siteReview(int site_code) {
        List<ReviewDTO> list = null;

        list = rService.selectBySiteCode(site_code);

        return list;
    }

    @PostMapping("refund")
    public int refundOk(@RequestBody JSONObject jsonobject) {
        int result = 0;

        int state = Integer.parseInt(jsonobject.get("state") + "");
        String merchant_uid = (String) jsonobject.get("merchant_uid");

        if (state == 2) {
            result = bService.updateBookState(merchant_uid, 2);
            System.out.println("22요청:" + result);
        } else if (state == 1) {
            result = bService.updateBookState(merchant_uid, 1);
            System.out.println("11취소:" + result);
        }

        return result;
    }

}

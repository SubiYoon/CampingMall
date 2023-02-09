package com.camp.camping.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.DTO.FacilityDTO;
import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.DTO.ImageDTO;
import com.camp.camping.DTO.NoticeDTO;
import com.camp.camping.DTO.ReviewDTO;
import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.service.CompanyService;
import com.camp.camping.service.FacilityService;
import com.camp.camping.service.HomeService;
import com.camp.camping.service.ImageService;
import com.camp.camping.service.NoticeService;
import com.camp.camping.service.ReviewService;
import com.camp.camping.service.ZoneService;

@Controller
public class MainController {

	@Autowired
	CompanyService serviceC;
	
	@Autowired
	HomeService serviceH;
	
	@Autowired
	NoticeService serviceN;

	@Autowired
	FacilityService serviceF;
	
	@Autowired
	ZoneService serviceZ;
	
	@Autowired
	ImageService serviceI;

	@Autowired
	ReviewService serviceR;

	@RequestMapping("/")
	public String select(Model model, HttpSession session){
		if(session.getAttribute("company")!=null){
			session.invalidate();
		}
		List<CompanyDTO> companyList = null;
		try {
			companyList = serviceC.selectAll();
			model.addAttribute("companyList", companyList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "selectCompany";
	}

	@RequestMapping("/main")
	public String main(Model model, HttpSession session, CompanyDTO companyDTO, ZoneDTO zoneDTO, ImageDTO imageDTO) {
		
		HomeDTO homekko = null;		//카카오맵
		HomeDTO homecont = null;	//홈페이지소개
		CompanyDTO company = null;
		CompanyDTO companySelect = null;
		List<NoticeDTO> nolist = null;	//주요공지
		List<ZoneDTO> listZ = null;	//구역소개
		List<FacilityDTO> list = null;	//편의시설
		List<ImageDTO> listI = null;
		List<ReviewDTO> reviewList = null;
		
		
		//상호 세션 생성-----------------------------
		//TODO:차후 캠핑장 선택 페이지 생성시 수정 필요
		if(session.getAttribute("company")==null){
			try{
				companySelect = serviceC.select(companyDTO.getCompany_code());
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("실패123");
			}
				session.setAttribute("company", companySelect);
				company = companySelect;
		}else {
			company = (CompanyDTO)session.getAttribute("company");
		}
		//카카오맵경도위도-------------------------------------
		try {
			homekko = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("kkomap", homekko);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MAP_FAIL");
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		//주요공지----------------------------------
		
		try {
			nolist = serviceN.noticeLv(company.getCompany_code());	//상호코드
			model.addAttribute("noticeLv", nolist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeLv_FAIL");
		}
		
		//구역소개----------------------------------
		
		try {
			listZ=serviceZ.selectZone(company.getCompany_code());	//상호코드
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		model.addAttribute("zlist", listZ);
		
		//편의시설----------------------------------
		
		try {
			list = serviceF.selectByCompany(company.getCompany_code());	//상호코드
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("facilities", list);
		
		//이미지------------------------------------
		try {
			listI=serviceI.selectByCompanyCode(company.getCompany_code());	//상호코드
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("ilist", listI);

		//슬라이드 이미지
		try {
			listI=serviceI.selectByHomeCode(homecont.getHome_code());	//상호코드
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("slide", listI);

		try{
			reviewList = serviceR.selectMainReview(company.getCompany_code());
			List<ReviewDTO> mainReview = new ArrayList<ReviewDTO>();
			int size = reviewList.size() <=3 ? reviewList.size() : 3;
			for(int i=0; i<size; i++){
				mainReview.add(reviewList.get(i));
			}
			model.addAttribute("review", mainReview);
		} catch(Exception e){
			e.addSuppressed(e);
		}

		return "main";
	}
}

package com.camp.admin.Controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.DTO.SiteDTO;
import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.service.ImageService;
import com.camp.admin.service.SiteService;
import com.camp.admin.service.ZoneService;

@Controller
@RequestMapping("/zone")
public class ZoneController {
	
	@Value("${imagesdir}")
	String imagesdir;
	
	@Autowired
	ImageService serviceI;
	
	@Autowired
	SiteService serviceS;
	
	@Autowired
	ZoneService serviceZ;
	

	String dir = "zone/";
	
	@RequestMapping("")
	public String main(Model model, HttpSession session, int zone_code, ZoneDTO zoneDTO, ImageDTO imageDTO, SiteDTO siteDTO, CompanyDTO companyDTO) {
		
		List<ZoneDTO> listZ = null;
		List<ImageDTO> listI = null;
		List<SiteDTO> listS = null;
		ZoneDTO zonedto = null;
		
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		
		try {
			listZ=serviceZ.selectZone(company.getCompany_code());	//상호코드
			model.addAttribute("zlist", listZ);
		
			listI=serviceI.selectByCompanyCode(company.getCompany_code());	//상호코드
			model.addAttribute("ilist", listI);
		
			listS = serviceS.selectSet(company.getCompany_code());	//상호코드
			model.addAttribute("slist", listS);	
			
			zonedto = serviceZ.select(zone_code);
			model.addAttribute("zoneselect", zonedto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("center", dir+"zone");
		return "main";
	}

//-----------------------------------------------------------------		
	//구역(zone)수정페이지
		@RequestMapping("/zoneedit")
		public String zoneedit(Model model, ImageDTO imageDTO, int zone_code) {
			ZoneDTO zoneEdit = null;
			List<ImageDTO> listI = null;
			
			try {
				listI=serviceI.selectByZoneCode(zone_code);
				model.addAttribute("ilist", listI);
				
				zoneEdit = serviceZ.select(zone_code);
				model.addAttribute("zoneEdit", zoneEdit);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("center", dir + "zoneedit");
			return "main";
		}
		
		//구역(zone)수정기능
		 @RequestMapping("/zoneupdate")
		 public String zoneupdate(Model model, ZoneDTO zonedto) {
			 try {
				 serviceZ.update(zonedto);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 
			 return "redirect:/main";
		}
	 
		//새구역(zone)추가
		 @RequestMapping("/zoneinsert") public String zoneinsert(ZoneDTO zonedto) {
			 
			 try {
				 serviceZ.insert(zonedto);
			 } catch (Exception e) {
				 e.printStackTrace();
			 } 
			 
			 return "redirect:/main";
		}
		 
		//구역 삭제기능(업데이트로 처리)
		 @RequestMapping("/zonedel") 
		 public String zoneDel(ZoneDTO zonedto, int zone_code) {
			 try {
				 serviceZ.updateDel(zone_code);
			 } catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return "redirect:/main";
		}
	 
//-----------------------------------------------------------------		 
	//사이트(site)수정페이지
			@RequestMapping("/siteedit")
			public String siteedit(Model model, ImageDTO imageDTO, int site_code, int zone_code) {
				SiteDTO siteEdit = null;
				List<ImageDTO> listI = null;
				
				try {
					listI=serviceI.selectBySiteCode(site_code);
					model.addAttribute("ilist", listI);
					
					siteEdit = serviceS.select(site_code);
					model.addAttribute("siteEdit", siteEdit);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				model.addAttribute("zone_code", zone_code);
				model.addAttribute("center", dir + "siteEdit");
				return "main";
			}
	 
		//사이트(site)수정기능
			 @RequestMapping("/siteupdate")
			 public String siteupdate(Model model, SiteDTO sitedto) {
				 
				 
				 try {
					 serviceS.update(sitedto);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
				 
				 return "redirect:/main";
			}
			 
		//새사이트(site)추가기능
			 @RequestMapping("/siteinsert") 
			 public String siteinsert(SiteDTO sitedto) {
				 try {
					 serviceS.insert(sitedto);
				 } catch (Exception e) {
					 e.printStackTrace();
				 } 
				 return "redirect:/main";
			}
			 
		//사이트 삭제기능(업데이트로 처리)
			 @RequestMapping("/sitedel") 
			 public String siteDel(SiteDTO sitedto, int site_code, int zone_code) {
				 try {
					 serviceS.updateDel(site_code);
				 } catch (Exception e) {
					 e.printStackTrace();
				 } 
				 return "redirect:/zone?zone_code="+zone_code;
			}
		 

//-----------------------------------------------------------------	
	 //구역이미지수정(안됨)
	 @RequestMapping("zoneimgedit")
		public String zoneImgEdit(HttpSession session, ImageDTO imageDTO, MultipartFile zoneImg){
		 CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		 /*
		 ImageDTO zoneimage = null;
		 
		 int company_code = company.getCompany_code();
		 String imgOrgName = zoneImg.getOriginalFilename();
		 
		 try {
			 zoneimage.setCompany_code(company_code);			 
			 zoneimage.setImage_file(imgOrgName);
			 
			 serviceI.zoneUpdate(imageDTO);
			 SaveFile.saveFile(zoneImg, imagesdir);
			 
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		 */
		 return "redirect:/zone";
	 }
	 
	
	
		/*
		 * @RequestMapping("/site") public String site(Model model, int site_code) {
		 * 
		 * try { SiteDTO site = serviceS.selectView(site_code);
		 * model.addAttribute("site", site); } catch (Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * model.addAttribute("center", dir+"site"); return "main"; }
		 */
	
}

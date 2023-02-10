package com.camp.admin.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.camp.admin.DTO.AdminDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.DTO.SiteDTO;
import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.service.ImageService;
import com.camp.admin.service.SiteService;
import com.camp.admin.service.ZoneService;
import com.camp.admin.utility.SaveFile;

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
	public String main(Model model, HttpSession session, int zone_code, ZoneDTO zoneDTO, ImageDTO imageDTO,
			SiteDTO siteDTO, CompanyDTO companyDTO) {

		List<ZoneDTO> listZ = null;
		List<ImageDTO> listI = null;
		List<SiteDTO> listS = null;
		ZoneDTO zonedto = null;

		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		try {
			listZ = serviceZ.selectZone(company.getCompany_code()); // 상호코드
			model.addAttribute("zlist", listZ);

			listI = serviceI.selectByCompanyCode(company.getCompany_code()); // 상호코드
			model.addAttribute("ilist", listI);

			listS = serviceS.selectSet(company.getCompany_code()); // 상호코드
			model.addAttribute("slist", listS);

			zonedto = serviceZ.select(zone_code);
			model.addAttribute("zoneselect", zonedto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("center", dir + "zone");
		return "main";
	}

	// -----------------------------------------------------------------
	// 구역(zone)수정페이지
	@RequestMapping("/zoneedit")
	public String zoneedit(Model model, ImageDTO imageDTO, int zone_code) {
		ZoneDTO zoneEdit = null;
		List<ImageDTO> listI = null;

		try {
			listI = serviceI.selectByZoneCode(zone_code);
			model.addAttribute("ilist", listI);

			zoneEdit = serviceZ.select(zone_code);
			model.addAttribute("zoneEdit", zoneEdit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "zoneedit");
		return "main";
	}

	// 구역(zone)수정기능
	@RequestMapping("/zoneupdate")
	public String zoneupdate(Model model, ZoneDTO zonedto, MultipartFile mf) {

		try {
			ZoneDTO zone = serviceZ.selectForEdit(zonedto.getZone_code());

			serviceZ.update(zonedto);

			if (!mf.isEmpty()) {
				ImageDTO img = serviceI.select(zone.getImage_code());
				serviceI.update(mf, img);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/main";
	}

	// 새 구역(zone)추가페이지
	@RequestMapping("/zoneinsert")
	public String siteinsert(Model model) {
		model.addAttribute("center", dir + "zoneinsert");
		return "main";
	}

	// 구역(zone)추가기능
	@RequestMapping("/zoneadd")
	public String zoneadd(Model model, HttpSession session, String zone_name, String zone_content, MultipartFile mf) {
		AdminDTO admin = (AdminDTO) session.getAttribute("admin");
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		ZoneDTO zone = new ZoneDTO();
		zone.setAdmin_code(admin.getAdmin_code());
		zone.setZone_name(zone_name);
		zone.setZone_content(zone_content);

		try {
			serviceZ.insert(zone);

			if (!mf.isEmpty()) {

				List<ZoneDTO> zonelist = serviceZ.selectAll();

				ImageDTO img = new ImageDTO();
				img.setCompany_code(company.getCompany_code());
				img.setZone_code(zonelist.get(zonelist.size() - 1).getZone_code());
				serviceI.insert(mf, img);

				SaveFile.saveFile(mf, imagesdir,mf.getOriginalFilename());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/main";
	}

	// 구역 삭제기능(업데이트로 처리)
	@RequestMapping("/zonedel")
	public String zoneDel(ZoneDTO zonedto, int zone_code) {
		try {
			serviceZ.updateDel(zone_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/main";
	}

	// -----------------------------------------------------------------
	// 사이트(site)수정페이지
	@RequestMapping("/siteedit")
	public String siteedit(Model model, ImageDTO imageDTO, int site_code) {
		SiteDTO siteedit = null;
		List<ImageDTO> listI = null;

		try {
			listI = serviceI.selectBySiteCode(site_code);
			model.addAttribute("ilist", listI);

			siteedit = serviceS.select(site_code);
			model.addAttribute("siteedit", siteedit);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("center", dir + "siteedit");
		return "main";
	}

	// 사이트(site)수정기능
	@RequestMapping("/siteupdate")
	public String siteupdate(Model model, SiteDTO sitedto, MultipartFile mf) {

		SiteDTO site = serviceS.selectView(sitedto.getSite_code());
		site.setSite_content(sitedto.getSite_content());
		try {
			serviceS.update(site);

			if (!mf.isEmpty()) {

				ImageDTO img = serviceI.select(site.getImage_code());
				serviceI.update(mf, img);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/main";
	}

	// 새사이트(site)추가페이지
	@RequestMapping("/siteinsert")
	public String siteinsert(Model model, int zone_code) {
		model.addAttribute("zone_code", zone_code);
		model.addAttribute("center", dir + "siteinsert");
		return "main";
	}

	// 사이트(site)추가기능
	@RequestMapping("/siteadd")
	public String siteadd(Model model, HttpSession session, String site_name, int site_price, String site_content,
			int zone_code, MultipartFile mf) {
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		SiteDTO site = new SiteDTO();
		site.setSite_name(site_name);
		site.setSite_price(site_price);
		site.setSite_content(site_content);
		site.setZone_code(zone_code);

		try {
			serviceS.insert(site);

			if (!mf.isEmpty()) {

				List<SiteDTO> sitelist = serviceS.selectAll();

				ImageDTO img = new ImageDTO();
				img.setCompany_code(company.getCompany_code());
				img.setSite_code(sitelist.get(sitelist.size() - 1).getSite_code());
				serviceI.insert(mf, img);

				SaveFile.saveFile(mf, imagesdir,mf.getOriginalFilename());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/zone?zone_code=" + zone_code;
	}

	// 사이트 삭제기능(업데이트로 처리)
	@RequestMapping("/sitedel")
	public String siteDel(SiteDTO sitedto, int site_code, int zone_code) {
		try {
			serviceS.updateDel(site_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/zone?zone_code=" + zone_code;
	}

}

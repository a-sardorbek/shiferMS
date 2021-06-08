package com.bek.cement2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bek.cement2.entity.DailyInfo;
import com.bek.cement2.excel.DebitorExcel;
import com.bek.cement2.excel.IshlabChiqarishExcel;
import com.bek.cement2.excel.NarxNavoExcel;
import com.bek.cement2.service.DailyInfoService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewDailyController {
	
	@Autowired
	private DailyInfoService dailyInfoService;
	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Integer id) {
		dailyInfoService.delete(id);
	    return "redirect:/allList_change";       
	}

	//Ishlab chiqarish excelga 
	
	@GetMapping("/i_ch/excel")
    public void i_ch_ToExcel(HttpServletResponse response,
    		                  @Param("start") String start,
    		                  @Param("end") String end) throws IOException {
        response.setContentType("application/octet-stream");
       
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ishlab_chiqarish.xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<DailyInfo> listUsers = dailyInfoService.listPeriodExcel(start,end);
         
       IshlabChiqarishExcel excelExporter = new IshlabChiqarishExcel(listUsers);
         
       excelExporter.export(response);    
    }  
	
	// Narxlar excelga
	
	@GetMapping("/n_n/excel")
    public void narx_ToExcel(HttpServletResponse response,
    		                  @Param("start") String start,
    		                  @Param("end") String end) throws IOException {
        response.setContentType("application/octet-stream");
       
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=narxlar.xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<DailyInfo> listUsers = dailyInfoService.listPeriodExcel(start,end);
         
       NarxNavoExcel excelExporter = new NarxNavoExcel(listUsers);
         
       excelExporter.export(response);    
    } 
	
	//Debitor excelga
	
	@GetMapping("/d/excel")
    public void debitor_ToExcel(HttpServletResponse response,
    		                  @Param("start") String start,
    		                  @Param("end") String end) throws IOException {
        response.setContentType("application/octet-stream");
       
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=debitor.xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<DailyInfo> listUsers = dailyInfoService.listPeriodExcel(start,end);
         
       DebitorExcel excelExporter = new DebitorExcel(listUsers);
         
       excelExporter.export(response);    
    } 
	
	@GetMapping("/showDaily")
	public String show1(Model model
			                 
			                 ) {
		DailyInfo d = new DailyInfo();
		 
		try {
		Page<DailyInfo> page = dailyInfoService.findDebitorOmbor();
		List<DailyInfo> listmalumot = page.getContent();
		model.addAttribute("info", d);
	    model.addAttribute("listDaily", listmalumot);
	   
	    
		}catch (Exception e) {
			
		    return "error";
		}
		return "daily";
		
	}

	@RequestMapping(value = "/saveDaily", method = RequestMethod.POST)
	public String saveMalumot(@Valid
			                  @ModelAttribute("info") DailyInfo d
			                  ,BindingResult result
			                  ,Model model
			                  ) {
		if(result.hasErrors()) {
			System.out.println("Error adding");
			model.addAttribute("listDaily", dailyInfoService.findDebitorOmbor());
			return "daily";
		}else {
		
		try {
			dailyInfoService.addDailyInfo(d);
		}catch (DataIntegrityViolationException e) {
			System.out.println("Error ");
			return "daily";	
		}
		return "redirect:/showDaily";
		}
	}
	
	
	// Debitor Table ------------------
	
	@RequestMapping(value = "/allListDebitor")
	public String show_d(Model model) {
		
		String keyword = null;
		
		return list_d(model, 1, keyword);
	}
	
	
	@GetMapping("/allListDebitor/{pageNumber}")
	public String list_d(Model model, 
			                 @PathVariable("pageNumber") int currentPage
			                 ,@Param("keyword") String keyword) {
		 
		try {
		Page<DailyInfo> page = dailyInfoService.DebitorTable(currentPage,keyword);
		List<DailyInfo> listmalumot = page.getContent();
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
	    model.addAttribute("listDaily", listmalumot);
	    model.addAttribute("keyword", keyword);
	    
		}catch (Exception e) {
			
		    return "error";
		}
		return "debitorTable";
		
	}
	// ------------------ ------------------
	
	
	// Ishlab chiqarish malumoti
	
	@RequestMapping(value = "/allListI_ch")
	public String show_i_ch(Model model) {
		
		String keyword = null;
		
		return list_i_ch(model, 1, keyword);
	}
	
	
	@GetMapping("/allListI_ch/{pageNumber}")
	public String list_i_ch(Model model, 
			                 @PathVariable("pageNumber") int currentPage
			                 ,@Param("keyword") String keyword) {
		 
		try {
		Page<DailyInfo> page = dailyInfoService.DebitorTable(currentPage,keyword);
		List<DailyInfo> listmalumot = page.getContent();
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
	    model.addAttribute("listDaily", listmalumot);
	    model.addAttribute("keyword", keyword);
	    
		}catch (Exception e) {
			
		    return "error";
		}
		return "kunlik_i_ch_Malumot";
		
	}
	
	//--------------- -------------------------
	
	
	// Pul malumoti
	
		@RequestMapping(value = "/allList_Pul")
		public String show_p(Model model) {
			
			String keyword = null;
			
			return list_p(model, 1, keyword);
		}
		
		
		@GetMapping("/allList_Pul/{pageNumber}")
		public String list_p(Model model, 
				                 @PathVariable("pageNumber") int currentPage
				                 ,@Param("keyword") String keyword) {
			 
			try {
			Page<DailyInfo> page = dailyInfoService.DebitorTable(currentPage,keyword);
			List<DailyInfo> listmalumot = page.getContent();
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();
			
			model.addAttribute("totalItems", totalItems);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", totalPages);
		    model.addAttribute("listDaily", listmalumot);
		    model.addAttribute("keyword", keyword);
		    
			}catch (Exception e) {
				
			    return "error";
			}
			return "pulTable";
			
		}
		//------------------ --------------------
	
		@RequestMapping(value = "/allList_change")
		public String show_l_change(Model model) {
			
			String keyword = null;
			
			return list_ch_ch(model, 1, keyword);
		}
		
		
		@GetMapping("/allList_change/{pageNumber}")
		public String list_ch_ch(Model model, 
				                 @PathVariable("pageNumber") int currentPage
				                 ,@Param("keyword") String keyword) {
			 
			try {
			Page<DailyInfo> page = dailyInfoService.DebitorTableDelete(currentPage,keyword);
			List<DailyInfo> listmalumot = page.getContent();
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();
			
			model.addAttribute("totalItems", totalItems);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", totalPages);
		    model.addAttribute("listDaily", listmalumot);
		    model.addAttribute("keyword", keyword);
		    
			}catch (Exception e) {
				
			    return "error";
			}
			return "delete";
			
		}
}

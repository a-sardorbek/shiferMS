package com.bek.cement2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bek.cement2.entity.DailyInfo;
import com.bek.cement2.repository.DailyInfoRepository;

@Service
public class DailyInfoService {

	@Autowired
	private DailyInfoRepository dailyInfoRepository;

	
	Double kg_asbet = 0.0;
	Double kg_sement = 0.0;
	
	
	Integer d_bugun_soni = 0;
	Double bugun_tan_narx = 0.0;
	Double bugun_hamma_xarajat = 0.0;
	Integer bugun_naq_soni = 0;
	Double bugun_naq_narx = 0.0;
	Integer boshlangich_o = 0;
	Double boshlangich_debitor;
	Double debitor_qaytgan_narx = 0.0;
	
	Double o_asbest1 = 0.0;
	Double o_sement1 = 0.0;
	
	Double o_asbest2 = 0.0;
	Double o_sement2 = 0.0;
	
	Double d_bugunXamma_narx = 0.0;
	Double bugun_hamma_narx = 0.0;
	Integer qoldiq_o = 0;
	Double qoldiq_d;
	Integer ishlab_ch = 0;
	Integer brak = 0;
	Integer sotildi_son = 0;
	Double hamma_kirim_sum = 0.0;
	Double farqi = 0.0;
	Integer sof_ombor = 0;
	
	double number1 = 10.123456;
	double number2 = (int)(Math.round(number1 * 100))/100.0;
	
	
	public void addDailyInfo(DailyInfo d) {
	
		ishlab_ch = d.getIshlab_chiqarildi();
		kg_asbet = d.getKetgan_asbest_kg();
		kg_sement = d.getKetgan_sement_kg();
		d_bugun_soni = d.getDebitorga_soni();
		bugun_tan_narx = d.getDona_tan_narx();
		bugun_naq_soni = d.getNaq_soni();
		bugun_naq_narx = d.getNaq_narxi();
		boshlangich_o = d.getBoshlangich_ombor();
		boshlangich_debitor = d.getBoshlangich_debitor();
		debitor_qaytgan_narx = d.getDebitordan_qaytgan_narx();
		brak = d.getBrak_ishlab_chiqarildi();
		
		
		o_sement1 = (kg_asbet / ishlab_ch);
		o_asbest1 = (kg_sement / ishlab_ch);
		
		o_sement2 = (int)(Math.round(o_sement1 * 100))/100.0;
		o_asbest2 = (int)(Math.round(o_asbest1 * 100))/100.0;
		
		d_bugunXamma_narx = (d_bugun_soni * bugun_naq_narx);
		bugun_hamma_xarajat = (ishlab_ch * bugun_tan_narx);
		bugun_hamma_narx = (bugun_naq_narx * bugun_naq_soni);
		qoldiq_d = ((boshlangich_debitor + d_bugunXamma_narx) - debitor_qaytgan_narx);
		qoldiq_o =(boshlangich_o + (ishlab_ch - (d_bugun_soni + bugun_naq_soni) - brak));
		
		sotildi_son = bugun_naq_soni + d_bugun_soni;
		hamma_kirim_sum = bugun_hamma_narx + debitor_qaytgan_narx;
		farqi = hamma_kirim_sum - bugun_hamma_xarajat;
		sof_ombor = ishlab_ch - brak;
		
		d.setOrtacha_asbest(o_asbest2);
		d.setOrtacha_sement(o_sement2);
		d.setHamma_xarajat(bugun_hamma_xarajat);
		d.setDebitorda_hamma_narx(d_bugunXamma_narx);
		d.setNaq_hamma_narx(bugun_hamma_narx);
		d.setDebitorda_qoldiq_narx(qoldiq_d);
		d.setQoldiq_ombor(qoldiq_o);
		d.setSotildi_son(sotildi_son);
		d.setHamma_kirim(hamma_kirim_sum);
		d.setFarqi(farqi);
		d.setIshlab_chiqarildi(sof_ombor);
		
		dailyInfoRepository.save(d);
		
	}
	
	public Page<DailyInfo> DebitorTable(int pageNumber,String keyword){

		Sort sort = Sort.by("sana").descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
		
		if(keyword != null) {
			return dailyInfoRepository.search(keyword, pageable);
		}
		
		return dailyInfoRepository.findAll(pageable);
		}
	
	public Page<DailyInfo> DebitorTableDelete(int pageNumber,String keyword){

		Sort sort = Sort.by("sana").descending();
		
		Pageable pageable = PageRequest.of(pageNumber-1 , 5, sort);
		
		if(keyword != null) {
			return dailyInfoRepository.search(keyword, pageable);
		}
		
		return dailyInfoRepository.findAll(pageable);
		}
	
	
	public Page<DailyInfo> findDebitorOmbor(){

		Sort sort = Sort.by("sana").descending();
		
		Pageable pageable = PageRequest.of(0, 1, sort);
		
		
		return dailyInfoRepository.findAll(pageable);
		}
	


	public List<DailyInfo> listPeriodExcel(String start, String end) {
		
		return dailyInfoRepository.findBydate(start, end);
	}
	
	 public DailyInfo get(Integer id) {
	        return dailyInfoRepository.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	    	dailyInfoRepository.deleteById(id);
	    }
	
}

package com.bek.cement2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dailyinfo") 
public class DailyInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(unique = true) 
	@NotBlank(message = "Sanani kiriting")
	private String sana;
	
	@NotNull(message = "Ishlab chiqarilgan butun sonni kiriting")
	private Integer ishlab_chiqarildi;
	
	@NotNull(message = "Brak sonini kiriting")
	private Integer brak_ishlab_chiqarildi;
	
	@NotNull(message = "Boshlangich omborni kiriting")
	private Integer boshlangich_ombor;
	
	
	@NotNull(message = "Asbestni kiriting")
	private Double ketgan_asbest_kg;
	
	@NotNull(message = "Sementni kiriting")
	private Double ketgan_sement_kg;
	
	@NotNull(message = "Tan Narxni kiriting")
	private Double dona_tan_narx;
	
	@NotNull(message = "Boshlangich Debitorni kiriting")
	private Double boshlangich_debitor;
	
	@NotNull(message = "Debitorga sotilgan sonni kiriting")
	private Integer debitorga_soni;
	
	
	@NotNull(message = "Debitordan qaytgan narxni kiriting")
	private Double debitordan_qaytgan_narx;
	
	@NotNull(message = "Naqtga sotilgan sonni kiriting")
	private Integer naq_soni;
	
	@NotNull(message = "Sotilish narxini kiriting")
	private Double naq_narxi;
	
	
	private Double ortacha_asbest;
	private Double ortacha_sement;
	private Double hamma_xarajat;
	private Double naq_hamma_narx;
	private Double debitorda_hamma_narx;
	private Double debitorda_qoldiq_narx;
	private Integer qoldiq_ombor;
	private Integer sotildi_son;
	private Double farqi;
	private Double hamma_kirim;
	
	public DailyInfo() {}

	

	public DailyInfo(String sana,Integer ishlab_chiqarildi,
			 Integer brak_ishlab_chiqarildi,
			 Integer boshlangich_ombor,
			 Double ketgan_asbest_kg,
			 Double ketgan_sement_kg, Double dona_tan_narx,
			 Double boshlangich_debitor,
			 Integer debitorga_soni,
			 Double debitordan_qaytgan_narx,
			 Integer naq_soni,Double naq_narxi,
			 Double ortacha_asbest, Double ortacha_sement, Double hamma_xarajat, Double naq_hamma_narx,
			 Double debitorda_hamma_narx, Double debitorda_qoldiq_narx, Integer qoldiq_ombor, Integer sotildi_son,Double farqi, Double hamma_kirim) {
		super();
		this.sana = sana;
		this.ishlab_chiqarildi = ishlab_chiqarildi;
		this.brak_ishlab_chiqarildi = brak_ishlab_chiqarildi;
		this.boshlangich_ombor = boshlangich_ombor;
		this.ketgan_asbest_kg = ketgan_asbest_kg;
		this.ketgan_sement_kg = ketgan_sement_kg;
		this.dona_tan_narx = dona_tan_narx;
		this.boshlangich_debitor = boshlangich_debitor;
		this.debitorga_soni = debitorga_soni;
		this.debitordan_qaytgan_narx = debitordan_qaytgan_narx;
		this.naq_soni = naq_soni;
		this.naq_narxi = naq_narxi;
		this.ortacha_asbest = ortacha_asbest;
		this.ortacha_sement = ortacha_sement;
		this.hamma_xarajat = hamma_xarajat;
		this.naq_hamma_narx = naq_hamma_narx;
		this.debitorda_hamma_narx = debitorda_hamma_narx;
		this.debitorda_qoldiq_narx = debitorda_qoldiq_narx;
		this.qoldiq_ombor = qoldiq_ombor;
		this.sotildi_son = sotildi_son;
		this.farqi = farqi;
		this.hamma_kirim = hamma_kirim;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSana() {
		return sana;
	}

	public void setSana(String sana) {
		this.sana = sana;
	}

	public Integer getIshlab_chiqarildi() {
		return ishlab_chiqarildi;
	}

	public void setIshlab_chiqarildi(Integer ishlab_chiqarildi) {
		this.ishlab_chiqarildi = ishlab_chiqarildi;
	}

	public Integer getBrak_ishlab_chiqarildi() {
		return brak_ishlab_chiqarildi;
	}

	public void setBrak_ishlab_chiqarildi(Integer brak_ishlab_chiqarildi) {
		this.brak_ishlab_chiqarildi = brak_ishlab_chiqarildi;
	}

	public Integer getBoshlangich_ombor() {
		return boshlangich_ombor;
	}

	public void setBoshlangich_ombor(Integer boshlangich_ombor) {
		this.boshlangich_ombor = boshlangich_ombor;
	}

	public Double getKetgan_asbest_kg() {
		return ketgan_asbest_kg;
	}

	public void setKetgan_asbest_kg(Double ketgan_asbest_kg) {
		this.ketgan_asbest_kg = ketgan_asbest_kg;
	}

	public Double getKetgan_sement_kg() {
		return ketgan_sement_kg;
	}

	public void setKetgan_sement_kg(Double ketgan_sement_kg) {
		this.ketgan_sement_kg = ketgan_sement_kg;
	}

	public Double getDona_tan_narx() {
		return dona_tan_narx;
	}

	public void setDona_tan_narx(Double dona_tan_narx) {
		this.dona_tan_narx = dona_tan_narx;
	}

	public Double getBoshlangich_debitor() {
		return boshlangich_debitor;
	}

	public void setBoshlangich_debitor(Double boshlangich_debitor) {
		this.boshlangich_debitor = boshlangich_debitor;
	}

	public Integer getDebitorga_soni() {
		return debitorga_soni;
	}

	public void setDebitorga_soni(Integer debitorga_soni) {
		this.debitorga_soni = debitorga_soni;
	}

	

	public Double getDebitordan_qaytgan_narx() {
		return debitordan_qaytgan_narx;
	}

	public void setDebitordan_qaytgan_narx(Double debitordan_qaytgan_narx) {
		this.debitordan_qaytgan_narx = debitordan_qaytgan_narx;
	}

	public Integer getNaq_soni() {
		return naq_soni;
	}

	public void setNaq_soni(Integer naq_soni) {
		this.naq_soni = naq_soni;
	}

	public Double getNaq_narxi() {
		return naq_narxi;
	}

	public void setNaq_narxi(Double naq_narxi) {
		this.naq_narxi = naq_narxi;
	}

	public Double getOrtacha_asbest() {
		return ortacha_asbest;
	}

	public void setOrtacha_asbest(Double ortacha_asbest) {
		this.ortacha_asbest = ortacha_asbest;
	}

	public Double getOrtacha_sement() {
		return ortacha_sement;
	}

	public void setOrtacha_sement(Double ortacha_sement) {
		this.ortacha_sement = ortacha_sement;
	}

	public Double getHamma_xarajat() {
		return hamma_xarajat;
	}

	public void setHamma_xarajat(Double hamma_xarajat) {
		this.hamma_xarajat = hamma_xarajat;
	}

	public Double getNaq_hamma_narx() {
		return naq_hamma_narx;
	}

	public void setNaq_hamma_narx(Double naq_hamma_narx) {
		this.naq_hamma_narx = naq_hamma_narx;
	}

	public Double getDebitorda_hamma_narx() {
		return debitorda_hamma_narx;
	}

	public void setDebitorda_hamma_narx(Double debitorda_hamma_narx) {
		this.debitorda_hamma_narx = debitorda_hamma_narx;
	}

	public Double getDebitorda_qoldiq_narx() {
		return debitorda_qoldiq_narx;
	}

	public void setDebitorda_qoldiq_narx(Double debitorda_qoldiq_narx) {
		this.debitorda_qoldiq_narx = debitorda_qoldiq_narx;
	}


	public Integer getQoldiq_ombor() {
		return qoldiq_ombor;
	}

	public void setQoldiq_ombor(Integer qoldiq_ombor) {
		this.qoldiq_ombor = qoldiq_ombor;
	}

	public Integer getSotildi_son() {
		return sotildi_son;
	}

	public void setSotildi_son(Integer sotildi_son) {
		this.sotildi_son = sotildi_son;
	}



	public Double getFarqi() {
		return farqi;
	}



	public void setFarqi(Double farqi) {
		this.farqi = farqi;
	}



	public Double getHamma_kirim() {
		return hamma_kirim;
	}



	public void setHamma_kirim(Double hamma_kirim) {
		this.hamma_kirim = hamma_kirim;
	}



	@Override
	public String toString() {
		return "DailyInfo [id=" + id + ", sana=" + sana + ", ishlab_chiqarildi=" + ishlab_chiqarildi
				+ ", brak_ishlab_chiqarildi=" + brak_ishlab_chiqarildi + ", boshlangich_ombor=" + boshlangich_ombor
				+ ", ketgan_asbest_kg=" + ketgan_asbest_kg + ", ketgan_sement_kg=" + ketgan_sement_kg
				+ ", dona_tan_narx=" + dona_tan_narx + ", boshlangich_debitor=" + boshlangich_debitor
				+ ", debitorga_soni=" + debitorga_soni + ", debitordan_qaytgan_narx=" + debitordan_qaytgan_narx
				+ ", naq_soni=" + naq_soni + ", naq_narxi=" + naq_narxi + ", ortacha_asbest=" + ortacha_asbest
				+ ", ortacha_sement=" + ortacha_sement + ", hamma_xarajat=" + hamma_xarajat + ", naq_hamma_narx="
				+ naq_hamma_narx + ", debitorda_hamma_narx=" + debitorda_hamma_narx + ", debitorda_qoldiq_narx="
				+ debitorda_qoldiq_narx + ", qoldiq_ombor=" + qoldiq_ombor + ", sotildi_son=" + sotildi_son + ", farqi="
				+ farqi + ", hamma_kirim=" + hamma_kirim + "]";
	}



	

	
	
	
	
	
	}

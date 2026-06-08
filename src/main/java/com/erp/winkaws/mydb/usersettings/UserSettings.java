package com.erp.winkaws.mydb.usersettings;

import com.erp.winkaws.mydb.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WinkaErpUserSettings")
public class UserSettings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Short subeId;

	private Short kasaId;

	private Short winkaKullaniciId;

	private Integer cariOzelKod3Id;

	private Double iskontoOrani;

	private String satisFaturasiDizayn;

	private String satisIadeFaturasiDizayn;

	private String alisFaturasiDizayn;

	private String alisIadeFaturasiDizayn;

	private String alinanSiparisDizayn;

	private String verilenSiparisDizayn;

	private String depoTransferDizayn;

	private String stokCikisBelgesiDizayn;

	private String stokGirisBelgesiDizayn;

	private String cariCikisDizayn;

	private String cariGirisDizayn;

	private String yaziciAdi;
	
	@OneToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	
}

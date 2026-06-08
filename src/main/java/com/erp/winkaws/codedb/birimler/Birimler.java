package com.erp.winkaws.codedb.birimler;

import java.math.BigDecimal;
import java.util.Date;

import com.erp.winkaws.codedb.barkodlar.Barkodlar;
import com.erp.winkaws.codedb.stoklar.Stoklar;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Birimler", schema = "dto", catalog = "CodeDB_1")
public class Birimler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Adi", length = 5)
	private String adi;

	@Column(name = "Aciklama", length = 10)
	private String aciklama;

	@Column(name = "Carpan")
	private BigDecimal carpan;

	@Column(name = "KDVGrubu")
	private Byte kdvGrubu;

	@Column(name = "KDVDahil")
	private Boolean kdvDahil;

	@Column(name = "OTVGrubu")
	private Byte otvGrubu;

	@Column(name = "Maliyeti")
	private BigDecimal maliyeti;

	@Column(name = "Opsiyon")
	private Byte opsiyon;

	@Column(name = "FiyatDegistirmeTarihi")
	private Date fiyatDegistirmeTarihi;

	@Column(name = "Fiyat1")
	private BigDecimal fiyat1;

	@Column(name = "PB1", length = 3)
	private String pb1;

	@Column(name = "Fiyat2")
	private BigDecimal fiyat2;

	@Column(name = "PB2", length = 3)
	private String pb2;

	@Column(name = "Fiyat3")
	private BigDecimal fiyat3;  

	@Column(name = "PB3", length = 3)
	private String pb3;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "BarkodId")
	private Barkodlar barkod;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "StokId")
	private Stoklar stok;

}

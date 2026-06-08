package com.erp.winkaws.codedb.birimler.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.erp.winkaws.codedb.barkodlar.Barkodlar;
import com.erp.winkaws.codedb.stoklar.Stoklar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BirimlerUpdateDTO {
	
	private Integer id;

	private String adi;

	private String aciklama;

	private BigDecimal carpan;

	private Byte kdvGrubu;

	private Boolean kdvDahil;

	private Byte otvGrubu;

	private BigDecimal maliyeti;

	private Byte opsiyon;

	private Date fiyatDegistirmeTarihi;

	private BigDecimal fiyat1;

	private String pb1;

	private BigDecimal fiyat2;

	private String pb2;

	private BigDecimal fiyat3;

	private String pb3;

	private Barkodlar barkod;

	private Stoklar stok;

}

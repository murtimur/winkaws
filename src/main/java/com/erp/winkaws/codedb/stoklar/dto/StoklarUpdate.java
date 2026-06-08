package com.erp.winkaws.codedb.stoklar.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoklarUpdate {

	private Integer id;

    private String stokKodu;

    private String stokAdi;

    private Byte stokTipi;

    private Integer anaBirim;

    private Integer varsayilanBirim;

    private Integer siparisBirimi;

    private Byte durum;

    private Integer ozelKod0;

    private Integer ozelKod1;

    private Integer ozelKod2;

    private Integer ozelKod3;

    private Integer ozelKod4;

    private Integer ozelKod5;

    private Integer ozelKod6;

    private Integer ozelKod7;

    private Integer ozelKod8;

    private Integer ozelKod9;

    private Integer ozelKod10;

    private Integer ozelKod11;

    private Integer ozelKod12;

    private BigDecimal kritikSeviye;

    private BigDecimal optimumSeviye;

    private Boolean hemenTeslim;

    private LocalDateTime tarih;

    private Short kurulumSuresi;

    private BigDecimal prim;

    private Byte taksit;

    private BigDecimal alisFiyati;

    private String alisPB;

    private String tanimi;

    private Integer grubu;

    private Integer hesapId;

    private BigDecimal satisIskonto;

    private BigDecimal alisIskonto;

    private String seri;

    private String gtip;
	
}

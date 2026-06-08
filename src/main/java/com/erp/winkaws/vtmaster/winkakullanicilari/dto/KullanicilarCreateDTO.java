package com.erp.winkaws.vtmaster.winkakullanicilari.dto;

import java.math.BigDecimal;

public record KullanicilarCreateDTO(Short id, Byte durum, Byte tipi, String kodu, String adi, String sifresi,
		Short subeId, Short varsayilanKasaId, Byte maxTaksitSayisi, Byte otomatikTaksitSayisi, Boolean karZararGorur,
		Boolean musteriDuzenler, BigDecimal maxIskontoOrani, Boolean fiyatDegistirir, String kasalar,
		Boolean yeniSatisEkrani, Boolean satisDuzenleEkrani, Byte donemYetkisi, BigDecimal hsFontSize,
		Boolean stokListesiGelmesin, Boolean odemeAlincaOtomatikYazdir, Boolean fkasaHareketleri, Boolean fhizliSatis,
		Boolean fstokBelgeleri, Boolean fsevkFisi, Boolean fbordrolar, Boolean favukataVerme, Boolean altIskontoYapamaz,
		Boolean stokDuzenler, Boolean ayarlarEkrani, Boolean patronEkrani, Boolean subeAyrintisi, Byte hsyetkisi,
		Boolean gizliCari) {

}

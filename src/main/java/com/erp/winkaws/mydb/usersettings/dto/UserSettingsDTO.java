package com.erp.winkaws.mydb.usersettings.dto;

public record UserSettingsDTO(Integer id, Short subeId, Short kasaId, Short winkaKullaniciId, Integer cariOzelKod3Id,
		Double iskontoOrani, String satisFaturasiDizayn, String satisIadeFaturasiDizayn, String alisFaturasiDizayn,
		String alisIadeFaturasiDizayn, String alinanSiparisDizayn, String verilenSiparisDizayn,
		String depoTransferDizayn, String stokCikisBelgesiDizayn, String stokGirisBelgesiDizayn, String cariCikisDizayn,
		String cariGirisDizayn, String yaziciAdi) {

}

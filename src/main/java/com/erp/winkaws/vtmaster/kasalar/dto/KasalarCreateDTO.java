package com.erp.winkaws.vtmaster.kasalar.dto;

public record KasalarCreateDTO(Byte durum, Short subeId, String kodu, String adi, String satisFaturasi,
		String satisIrsaliyesi, Byte tipi, Byte kasaNo, Byte baglanti, Integer hesapId, String eFatura, String eArsiv,
		Byte baglantiSekli, String ip, Integer tcpPort, String seriNo) {

}

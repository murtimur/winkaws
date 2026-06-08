package com.erp.winkaws.vtmaster.subeler.dto;

public record SubelerCreateDTO(Short id, Byte durum, Integer firmaId, String kodu, String adi, String musteriHarfi,
		String belgeHarfi, Short otomatikSenetAl, Byte hsfaturaFiyati, Byte pesinSatisFiyati, Byte sarfFiyati,
		Byte sayimGirisFiyati, Byte girisFiyati, Byte cikisFiyati, Boolean kdvgiris, Boolean kdvcikis, String fiyatlar,
		Byte hsfaturaNav, Byte pesinSatisNav, Byte sarfNav, Byte sayimGirisNav, Byte girisNav, Byte cikisNav,
		Byte baglantiSekli, Integer cariId, String yetkili, String adres, Integer ilceId, String postaKodu,
		String telefon1, String telefon2, String gsm, String faks, String email, String postaKutusu,
		String gondericiBirim) {

}

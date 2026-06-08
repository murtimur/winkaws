package com.erp.winkaws.vtmaster.subeler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subeler {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Short id;

    @Column(name = "Durum")
    private Byte durum;

    @Column(name = "FirmaId")
    private Integer firmaId;

    @Column(name = "Kodu", length = 10)
    private String kodu;

    @Column(name = "Adi", length = 20)
    private String adi;

    @Column(name = "MusteriHarfi", length = 2)
    private String musteriHarfi;

    @Column(name = "BelgeHarfi", length = 2)
    private String belgeHarfi;

    @Column(name = "OtomatikSenetAl")
    private Short otomatikSenetAl;

    @Column(name = "HSFaturaFiyati")
    private Byte hsfaturaFiyati;

    @Column(name = "PesinSatisFiyati")
    private Byte pesinSatisFiyati;

    @Column(name = "SarfFiyati")
    private Byte sarfFiyati;

    @Column(name = "SayimGirisFiyati")
    private Byte sayimGirisFiyati;

    @Column(name = "GirisFiyati")
    private Byte girisFiyati;

    @Column(name = "CikisFiyati")
    private Byte cikisFiyati;

    @Column(name = "KDVGiris")
    private Boolean kdvgiris;

    @Column(name = "KDVCikis")
    private Boolean kdvcikis;

    @Column(name = "Fiyatlar", length = 50)
    private String fiyatlar;

    @Column(name = "HSFaturaNav")
    private Byte hsfaturaNav;

    @Column(name = "PesinSatisNav")
    private Byte pesinSatisNav;

    @Column(name = "SarfNav")
    private Byte sarfNav;

    @Column(name = "SayimGirisNav")
    private Byte sayimGirisNav;

    @Column(name = "GirisNav")
    private Byte girisNav;

    @Column(name = "CikisNav")
    private Byte cikisNav;

    @Column(name = "BaglantiSekli")
    private Byte baglantiSekli;

    @Column(name = "CariId")
    private Integer cariId;

    @Column(name = "Yetkili", length = 20)
    private String yetkili;

    @Column(name = "Adres", length = 500)
    private String adres;

    @Column(name = "IlceId")
    private Integer ilceId;

    @Column(name = "PostaKodu", length = 5)
    private String postaKodu;

    @Column(name = "Telefon1", length = 20)
    private String telefon1;

    @Column(name = "Telefon2", length = 20)
    private String telefon2;

    @Column(name = "GSM", length = 20)
    private String gsm;

    @Column(name = "Faks", length = 20)
    private String faks;

    @Column(name = "EMail", length = 50)
    private String email;

    @Column(name = "PostaKutusu", length = 100)
    private String postaKutusu;

    @Column(name = "GondericiBirim", length = 100)
    private String gondericiBirim;

}

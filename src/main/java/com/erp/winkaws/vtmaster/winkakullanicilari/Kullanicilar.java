package com.erp.winkaws.vtmaster.winkakullanicilari;

import java.math.BigDecimal;

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
public class Kullanicilar {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Short id;

    @Column(name = "Durum")
    private Byte durum;

    @Column(name = "Tipi")
    private Byte tipi;

    @Column(name = "Kodu", length = 10)
    private String kodu;

    @Column(name = "Adi", length = 30)
    private String adi;

    @Column(name = "Sifresi", length = 10)
    private String sifresi;

    @Column(name = "SubeId")
    private Short subeId;

    @Column(name = "VarsayilanKasaId")
    private Short varsayilanKasaId;

    @Column(name = "MaxTaksitSayisi")
    private Byte maxTaksitSayisi;

    @Column(name = "OtomatikTaksitSayisi")
    private Byte otomatikTaksitSayisi;

    @Column(name = "KarZararGorur")
    private Boolean karZararGorur;

    @Column(name = "MusteriDuzenler")
    private Boolean musteriDuzenler;

    @Column(name = "MaxIskontoOrani", precision = 9, scale = 4)
    private BigDecimal maxIskontoOrani;

    @Column(name = "FiyatDegistirir")
    private Boolean fiyatDegistirir;

    @Column(name = "Kasalar", length = 100)
    private String kasalar;

    @Column(name = "YeniSatisEkrani")
    private Boolean yeniSatisEkrani;

    @Column(name = "SatisDuzenleEkrani")
    private Boolean satisDuzenleEkrani;

    @Column(name = "DonemYetkisi")
    private Byte donemYetkisi;

    @Column(name = "HSFontSize", precision = 9, scale = 4)
    private BigDecimal hsFontSize;

    @Column(name = "StokListesiGelmesin")
    private Boolean stokListesiGelmesin;

    @Column(name = "OdemeAlincaOtomatikYazdir")
    private Boolean odemeAlincaOtomatikYazdir;

    @Column(name = "FKasaHareketleri")
    private Boolean fkasaHareketleri;

    @Column(name = "FHizliSatis")
    private Boolean fhizliSatis;

    @Column(name = "FStokBelgeleri")
    private Boolean fstokBelgeleri;

    @Column(name = "FSevkFisi")
    private Boolean fsevkFisi;

    @Column(name = "FBordrolar")
    private Boolean fbordrolar;

    @Column(name = "FAvukataVerme")
    private Boolean favukataVerme;

    @Column(name = "AltIskontoYapamaz")
    private Boolean altIskontoYapamaz;

    @Column(name = "StokDuzenler")
    private Boolean stokDuzenler;

    @Column(name = "AyarlarEkrani")
    private Boolean ayarlarEkrani;

    @Column(name = "PatronEkrani")
    private Boolean patronEkrani;

    @Column(name = "SubeAyrintisi")
    private Boolean subeAyrintisi;

    @Column(name = "HSYetkisi")
    private Byte hsyetkisi;

    @Column(name = "GizliCari")
    private Boolean gizliCari;

}

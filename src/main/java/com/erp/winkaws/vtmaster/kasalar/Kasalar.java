package com.erp.winkaws.vtmaster.kasalar;

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
public class Kasalar {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Short id;

    @Column(name = "Durum")
    private Byte durum;

    @Column(name = "SubeId")
    private Short subeId;

    @Column(name = "Kodu", length = 10)
    private String kodu;

    @Column(name = "Adi", length = 20)
    private String adi;

    @Column(name = "SatisFaturasi", length = 10)
    private String satisFaturasi;

    @Column(name = "SatisIrsaliyesi", length = 10)
    private String satisIrsaliyesi;

    @Column(name = "Tipi")
    private Byte tipi;

    @Column(name = "KasaNo")
    private Byte kasaNo;

    @Column(name = "Baglanti")
    private Byte baglanti;

    @Column(name = "HesapId")
    private Integer hesapId;

    @Column(name = "EFatura", length = 10)
    private String eFatura;

    @Column(name = "EArsiv", length = 10)
    private String eArsiv;

    @Column(name = "BaglantiSekli")
    private Byte baglantiSekli;

    @Column(name = "Ip", length = 15)
    private String ip;

    @Column(name = "TcpPort")
    private Integer tcpPort;

    @Column(name = "SeriNo", length = 20)
    private String seriNo;
	
}

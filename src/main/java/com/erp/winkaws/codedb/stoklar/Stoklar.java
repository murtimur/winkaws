package com.erp.winkaws.codedb.stoklar;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.erp.winkaws.codedb.birimler.Birimler;
import com.erp.winkaws.codedb.stokrbk.StokRBK;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Stoklar", schema = "dbo", catalog = "CodeDB_1")
public class Stoklar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "StokKodu", length = 40)
    private String stokKodu;

    @Column(name = "StokAdi", length = 80)
    private String stokAdi;

    @Column(name = "StokTipi")
    private Byte stokTipi;

    @Column(name = "AnaBirim")
    private Integer anaBirim;

    @Column(name = "VarsayilanBirim")
    private Integer varsayilanBirim;

    @Column(name = "SiparisBirimi")
    private Integer siparisBirimi;

    @Column(name = "Durum")
    private Byte durum;

    @Column(name = "OzelKod0")
    private Integer ozelKod0;

    @Column(name = "OzelKod1")
    private Integer ozelKod1;

    @Column(name = "OzelKod2")
    private Integer ozelKod2;

    @Column(name = "OzelKod3")
    private Integer ozelKod3;

    @Column(name = "OzelKod4")
    private Integer ozelKod4;

    @Column(name = "OzelKod5")
    private Integer ozelKod5;

    @Column(name = "OzelKod6")
    private Integer ozelKod6;

    @Column(name = "OzelKod7")
    private Integer ozelKod7;

    @Column(name = "OzelKod8")
    private Integer ozelKod8;

    @Column(name = "OzelKod9")
    private Integer ozelKod9;

    @Column(name = "OzelKod10")
    private Integer ozelKod10;

    @Column(name = "OzelKod11")
    private Integer ozelKod11;

    @Column(name = "OzelKod12")
    private Integer ozelKod12;

    @Column(name = "KritikSeviye", precision = 18, scale = 4)
    private BigDecimal kritikSeviye;

    @Column(name = "OptimumSeviye", precision = 18, scale = 4)
    private BigDecimal optimumSeviye;

    @Column(name = "HemenTeslim")
    private Boolean hemenTeslim;

    @Column(name = "Tarih")
    private LocalDateTime tarih;

    @Column(name = "KurulumSuresi")
    private Short kurulumSuresi;

    @Column(name = "Prim", precision = 9, scale = 4)
    private BigDecimal prim;

    @Column(name = "Taksit")
    private Byte taksit;

    @Column(name = "AlisFiyati", precision = 18, scale = 4)
    private BigDecimal alisFiyati;

    @Column(name = "AlisPB", length = 3)
    private String alisPB;

    @Column(name = "Tanimi", length = 500)
    private String tanimi;

    @Column(name = "Grubu")
    private Integer grubu;

    @Column(name = "HesapId")
    private Integer hesapId;

    @Column(name = "SatisIskonto", precision = 9, scale = 4)
    private BigDecimal satisIskonto;

    @Column(name = "AlisIskonto", precision = 9, scale = 4)
    private BigDecimal alisIskonto;

    @Column(name = "Seri", length = 50)
    private String seri;

    @Column(name = "GTIP", length = 20)
    private String gtip;
    
    @OneToMany(mappedBy = "stok", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Birimler> birimler;
    
    @OneToMany(mappedBy = "stok", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StokRBK> stokRBKList;
    
}

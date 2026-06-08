package com.erp.winkaws.codedb.etiket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Etiket", schema = "dbo", catalog = "CodeDB_1")
public class Etiket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "BirimId")
	private Integer birimId;

	@Column(name = "StokId")
	private Integer stokId;

	@Column(name = "StokKodu", length = 50)
	private String stokKodu;

	@Column(name = "StokAdi", length = 80)
	private String stokAdi;

	@Column(name = "Adet")
	private Integer adet;

	@Column(name = "Barkod", length = 200)
	private String barkod;

	@Column(name = "Fiyat1", precision = 18, scale = 4)
	private BigDecimal fiyat1;

	@Column(name = "Fiyat2", precision = 18, scale = 4)
	private BigDecimal fiyat2;

	@Column(name = "Fiyat3", precision = 18, scale = 4)
	private BigDecimal fiyat3;

	@Column(name = "Fiyat4", precision = 18, scale = 4)
	private BigDecimal fiyat4;

	@Column(name = "Fiyat5", precision = 18, scale = 4)
	private BigDecimal fiyat5;

	@Column(name = "Fiyat6", precision = 18, scale = 4)
	private BigDecimal fiyat6;

	@Column(name = "Fiyat7", precision = 18, scale = 4)
	private BigDecimal fiyat7;

	@Column(name = "Fiyat8", precision = 18, scale = 4)
	private BigDecimal fiyat8;

	@Column(name = "Fiyat9", precision = 18, scale = 4)
	private BigDecimal fiyat9;

	@Column(name = "Fiyat10", precision = 18, scale = 4)
	private BigDecimal fiyat10;

	@Column(name = "Fiyat11", precision = 18, scale = 4)
	private BigDecimal fiyat11;

	@Column(name = "Fiyat12", precision = 18, scale = 4)
	private BigDecimal fiyat12;

	@Column(name = "Fiyat13", precision = 18, scale = 4)
	private BigDecimal fiyat13;

	@Column(name = "Fiyat14", precision = 18, scale = 4)
	private BigDecimal fiyat14;

	@Column(name = "Fiyat15", precision = 18, scale = 4)
	private BigDecimal fiyat15;

	@Column(name = "PB1", length = 3)
	private String pb1;

	@Column(name = "PB2", length = 3)
	private String pb2;

	@Column(name = "PB3", length = 3)
	private String pb3;

	@Column(name = "PB4", length = 3)
	private String pb4;

	@Column(name = "PB5", length = 3)
	private String pb5;

	@Column(name = "PB6", length = 3)
	private String pb6;

	@Column(name = "PB7", length = 3)
	private String pb7;

	@Column(name = "PB8", length = 3)
	private String pb8;

	@Column(name = "PB9", length = 3)
	private String pb9;

	@Column(name = "PB10", length = 3)
	private String pb10;

	@Column(name = "PB11", length = 3)
	private String pb11;

	@Column(name = "PB12", length = 3)
	private String pb12;

	@Column(name = "PB13", length = 3)
	private String pb13;

	@Column(name = "PB14", length = 3)
	private String pb14;

	@Column(name = "PB15", length = 3)
	private String pb15;

	@Column(name = "KullaniciId")
	private Short kullaniciId;

	@Column(name = "Tarih")
	private LocalDateTime tarih;

}

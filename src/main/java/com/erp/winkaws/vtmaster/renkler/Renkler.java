package com.erp.winkaws.vtmaster.renkler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Renkler", schema = "dbo", catalog = "vtmaster")
public class Renkler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Adi")
	private String adi;
	
	@Column(name = "Renk")
	private Integer renk;
	
	@Column(name = "Kodu")
	private String kodu;

}

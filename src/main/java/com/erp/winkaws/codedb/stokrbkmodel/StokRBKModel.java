package com.erp.winkaws.codedb.stokrbkmodel;

import java.util.List;

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
@Table(name = "StokRBKModel", schema = "dto", catalog = "CodeDB_1")
public class StokRBKModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Kodu", length = 20)
	private String kodu;

	@Column(name = "Adi", length = 60)
	private String adi;

	@Column(name = "BedenTipi")
	private Integer bedenTipi;

	@Column(name = "KavalaTipi")
	private Integer kavalaTipi;

	@Column(name = "Fiyatlandirma")
	private Byte fiyatlandirma;

	@Column(name = "AsortiId")
	private Integer asortiId;
	
	@OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StokRBK> stokRBKList;

}

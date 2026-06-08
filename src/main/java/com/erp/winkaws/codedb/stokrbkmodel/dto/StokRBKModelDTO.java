package com.erp.winkaws.codedb.stokrbkmodel.dto;

import java.util.List;

import com.erp.winkaws.codedb.stokrbk.StokRBK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StokRBKModelDTO {

	private Integer id;

	private String kodu;

	private String adi;

	private Integer bedenTipi;

	private Integer kavalaTipi;

	private Byte fiyatlandirma;

	private Integer asortiId;

	private List<StokRBK> stokRBKList;

}

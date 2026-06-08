package com.erp.winkaws.codedb.stokrbk.dto;

import com.erp.winkaws.codedb.stoklar.Stoklar;
import com.erp.winkaws.codedb.stokrbkmodel.StokRBKModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StokRBKDTO {

	private Integer id;

	private Integer renk;

	private String beden;

	private String kavala;

	private Stoklar stok;

	private StokRBKModel model;

}

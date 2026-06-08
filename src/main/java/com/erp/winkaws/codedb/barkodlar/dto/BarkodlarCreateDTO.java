package com.erp.winkaws.codedb.barkodlar.dto;

import com.erp.winkaws.codedb.birimler.Birimler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BarkodlarCreateDTO {

	private Integer id;

	private Short std;

	private String barkodu;

	private Birimler birimler;
	
}

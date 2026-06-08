package com.erp.winkaws.vtmaster.renkler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RenklerUpdateDTO {

	private Integer id;

	private String adi;

	private Integer renk;

	private String kodu;

}

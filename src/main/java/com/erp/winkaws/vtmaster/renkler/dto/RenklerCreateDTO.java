package com.erp.winkaws.vtmaster.renkler.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RenklerCreateDTO {

	private Integer id;

	@NotBlank
	private String adi;

	private Integer renk;

	@NotBlank
	private String kodu;

}

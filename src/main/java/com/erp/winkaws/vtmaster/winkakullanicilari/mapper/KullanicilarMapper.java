package com.erp.winkaws.vtmaster.winkakullanicilari.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.erp.winkaws.vtmaster.winkakullanicilari.Kullanicilar;
import com.erp.winkaws.vtmaster.winkakullanicilari.dto.KullanicilarCreateDTO;
import com.erp.winkaws.vtmaster.winkakullanicilari.dto.KullanicilarDTO;
import com.erp.winkaws.vtmaster.winkakullanicilari.dto.KullanicilarUpdateDTO;

@Mapper(componentModel = "spring")
public interface KullanicilarMapper {

	KullanicilarDTO toDTO(Kullanicilar entity);
	
	Kullanicilar toEntity(KullanicilarCreateDTO dto);
	
	void update(KullanicilarUpdateDTO dto, @MappingTarget Kullanicilar entity);
	
}

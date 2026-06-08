package com.erp.winkaws.vtmaster.winkakullanicilari;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KullanicilarRepository extends JpaRepository<Kullanicilar, Short> {

	List<Kullanicilar> findByDurum(Byte durum);
	
}

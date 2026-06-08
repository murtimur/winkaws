package com.erp.winkaws.codedb.stoklar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StoklarRepository extends JpaRepository<Stoklar, Integer> {
	
	Stoklar findByStokKodu(String stokKodu);
	
	List<Stoklar> findByStokKoduContaining(String stokKodu);

}

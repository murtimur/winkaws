package com.erp.winkaws.vtmaster.subeler;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubelerRepository extends JpaRepository<Subeler, Short> {

	List<Subeler> findByDurum(Byte durum);
	
}

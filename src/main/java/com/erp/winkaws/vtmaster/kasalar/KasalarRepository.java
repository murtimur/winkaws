package com.erp.winkaws.vtmaster.kasalar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KasalarRepository extends JpaRepository<Kasalar, Short> {
	
	List<Kasalar> findByDurum(Byte durum);

}

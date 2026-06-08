package com.erp.winkaws.printer;

import java.util.List;

public interface PrinterRepository {

	List<Printer> findAll();
	
}

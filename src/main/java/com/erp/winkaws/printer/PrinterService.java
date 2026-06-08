package com.erp.winkaws.printer;

import java.util.Arrays;
import java.util.List;

import javax.print.PrintServiceLookup;

import org.springframework.stereotype.Service;

@Service
public class PrinterService implements PrinterRepository {

	@Override
	public List<Printer> findAll() {
		return Arrays.stream(PrintServiceLookup.lookupPrintServices(null, null))
				.map(ps -> new Printer(ps.getName(), ps.getName())).toList();
	}

}

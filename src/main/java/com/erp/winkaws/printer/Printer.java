package com.erp.winkaws.printer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Printer {

	private String id;
	
	private String adi;

	public Printer() {
		super();
	}

	public Printer(String id, String adi) {
		super();
		this.id = id;
		this.adi = adi;
	}
	
}

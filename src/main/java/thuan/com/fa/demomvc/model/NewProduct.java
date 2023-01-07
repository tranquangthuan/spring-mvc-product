package thuan.com.fa.demomvc.model;

import javax.validation.constraints.NotBlank;

import thuan.com.fa.demomvc.annotation.UniqueSerial;

public class NewProduct {
	@NotBlank(message = "vui long nhap nam")
	private String name;
	@UniqueSerial
	private String serial;

	public NewProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewProduct(String name, String serial) {
		super();
		this.name = name;
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

}

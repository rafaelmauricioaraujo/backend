package br.dev.rafael.cyberspace.config.validation;

public class ErrorFormDto {
	
	private String field;
	private String err;
	
	public ErrorFormDto(String field, String err) {
		this.field = field;
		this.err = err;
	}
	public String getField() {
		return field;
	}
	
	public String getErr() {
		return err;
	}
}

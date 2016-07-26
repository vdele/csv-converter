package com.vdel.tools.convertcsv.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Error class for Report BO
 * @author Valentin Delepaut
 *
 */
public class Error {
	
	private int line;
	private String message;
	private String value;
	public int getLine() {
		return line;
	}
	
	@XmlAttribute
	public void setLine(int line) {
		this.line = line;
	}
	public String getMessage() {
		return message;
	}
	
	@XmlAttribute
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValue() {
		return value;
	}
	
	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		return "line:"+line+";message:"+message+";value:"+value;
	}
	
	
}

package com.vdel.tools.convertcsv.bo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Reference class for Report BO
 * @author Val
 *
 */
@XmlRootElement
public class Reference {
	
	private String referenceNumber;
	private char color;
	private double price;
	private int size;
	public String getReferenceNumber() {
		return referenceNumber;
	}
	
	@XmlAttribute
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public char getColor() {
		return color;
	}
	
	@XmlAttribute
	public void setColor(char color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	
	@XmlAttribute
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	
	@XmlAttribute
	public void setSize(int size) {
		this.size = size;
	}
	
	public String toString(){
		return "ref number:"+referenceNumber
				+";color:"+color
				+";price:"+price
				+";size:"+size;
	}
	
}

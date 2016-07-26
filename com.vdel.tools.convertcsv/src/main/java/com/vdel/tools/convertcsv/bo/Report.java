package com.vdel.tools.convertcsv.bo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Report class BO which contains CSV informations
 * @author Val
 *
 */
@XmlRootElement
public class Report {
	private String inputFile;
	private List<Reference> references;
	private List<Error> errors;
	
	/** getters and setter with annotation to jaxb parser **/
	

	public String getInputFile() {
		return inputFile;
	}
	
	@XmlElement
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	
	public List<Reference> getReferences() {
		return references;
	}
	
	@XmlElementWrapper(name="references")
	@XmlElement(name="reference")
	public void setReferences(List<Reference> references) {
		this.references = references;
	}
	public List<Error> getErrors() {
		return errors;
	}
	
	@XmlElementWrapper(name="errors")
	@XmlElement(name="error")
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	/**
	 * Adding error in the errors list of report
	 * @param error
	 */
	public void addError(Error error){
		if(errors == null)
			errors = new ArrayList<Error>();
		System.out.println("Adding error : " + error.toString());
		errors.add(error);
	}
	
	/**
	 * Adding reference in the references list of report
	 * @param reference
	 */
	public void addReference(Reference reference){
		if(references == null)
			references = new ArrayList<Reference>();
		System.out.println("Adding reference : " + reference.toString());
		references.add(reference);
	}
	
	
	
	
}

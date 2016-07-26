package com.vdel.tools.convertcsv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.opencsv.CSVReader;
import com.vdel.tools.convertcsv.bo.Error;
import com.vdel.tools.convertcsv.bo.Reference;
import com.vdel.tools.convertcsv.bo.Report;


/**
 * Abstract class to parse CSV file into POJO
 * @author Valentin Delepaut
 *
 */
public abstract class CSVParser {
	
	
	/**
	 *  POJO who contain CSV data
	 */
	protected Report report = new Report();
	
	/**
	 * CSV File
	 */
	protected File csvFile;
	
	/**
	 * Output file, JSON or XML
	 */
	protected File outFile;
	
	/**
	 * Method which parses CSV file into Report object
	 * @param csvFileName
	 * @param outFileName
	 * @throws IOException
	 */
	protected void parsingCsvFile(String csvFileName,String outFileName) throws IOException {
			 csvFile = new File(csvFileName);
			 outFile = new File(outFileName);
			 
			 CSVReader reader = null;
			 try{
				 System.out.println("CSV file to parse : " + csvFile.getName());
				 reader = new CSVReader(new FileReader(csvFile),';');
				 
				 // get all lines of CSV file
			     List<String[]> myEntries = reader.readAll();
			     
			     report.setInputFile(csvFile.getName());
			     
			     for(int i = 0; i < myEntries.size();i++){
			    	 String[] entry = myEntries.get(i);
			    	 if(entry.length!=4){
			    		 Error err = new Error();
			    		 err.setLine(i+1);
			    		 err.setMessage("Invalid columns number");
			    		 err.setValue(entry.toString());
			    		 report.addError(err);
			    	 }
			    	 else{
			    		 addReference(i+1,entry[0], entry[1], entry[2], entry[3]);
			    		 
			    	 }
			     }
			 }
			 finally{
				 if(reader!=null)
					 reader.close();
			 }
		     
	}
	

	/**
	 * Add reference information in report object
	 * @param line
	 * @param refNumber
	 * @param color
	 * @param price
	 * @param size
	 */
	public void addReference(int line, String refNumber, String color, String price, String size){
		
			try {
				// All test of information in CSV
				if(refNumber == null || !refNumber.matches("[0-9]+"))
					throw new Exception("Invalid reference Number");
				else if(color == null || (!color.equals("R") && !color.equals("G") && !color.equals("B") ))
					throw new Exception("Incorrect value for color");
				else if(!NumberUtils.isNumber(price))
					throw new Exception("Incorrect value for price");
				else if(!NumberUtils.isNumber(size))
					throw new Exception("Incorrect value for size");
				else{
					Reference ref = new Reference();
					ref.setReferenceNumber(refNumber);
					ref.setPrice(Double.valueOf(price));
					ref.setSize(Integer.valueOf(size));
					ref.setColor(color.charAt(0));
					
					report.addReference(ref);
				}
			} catch (Exception e) {
				Error err = new Error();
				err.setLine(line);
				err.setMessage(e.getMessage());
				err.setValue(refNumber+";"+color+";"+price+";"+size);
				
				report.addError(err);
			}

		
		
	}
}

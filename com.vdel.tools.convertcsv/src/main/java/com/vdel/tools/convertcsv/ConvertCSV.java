package com.vdel.tools.convertcsv;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.vdel.tools.convertcsv.json.CsvToJson;
import com.vdel.tools.convertcsv.xml.CsvToXml;

/**
 * Main class to execute application
 * Convert a CSV file into JSON file or XML file
 */
public class ConvertCSV 
{

    public static void main( final String[] args ) throws IOException, JAXBException
    {
    	// Only 3 arguments
    	if(args.length!=3){
    		System.out.println("Invalid arguments number");
    		System.out.println("Please enter : CSV file , type of conversion (xml, json), output file");
    		System.out.println("Example : java -jar convertcsv.jar /csv/myFile.csv xml /xml/outFile.xml");
    	}
    	else{
    		ICSVConverter converter=null;
    		
    		String inFile = args[0];
    		String conversionType = args[1];
    		String outFile = args[2];
    		
    		if(conversionType.equals("xml")){
    			converter = CsvToXml.getInstance();
    		}
    		else if (conversionType.equals("json")){
    			converter = CsvToJson.getInstance();
    		}
    		
    		// if converter is null, argument for conversion type  is invalid
    		if(converter == null)
    			System.out.println("Invalid value for conversion type : " + conversionType);
    		else{
    			// start conversion 
    			converter.convert(inFile, outFile);
    		}
    	}
    	

    }
}

/**
 *
 */
package com.vdel.tools.convertcsv.xml;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.vdel.tools.convertcsv.CSVParser;
import com.vdel.tools.convertcsv.ICSVConverter;
import com.vdel.tools.convertcsv.bo.Report;


/**
 * XML class converter : <br/>
 * Convert a CSV file and convert it into XML file
 * @author 20002845
 * @date Jul 25, 2016
 * 
 */
public class CsvToXml extends CSVParser implements ICSVConverter
{

    /**
     * Using singleton pattern : Just one instance of this object
     */
    private static CsvToXml instance = new CsvToXml();

    /**
     * Private constructor to avoid instantiating class
     */
    private CsvToXml(){

    }

    /**
     * Get the instance of CsvToXml class
     * @return
     */
    public static CsvToXml getInstance(){
    	System.out.println("Xml File generation ... ");
        return CsvToXml.instance;
    }

    /* (non-Javadoc)
     * @see com.vdel.tools.convertcsv.ICSVConverter#convert()
     */
	public void convert(String inFileName, String outFileName) throws IOException, JAXBException {
		parsingCsvFile(inFileName, outFileName);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		jaxbMarshaller.marshal(report, outFile);
		jaxbMarshaller.marshal(report, System.out);
	}

}


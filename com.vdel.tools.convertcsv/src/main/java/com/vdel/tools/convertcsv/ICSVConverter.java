/**
 *
 */
package com.vdel.tools.convertcsv;

import java.io.IOException;

import javax.xml.bind.JAXBException;

/**
 * 
 * Interface for conversion
 * @author Valentin Delepaut
 * @date Jul 25, 2016
 * 
 */
public interface ICSVConverter
{
	
	/**
	 * Convert CSV file into type of the output file
	 * @param inFile
	 * @param outFile
	 * @throws IOException 
	 * @throws JAXBException 
	 */
    public void convert(String inFile, String outFile) throws IOException, JAXBException;
}


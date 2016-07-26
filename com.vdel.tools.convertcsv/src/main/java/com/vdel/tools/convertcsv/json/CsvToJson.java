/**
 *
 */
package com.vdel.tools.convertcsv.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdel.tools.convertcsv.CSVParser;
import com.vdel.tools.convertcsv.ICSVConverter;


/**
 * JSON class converter : <br/>
 * Convert a CSV file and convert it into JSON file
 * 
 * @author Valentin Delepaut
 * @date Jul 25, 2016
 * 
 */
public class CsvToJson extends CSVParser implements ICSVConverter
{

    /**
     * Using singleton pattern : Just one instance of this object
     */
    private static CsvToJson instance = new CsvToJson();

    /**
     * Private constructor to avoid instanciating class
     */
    private CsvToJson(){

    }

    public static CsvToJson getInstance(){
        System.out.println("Starting JSON conversion ... ");
        return CsvToJson.instance;
    }


    /* (non-Javadoc)
     * @see com.vdel.tools.convertcsv.ICSVConverter#convert()
     */
    public void convert(final String inFileName,final String outFileName) throws IOException {

        // Construct report object with csv file
        parsingCsvFile(inFileName, outFileName);

        // Start conversion into JSON
        final ObjectMapper mapper = new ObjectMapper();
        try {
            // Write content of  report object into json file
            // DefaultPrettyPrinter = indent and format json file
            mapper.writerWithDefaultPrettyPrinter().writeValue(outFile, report);


            // Write content of report object into console
            final String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(report);
            System.out.println(jsonInString);

        } catch (final JsonGenerationException e) {
            e.printStackTrace();
        } catch (final JsonMappingException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}


package com.vdel.tools.convertcsv;

import com.vdel.tools.convertcsv.bo.Reference;
import com.vdel.tools.convertcsv.json.CsvToJson;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CSVParserTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CSVParserTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CSVParserTest.class );
    }

    public void testReferenceAdding(){
    	CSVParser converter = CsvToJson.getInstance();
    	converter.addReference(0,"","","","");
    	
    	
    	Assert.assertEquals(null, converter.report.getReferences());
    	Assert.assertEquals(1, converter.report.getErrors().size());
    	
    	Assert.assertEquals("Invalid reference Number", converter.report.getErrors().get(0).getMessage());
    	
    	converter.addReference(1, "toto", "C", "azerty", "plop");

    	Assert.assertEquals(null, converter.report.getReferences());
    	Assert.assertEquals(2, converter.report.getErrors().size());
    	Assert.assertEquals("Invalid reference Number", converter.report.getErrors().get(1).getMessage());

    	converter.addReference(2, "0123456789", "C", "azerty", "plop");
    	
    	Assert.assertEquals(null, converter.report.getReferences());
    	Assert.assertEquals(3, converter.report.getErrors().size());
    	Assert.assertEquals("Incorrect value for color", converter.report.getErrors().get(2).getMessage());

    	converter.addReference(3, "0123456789", "B", "azerty", "plop");
    	
    	Assert.assertEquals(null, converter.report.getReferences());
    	Assert.assertEquals(4, converter.report.getErrors().size());
    	Assert.assertEquals("Incorrect value for price", converter.report.getErrors().get(3).getMessage());

    	converter.addReference(3, "0123456789", "B", "15.2", "plop");
    	
    	Assert.assertEquals(null, converter.report.getReferences());
    	Assert.assertEquals(5, converter.report.getErrors().size());
    	Assert.assertEquals("Incorrect value for size", converter.report.getErrors().get(4).getMessage());

    	converter.addReference(3, "0123456789", "B", "15.2", "25");
    	
    	Assert.assertEquals(1, converter.report.getReferences().size());
    	Assert.assertEquals(5, converter.report.getErrors().size());
    	
    	Reference ref = converter.report.getReferences().get(0);
    	Assert.assertEquals("0123456789",ref.getReferenceNumber());
    	Assert.assertEquals('B', ref.getColor());
    	Assert.assertEquals(15.2, ref.getPrice());
    	Assert.assertEquals(25, ref.getSize());
    	
    }
}

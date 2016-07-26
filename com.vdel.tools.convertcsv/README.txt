Application for conversion of CSV file into JSON or XML file

Example of execution JAR file : 

java -jar com.vdel.tools.convertcsv-0.0.1-SNAPSHOT.jar fileCsv.csv json fileJson.json 



This application use  libraries : 
 - opencsv for csv parsing
 - jackson for JSON generation
 - jaxb2 for XML generation
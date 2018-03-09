package qcJson;

import java.io.FileInStream;
import java.io.FileNotFoundException;
import java.io.FileOutStream;
import java.util.Date;
import java.util.HashMap;


public class qcJsonAppExample {

	
	public static void main(String[] args){
        
        try {
			FileOutStream outFile = new FileOutStream("FileName.FileExtension");
			FileInStream inFile = new FileInStream("FileName.FileExtension");
			
			JSONOutStream jsonOut = new JSONOutStream(outFile);
			JSONInStream jsonIn = new JSONInStream(inFile);
			
			Date DateExample = new Date();
			qcJsonTestObject anObject = new qcJsonTestObject("File string", 876543, DateExample);
			
			jsonOut.writeObject(anObject);
			
			HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
			qcJsonTestObject readObject = new qcJsonTestObject(parsedJSONMap);
			System.out.println("Same stream? "+readObject.equals(anObject));
			
			String jsonString = JSONUtilities.stringify(anObject);
			System.out.println("JSON: "+jsonString);
			
			parsedJSONMap = (HashMap)JSONUtilities.parse(jsonString);
			readObject = new qcJsonTestObject(parsedJSONMap);
			System.out.println("Same stringify? "+readObject.equals(anObject));
			
	
		} catch (JSONException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        
    }
}

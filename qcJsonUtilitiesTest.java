
package qcJson;


import static org.quickconnectfamily.json.tests.Assert.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.quickconnectfamily.json.JSONUtilities;

public class qcJsonUtilitiesTest {

	@Test
	public void testStringifySerializable() {

		String jsonString = null;

		qcJsonTestObject anObject = new qcJsonTestObject("Hello there.", 7, new Date(1067899));
		try {
			jsonString = qcJsonUtilities.stringify(anObject);
			System.out.println(jsonString);
			Assert(jsonString.indexOf("\"tDate\":\"1969-12-31 17:17:47.899\"") != -1);
			Assert(jsonString.indexOf("\"tString\":\"Hello there.\"") != -1);
			Assert(jsonString.indexOf("\"tInt\":7") != -1);
			String patternString = "\\{.*,.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

    
		 //Testing all nulls scenario

		qcJsonTestObject aNullObject = new qcJsonTestObject();
		try {
			jsonString = qcJsonUtilities.stringify(aNullObject);
			System.out.println(jsonString);
			Assert(jsonString.equals("{\"theInt\":0}") );
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 //Testing a null parameter
		try {
			jsonString = qcJsonUtilities.stringify((Serializable)null);
			Assert( jsonString == null);
	
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 //Testing a null attribute

		qcJsonTestObject anObjectWithNull = new qcJsonTestObject(null, 7, new Date(1067899));
		try {
			jsonString = qcJsonUtilities.stringify(anObjectWithNull);
			Assert(jsonString.indexOf("\"tDate\":\"1969-12-31 17:17:47.899\"") != -1);
			Assert(jsonString.indexOf("\"tInt\":7") != -1);
			String patternString = "\\{.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Test a string with escaped quotes as an attribute

		String stringWithEscapes = "hello \"bob\". What do you want?";
		qcJsonTestObject anObjectWithEscapedString = new qcJsonTestObject(stringWithEscapes, 7, new Date(1067899));
		try {
			jsonString = qcJsonUtilities.stringify(anObjectWithEscapedString);
			Assert(jsonString.indexOf("\"tDate\":\"1969-12-31 17:17:47.899\"") != -1);
			Assert(jsonString.indexOf("\"tString\":\"hello \\\"bob\\\". What do you want?\"") != -1);
			Assert(jsonString.indexOf("\"tInt\":7") != -1);
			String patternString = "\\{.*,.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		 //Testing an array of Objects.


		try {
			Object[] anObjectArray = {new Integer(4), "Hello", new Date(222222222)};
			jsonString = qcJsonUtilities.stringify(anObjectArray);
			System.out.println("Object[]: "+jsonString);
			Assert( jsonString.equals("[4,\"Hello\",\"1970-01-03 06:43:42.222\"]"));

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Testing an array of ints.

		try {
			int[] anArray = {5, -2, 0,100000};
			jsonString = qcJsonUtilities.stringify(anArray);
			Assert( jsonString.equals("[5,-2,0,100000]"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Testing an array of doubles.

		try {
			double[] anArray = {5.03, -2015.009999999999, 0.0,0.999999999999};
			jsonString = qcJsonUtilities.stringify(anArray);
			Assert( jsonString.equals("[5.03,-2015.009999999999,0.0,0.999999999999]"));
		
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		 // Testing an array of bytes.
	

		try {
			byte[] anArray = "This is an array of bytes".getBytes();
			jsonString = qcJsonUtilities.stringify(anArray);
			Assert( jsonString != null);

		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Testing an array chars.


		try {
			char[] anArray = "This is an array of chars".toCharArray();
			jsonString = qcJsonUtilities.stringify(anArray);
			Assert(jsonString != null);
	
			Assert( jsonString.equals("[\"T\",\"h\",\"i\",\"s\",\" \",\"i\",\"s\",\" \",\"a\",\"n\",\" \",\"a\",\"r\",\"r\",\"a\",\"y\",\" \",\"o\",\"f\",\" \",\"c\",\"h\",\"a\",\"r\",\"s\"]"));
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		 // Testing an array with nulls in it

		Object[] objArr = new Object[5];
		objArr[0] = null;
		objArr[1] = new Integer(7);
		objArr[2] = new Double(8.3);
		objArr[3] = null;
		objArr[4] = null;

		try {
			jsonString = qcJsonUtilities.stringify(objArr);
			String testString = "[null,7,8.3,null,null]";
			Assert(jsonString.equals(testString));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		System.out.println("Passed testStringifySerializable");
	}

	@Test
	public void testStringifyCollections(){
		Date testDate = new Date(1067899);
		String jsonString = null;

		ArrayList testListHappyPath = new ArrayList();
		testListHappyPath.add(9L);
		testListHappyPath.add(8L);
		testListHappyPath.add(7L);
		try {
			jsonString = qcJsonUtilities.stringify(testListHappyPath);
			Assert( jsonString.equals("[9,8,7]"));
	
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // happy path map test

		HashMap testMapHappyPath = new HashMap();
		testMapHappyPath.put("tDate", testDate);
		testMapHappyPath.put("some string", "hello \"bob\" \t");
		testMapHappyPath.put("someDouble", 87.3);

		try {
			jsonString = qcJsonUtilities.stringify(testMapHappyPath);
			String testString = "{\"someDouble\":87.3,\"some string\":\"hello \\\"bob\\\" \\t\",\"theDate\":\"1969-12-31 17:17:47.899\"}";
			System.out.println(jsonString);
			Assert(jsonString.indexOf("\"tDate\":\"1969-12-31 17:17:47.899\"") != -1);
			Assert(jsonString.indexOf("\"someDouble\":87.3") != -1);
			Assert(jsonString.indexOf("\"some string\":\"hello \\\"bob\\\" \\t\"") != -1);
			String patternString = "\\{.*,.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Testing happy path HashMap with Booleans


		HashMap testMap = new HashMap();
		Boolean first = new Boolean(true);
		Boolean second = new Boolean(true);
		testMap.put("config_App_6237", first);
		testMap.put("Init_LoadResourceLastCacheDate", second);

		try {
			jsonString = qcJsonUtilities.stringify(testMap);
			Assert(jsonString.indexOf("\"config_App_6237\":true") != -1);
			Assert(jsonString.indexOf("\"Init_LoadResourceLastCacheDate\":true") != -1);
			String patternString = "\\{.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		HashMap mapWithNullValue = new HashMap();
		long bigNumber = Long.MAX_VALUE;
		mapWithNullValue.put("real value", bigNumber);
		mapWithNullValue.put("null value", null);

		try {
			jsonString = qcJsonUtilities.stringify(mapWithNullValue);
			Assert(jsonString.indexOf("\"real value\":9223372036854775807") != -1);
			String patternString = "\\{.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		HashMap mapWithNullKeys = new HashMap();
		mapWithNullValue.put(null, bigNumber);
		mapWithNullValue.put(null, null);

		try {
			jsonString = qcJsonUtilities.stringify(mapWithNullKeys);
			System.out.println("null: "+jsonString);
			Assert(jsonString.equals("{}"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		ArrayList arrayWithNullValues = new ArrayList();
		arrayWithNullValues.add(null);
		arrayWithNullValues.add(17);
		arrayWithNullValues.add(null);
		arrayWithNullValues.add(null);

		try {
			jsonString = qcJsonUtilities.stringify(arrayWithNullValues);
			System.out.println(jsonString);
			Assert(jsonString.equals("[null,17,null,null]"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Passed testStringifyCollections");
	}

	@Test
	public void testStringifySerializableEncoding() {

		 // Testing a valid 'happy path' scenario

		qcJsonTestObject anObject = new qcJsonTestObject("Hello there.", 7, new Date(1067899));
		try {
			String jsonString = qcJsonUtilities.stringify(anObject, JqcJsonUtilities.encoding.UNICODE);
			System.out.println(jsonString);
			Assert(jsonString.indexOf("\"tDate\":\"1969-12-31 17:17:47.899\"") != -1);
			Assert(jsonString.indexOf("\"tString\":\"Hello there.\"") != -1);
			Assert(jsonString.indexOf("\"tInt\":7") != -1);
			String patternString = "\\{.*,.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			String jsonString = qcJsonUtilities.stringify(anObject, qcJsonUtilities.encoding.UTF8);
			Assert(jsonString.indexOf("\"theDate\":\"1969-12-31 17:17:47.899\"") != -1);
			Assert(jsonString.indexOf("\"theString\":\"Hello there.\"") != -1);
			Assert(jsonString.indexOf("\"theInt\":7") != -1);
			String patternString = "\\{.*,.*,.*\\}";
			Pattern aRegularExpressionPattern = Pattern.compile(patternString);
			Matcher aMatcher = aRegularExpressionPattern.matcher(jsonString);
			Assert(aMatcher.find());
		}
		catch (Exception e) {
			e.printStackTrace();
	
		}

		 // Testing a null parameter
	
		try {
			String jsonString = qcJsonUtilities.stringify((Serializable)null, qcJsonUtilities.encoding.UNICODE);
			Assert(jsonString == null);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Testing a null encoding or other invalid encoding
	
		try {
			String jsonString = qcJsonUtilities.stringify(anObject, (qcJsonUtilities.encoding)null);
			Assert( false);
		} catch (Exception e) {}

		 // Testing an array of Objects with various encodings..


		Object[] anObjectArray = {new Integer(4), "Hello", new Date(45879003)};
		try {
			String jsonString = qcJsonUtilities.stringify(anObjectArray, qcJsonUtilities.encoding.UNICODE);
			Assert( jsonString != null);
			Assert(jsonString.equals("[4,\"Hello\",\"1970-01-01 05:44:39.003\"]"));

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			String jsonString = qcJsonUtilities.stringify(anObjectArray, qcJsonUtilities.encoding.UTF8);
			Assert( jsonString != null);;
			Assert(jsonString.equals("[4,\"Hello\",\"1970-01-01 05:44:39.003\"]"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		char[] someChars = {'a','b','c'};
		Object[] annotherObjectArray = {new Integer(4), "Hello", someChars};
		try {
			String jsonString = qcJsonUtilities.stringify(annotherObjectArray, qcJsonUtilities.encoding.UNICODE);
			Assert( jsonString !=null);
			Assert( jsonString.equals("[4,\"Hello\",[\"a\",\"b\",\"c\"]]"));
		
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			String jsonString = qcJsonUtilities.stringify(annotherObjectArray, qcJsonUtilities.encoding.UTF8);
			Assert( jsonString != null);
		
			Assert( jsonString.equals("[4,\"Hello\",[\"a\",\"b\",\"c\"]]"));

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		System.out.println("Passed testStringifySerializableEncoding");
	}
	@Test
	public void testParseString() {
		try{
			//test the happy path with a well formed JSON string.
			HashMap testMap = (HashMap)qcJsonUtilities.parse("{\"aNumber\":16.5,\"stringOne\":\"Some sort of string\",\"20\":\"some other stuff\",\"aTester\":{\"stringAtt\":\"hello\",\"doubleAtt\":-4.5,\"doubleObjAtt\":1000.567789,\"listAtt\":[7,\"hello there from list\"],\"parentString\":\"In The Parent\"}}");
			Assert( testMap != null);

			Number aNumber = (Double)testMap.get("aNumber");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == 16.5);

			String aString = (String)testMap.get("stringOne");
			Assert( aString != null);
			Assert( aString.equals("Some sort of string"));

			aString = (String)testMap.get("20");
			Assert( aString != null);
			Assert( aString.equals("some other stuff"));

			HashMap anObjectRepresentation = (HashMap)testMap.get("aTester");
			Assert( anObjectRepresentation != null);
			//check the attributes of the object embedded as an attribute of the outer object
			aString = (String)anObjectRepresentation.get("stringAtt");
			Assert( aString != null);
			Assert( aString.equals("hello"));
			aNumber = (Double)anObjectRepresentation.get("doubleAtt");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == -4.5);
			//System.out.println("doubleAtt: "+anObjectRepresentation.get("doubleAtt"));

			aNumber = (Double)anObjectRepresentation.get("doubleObjAtt");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == 1000.567789);

			ArrayList aList = (ArrayList)anObjectRepresentation.get("listAtt");
			Assert( aList != null);
			//check the values of the items in the list
			Long longNumber = (Long)aList.get(0);
			Assert( longNumber != null);
			Assert( longNumber.longValue() == 7);

			aString = (String)aList.get(1);
			Assert( aString != null);
			Assert( aString.equals("hello there from list"));

			//Check the last attribute of the object embedded as an attribute of the outer object
			aString = (String)anObjectRepresentation.get("parentString");
			Assert( aString != null);
			Assert( aString.equals("In The Parent"));
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}

		 // Testing passing a null string parameter.

		try {
			Object nullObject = qcJsonUtilities.parse(null);
			Assert( nullObject == null);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	
		try {
			Object someObject = qcJsonUtilities.parse("{\"key\": \"anotherKey\":\"a value\"}");
			Assert( false);
		} catch (Exception e) {}

		 // Testing malformed JSON array.
		
		try {
			Object someObject = qcJsonUtilities.parse("[90, some stuff, \"other stuff\"]");
			Assert( false);
		} catch (Exception e) {}
		System.out.println("Passed testParseString");

	}

	@Test
	public void testParseStringEncoding() {
		try{
			//test the happy path with a well formed JSON string.
		
			HashMap testMap = (HashMap)qcJsonUtilities.parse("{\"aNumber\":16.5,\"stringOne\":\"Some sort of string\",\"20\":\"some other stuff\",\"aTester\":{\"stringAtt\":\"hello\",\"doubleAtt\":-4.5,\"doubleObjAtt\":1000.567789,\"listAtt\":[7,\"hello there from list\"],\"parentString\":\"In The Parent\"}}",JSONUtilities.encoding.UNICODE);
			Number aNumber = (Number)testMap.get("aNumber");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == 16.5);

			String aString = (String)testMap.get("stringOne");
			Assert( aString != null);
			Assert( aString.equals("Some sort of string"));

			aString = (String)testMap.get("20");
			Assert( aString != null);
			Assert( aString.equals("some other stuff"));

			HashMap anObjectRepresentation = (HashMap)testMap.get("aTester");
			//check the attributes of the object embedded as an attribute of the outer object
			aString = (String)anObjectRepresentation.get("stringAtt");
			Assert( aString != null);
			Assert( aString.equals("hello"));

			aNumber = (Number)anObjectRepresentation.get("doubleAtt");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == -4.5);

			aNumber = (Number)anObjectRepresentation.get("doubleObjAtt");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == 1000.567789);

			ArrayList aList = (ArrayList)anObjectRepresentation.get("listAtt");
			Assert( aList != null);
			Assert( aList.size() == 2);

			//check the values of the items in the list
			aNumber = (Number)aList.get(0);
			Assert( aNumber !=null);
			Assert( aNumber.intValue() == 7);

			aString = (String)aList.get(1);
			Assert( aString != null);
			Assert( aString.equals("hello there from list"));

			//Check the last attribute of the object embedded as an attribute of the outer object
			aString = (String)anObjectRepresentation.get("parentString");
			Assert( aString != null);
			Assert( aString.equals("In The Parent"));

			//test the happy path with a well formed JSON string.
			testMap = (HashMap)qcJsonUtilities.parse("{\"aNumber\":16.5,\"stringOne\":\"Some sort of string\",\"20\":\"some other stuff\",\"aTester\":{\"stringAtt\":\"hello\",\"doubleAtt\":-4.5,\"doubleObjAtt\":1000.567789,\"listAtt\":[7,\"hello there from list\"],\"parentString\":\"In The Parent\"}}",JSONUtilities.encoding.UTF8);
			Assert( testMap != null);

			aNumber = (Number)testMap.get("aNumber");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == 16.5);

			aString = (String)testMap.get("stringOne");
			Assert( aString != null);
			Assert( aString.equals("Some sort of string"));

			aString = (String)testMap.get("20");
			Assert( aString != null);
			Assert( aString.equals("some other stuff"));

			anObjectRepresentation = (HashMap)testMap.get("aTester");
			Assert( anObjectRepresentation != null);
			//check the attributes of the object embedded as an attribute of the outer object
			aString = (String)anObjectRepresentation.get("stringAtt");
			Assert( aString != null);
			Assert( aString.equals("hello"));

			aNumber = (Number)anObjectRepresentation.get("doubleAtt");
			Assert( aNumber != null);
			Assert( aNumber.doubleValue() == -4.5);

			aNumber = (Number)anObjectRepresentation.get("doubleObjAtt");
			Assert( aNumber != null);
			//System.out.println("aNumber: "+aNumber.doubleValue());
			Assert( aNumber.doubleValue() == 1000.567789);

			aList = (ArrayList)anObjectRepresentation.get("listAtt");
			Assert( aList != null);
			Assert( aList.size() == 2);
			//check the values of the items in the list
			aNumber = (Number)aList.get(0);
			Assert( aNumber != null);
			Assert( aNumber.intValue() == 7);

			aString = (String)aList.get(1);
			Assert( aString != null);
			Assert( aString.equals("hello there from list"));

			//Check the last attribute of the object embedded as an attribute of the outer object
			aString = (String)anObjectRepresentation.get("parentString");
			Assert( aString != null);
			Assert( aString.equals("In The Parent"));
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}

		 //Testing passing a null string parameter.
	
		try {

			Object nullObject = qcJsonUtilities.parse(null, qcJsonUtilities.encoding.UNICODE);
			Assert(nullObject == null);

			nullObject = qcJsonUtilities.parse(null, qcJsonUtilities.encoding.UTF8);
			Assert(nullObject == null);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		 // Testing malformed JSON object.
		try {
		
			Object someObject = qcJsonUtilities.parse("{\"key\": \"anotherKey\":\"a value\"}", qcJsonUtilities.encoding.UNICODE);
			Assert( false);
		} catch (Exception e) {
		}
		try{
	
			Object someObject = qcJsonUtilities.parse("{\"key\": \"anotherKey\":\"a value\"}", qcJsonUtilities.encoding.UTF8);
			Assert( false);
		}
		catch (Exception e) {
		}

		 // Testing malformed JSON array.

		try {
		
			Object someObject = qcJsonUtilities.parse("[90, some stuff, \"other stuff\"]", qcJsonUtilities.encoding.UNICODE);
			Assert( false);
		} catch (Exception e) {
		}
		try{
	
			Object someObject = qcJsonUtilities.parse("[90, some stuff, \"other stuff\"]", qcJsonUtilities.encoding.UTF8);
			Assert( false);
		}
		catch (Exception e){
		}

		System.out.println("Passed testParseStringEncoding");
	}
	@Test
	public void testStringifyParse(){
		Date testDate = new Date(1067899);
		TestObject anObject = new TestObject("Hello there.", 7, testDate);
		try {
			String jsonString = qcJsonUtilities.stringify(anObject);
			Assert( jsonString != null);
			HashMap parsedMap = (HashMap)qcJsonUtilities.parse(jsonString);
			Assert( parsedMap != null);
			Assert( ((String)parsedMap.get("tString")).equals("Hello there."));
			Assert( ((Long)parsedMap.get("tInt")).intValue() == 7);
			System.out.println("parsed date: " + parsedMap.get("tDate"));
			//Assert( ((Date)parsedMap.get("theDate")).compareTo(testDate) == 0);
			Assert(((String)parsedMap.get("tDate")).equals("1969-12-31 17:17:47.899"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Passed testStringifyParse");
	}

}

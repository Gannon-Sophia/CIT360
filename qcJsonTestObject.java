package qcJson;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;


@SuppressWarnings("serial")
public class qcJsonTestObject implements Serializable {
	private String tString;
	private int tInt;
	private Date tDate;
	
	public qcJsonTestObject(String aString, int anInt, Date aDate) {
		tString = aString;
		tInt = anInt;
		tDate = aDate;
	}
	
	public qcJsonTestObject(HashMap aMapRepre){
		this.tString = (String)aMapRepre.get("tString");
		//dates are stored as timestamp strings.
		String stampString = (String)aMapRepre.get("tDate");
		this.tDate = new Date(Timestamp.valueOf(stampString).getTime());
		//numbers are stored as longs or doubles.
		Long asLong = (Long)aMapRepre.get("tInt");
		this.tInt = asLong.intValue();
		
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		qcJsonTestObject other = (qcJsonTestObject) obj;
		if (tDate == null) {
			if (other.tDate != null)
				return false;
		} else if (!tDate.equals(other.tDate)){
			System.out.println("failed: "+tDate+" "+other.tDate);
			return false;
		}
		if (tInt != other.tInt)
			return false;
		if (tString == null) {
			if (other.tString != null)
				return false;
		} else if (!tString.equals(other.tString))
			return false;
		return true;
	}

}

package JUnitSampleTest;

public class JUnitSample{
	
	public int square(int y){
		return y*y;
	}
	
	public int countJ(String word){
		int count = 0;
		for(int i=0; i < word.length(); i++) {
			if(word.charAt(i)=='a' || word.charAt(i)=='A') {
				count++;
			}
		}
		return count;
	}

}

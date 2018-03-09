package httpFileConnection;

import java.io.File;

public class mainConnection {

	public static void main(String[] args) {
		String link = "http://iiti.ac.in/people/~tanimad/JavaTheCompleteReference.pdf";
		File out = new File("C:\\Users\\sophiagannon\\Desktop\\Java The Complete Reference.pdf");
		new Thread(new httpDownloadConnection(link, out)).start();
	}

}

package saida.code.exercise;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * <b>Title: </b>TestMostCommonWords.java
 * </p>
 * <p>
 * <b>Description: </b> <code>TestMostCommonWords</code> defines main entry
 * point for testing the <strong>findMostCommonWords()</strong> API of
 * <code>MostCommonWords</code>.
 * </p>
 * <p>
 * <b>@author Originator:</b> sdhanavath on Dec 24, 2011
 * </p>
 * <p>
 * <b>@author Last Modify By:</b> TODO Fill at each modification
 * </p>
 * <p>
 * <b>@since </b> Code_Exercise-1
 * </p>
 * 
 */
public class TestMostCommonWords {
	/**
	 * Entry Point of the application
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("================================");
		System.out.println("Welcome to MostCommonWords API");
		System.out.println("================================");
		System.out.println("Please Enter the file location \n"
				+ " to know *5 most common words* in it.");
		Scanner scanner = new Scanner(System.in);
		String fileLocation = scanner.next();
		MostCommonWords mWords = new MostCommonWordsImpl();
		try {
			List<String> results = mWords.findMostCommonWords(fileLocation, 5);
			System.out.println("**5 most common words**:" + results);
		} catch (FileNotFoundException e) {
			System.out
					.println("File Not Found, Please execute 'java TestMostCommonWords' and provide correct file location.");
			
		}

	}

}

package saida.code.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * <b>Title: </b>MostCommonWordsImpl.java
 * </p>
 * <p>
 * <b>Description: </b> The class <code>MostCommonWordsImpl</code> implements
 * the behaviors of <i>MostCommonWord</i> to find the most common words of a
 * given text file.
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
public class MostCommonWordsImpl implements MostCommonWords {

	// A pattern for non-word character and A whitespace character(\t\n\x0B\f\r)
	private static Pattern NON_WORD_WHITE_SPACE = Pattern.compile("[\\W\\s*]");

	// A pattern for non-digit
	private static Pattern NON_DIGIT = Pattern.compile("\\D");

	// Words container used to manage all the words and no. of occurrences
	private HashMap<String, Integer> words = null;

	/**
	 * Returns the list of most common words of given input text file.
	 * 
	 * @throws FileNotFoundException
	 */
	public List<String> findMostCommonWords(String fileLocation, Integer howMany)
			throws FileNotFoundException {
		// find
		words = this.findValidWords(fileLocation, howMany);
		// container to sort the words based on the no. of occurrences
		TreeMap<Integer, List<String>> wordOccur = new TreeMap<Integer, List<String>>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer a, Integer b) {
						return a == b ? 0 : (a < b ? 1 : -1);
					}
				});

		for (Map.Entry<String, Integer> e : words.entrySet()) {
			if (!wordOccur.containsKey(e.getValue())) {
				ArrayList<String> wordList = new ArrayList<String>();
				wordList.add(e.getKey());
				wordOccur.put(e.getValue(), wordList);

			} else {
				wordOccur.get(e.getValue()).add(e.getKey());
			}
		}
		words = null;

		// list contains only most common words
		List<String> mcwList = new ArrayList<String>();

		for (Map.Entry<Integer, List<String>> e : wordOccur.entrySet()) {
			for (String word : e.getValue()) {
				if (mcwList.size() < howMany) {
					mcwList.add(word);
				} else {
					break;
				}
			}
		}
		wordOccur = null;
		return mcwList;
	}

	/**
	 * Returns the Map<K,V> of all the words and their no. of occurrences.
	 * 
	 * @param fileLocation
	 * @param howMany
	 * @return returns the Map<word,occurrence> after reading the text file.
	 * @throws FileNotFoundException
	 */
	private HashMap<String, Integer> findValidWords(String fileLocation,
			Integer howMany) throws FileNotFoundException {
		// Read streams of characters from a text file.
		FileReader fileReader = new FileReader(fileLocation);
		// Read text from a character-input stream and buffer the characters.
		BufferedReader bufReader = new BufferedReader(fileReader);

		words = new HashMap<String, Integer>();
		// Parses the text and breaks them into token using delimiter pattern.
		Scanner scan = new Scanner(bufReader);
		scan.useDelimiter(NON_WORD_WHITE_SPACE);

		while (scan.hasNext()) {
			String word = scan.next();
			Matcher m = NON_DIGIT.matcher(word);
			if (m.find() && word.length() >= 5) {
				if (!words.containsKey(word)) {
					words.put(word, 1);
				} else {
					words.put(word, words.get(word) + 1);
				}
			}
		}
		// close the file reading resources
		try {
			scan.close();
			bufReader.close();
			fileReader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return words;
	}
}
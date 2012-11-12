package saida.code.exercise;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * <p>
 * <b>Title: </b>MostCommonWords.java
 * </p>
 * <p>
 * <b>Description: </b> The interface <i>MostCommonWords</i> specifies the
 * behaviors for finding the most common words in a given input text file.
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
public interface MostCommonWords {
	/**
	 * Returns the list of most common words in the given text file.
	 * 
	 * @param fileLocation
	 *            - path of text file
	 * @param howMany
	 *            - how many most common words
	 * @return the list of most common words
	 */
	List<String> findMostCommonWords(String fileLocation, Integer howMany)throws FileNotFoundException ;

}

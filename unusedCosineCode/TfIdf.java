package recommendationSystem;

import java.util.List;

/**
 * Class to calculate TfIdf of a term.
 */

public class TfIdf {

	private final double simIndex = 0.6;

	/**
	 * Calculates the tf of term termToCheck
	 * @param totalterms : Array of all the keywords of a movie
	 * @param termToCheck : term of which tf is to be calculated.
	 * @return tf(term frequency) of term termToCheck
	 */
	public double tfCalculator(String[] totalterms, String termToCheck) {
		double count = 0;  
		for (String s : totalterms) {
			if (JaroWinklerDistance.similarity(s, termToCheck) > simIndex) {
				count++;
			}
		}
		return count / totalterms.length;
	}

	/**
	 * Calculates idf of term termToCheck
	 * @param allTerms : all the keywords of all movies
	 * @param termToCheck
	 * @return idf(inverse document frequency) score
	 */
	public double idfCalculator(List<String[]> allTerms, String termToCheck) {
		double count = 0;
		for (String[] ss : allTerms) {
			for (String s : ss) {
				if (JaroWinklerDistance.similarity(s, termToCheck) > simIndex) {
					count++;
					break;
				}
			}
		}
		return 1 + Math.log(allTerms.size() / count);
	}
}

package recommendationSystem;

import java.util.List;
//import java.util.Arrays;
import java.util.ArrayList;


/**
 * Class to vectorize keywords based on tf-idf score.
 */

public class Vectorizer {

	public static void main(String[] args) {
		//Matrix.main(null); <- need this to populate hashmaps
		//populateKeywords(); 
	}

	//This variable will hold all keywords of each movie in an array
	private static ArrayList<String[]> termsArray = new ArrayList<>();
	private static ArrayList<String> allTerms = new ArrayList<>(); //to hold all terms  
	private static ArrayList<double[]> tfidfVector = new ArrayList<>();

	public static void populateKeywords() {
		for(String s : Data.title_list) {
			try {
				List<String> bagOfWords = new ArrayList<String>();

				ArrayList<String> keywords = Data.hash_keywords.get(s);
				ArrayList<String> genres = Data.hash_genres.get(s);
				ArrayList<String> company = Data.hash_company.get(s);

				if(keywords != null) {bagOfWords.addAll(keywords);}
				if(genres != null) {bagOfWords.addAll(genres);}
				if(company != null) {bagOfWords.addAll(company);}

				String[] words = bagOfWords.toArray(new String[0]);
				//System.out.println(Arrays.toString(words));

				allTerms.addAll(bagOfWords);
				termsArray.add(words);
			}
			catch (NullPointerException e) {e.printStackTrace();}
			catch (Exception e) {e.printStackTrace();}
		}
	}


	/**
	 * Method to create termVector according to its tfidf score.
	 */
	public void tfIdfCalculator() {
		double tf; //term frequency
		double idf; //inverse document frequency
		double tfidf; //term frequency inverse document frequency        
		for (String[] keywords : termsArray) {
			double[] tfidfvectors = new double[allTerms.size()];
			int count = 0;
			for (String term : allTerms) {
				tf = new TfIdf().tfCalculator(keywords, term);
				idf = new TfIdf().idfCalculator(termsArray, term);
				tfidf = tf * idf;
				tfidfvectors[count] = tfidf;
				count++;
			}
			tfidfVector.add(tfidfvectors);  //storing movie vectors;            
		}
	}

	/**
	 * Method to calculate cosine similarity between all the movies.
	 */
	public void getCosineSimilarity() {
		for (int i = 0; i < tfidfVector.size(); i++) {
			for (int j = 0; j < tfidfVector.size(); j++) {
				System.out.println("between " + i + " and " + j + "  =  "
						+ new CosineSimilarity().cosineSimilarity
						(
								tfidfVector.get(i), 
								tfidfVector.get(j)
								)
						);
			}
		}
	}
}



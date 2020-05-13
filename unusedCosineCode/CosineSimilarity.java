package recommendationSystem;

/**
 * Cosine similarity calculator class.
 */
public class CosineSimilarity {

	/**
	 * Method to calculate cosine similarity between two sets of words
	 * @param vector2 
	 * @return 
	 */
	public double cosineSimilarity(double[] vector1, double[] vector2) {
		double dotProduct = 0.0;
		double magnitude1 = 0.0;
		double magnitude2 = 0.0;
		double cosineSimilarity = 0.0;

		for (int i = 0; i < vector1.length; i++) //vector1 and vector2 must be of same length
		{
			dotProduct += vector1[i] * vector2[i];  // a.b
			magnitude1 += Math.pow(vector1[i], 2);  //(a^2)
			magnitude2 += Math.pow(vector2[i], 2); //(b^2)
		}

		magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
		magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)

		if (magnitude1 != 0.0 | magnitude2 != 0.0) {
			cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
		} else {
			return 0.0;
		}
		return cosineSimilarity;
	}
}
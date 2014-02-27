package zappos;
import java.util.List;

import zappos.Product;


public class ZapposSearchResult
{
	protected String statusCode;
	private List<Product> results;
	protected String term;
	protected String originalTerm;
	protected String currentResultCount;
	protected String totalResultCount;
	
	/**
	 * Instantiates a new Zappos search result.
	 *
	 * @param statusCode returned after hitting the API
	 * @param list of products with that search results
	 * @param the words used for searching
	 * @param original words used for searching
	 * @param total number of results in current hit
	 * @param total number of results
	 */
	public ZapposSearchResult(
			final String statusCode,
			final List<Product> results,
			final String term,
			final String originalTerm,
			final String currentResultCount,
			final String totalResultCount)
	{
		this.statusCode=statusCode;
		this.setResults(results);
		this.term=term;
		this.originalTerm=originalTerm;
		this.currentResultCount=currentResultCount;
		this.totalResultCount=totalResultCount;
	}

	public List<Product> getResults()
	{
		return results;
	}

	public void setResults(List<Product> results)
	{
		this.results = results;
	}
}

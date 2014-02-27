
package zappos;

/**
 * This class provides a mechanism to select
 * k number of products from a given set of products whose total
 * price is close to a given amount .
 */
public class ProductSelector
{
	
	/** Total amount of the selected products. */
	private Double amountProvided;
	
	/** Number of items desired. */
	private Integer numberOfItems;
	
	/** Array of all the products. */
	private Product[] productList;
	
	/** Products selected from the list of products */
	private Product[] selectedProducts;
	
	/** the difference between the target amount and calculated amount */
	private Double diff=Double.MAX_VALUE;
	
	/**
	 * Instantiates an instance of product selector class.
	 *
	 * @param amountProvided Total amount of the selected products.
	 * @param numberOfItems Number of items desired.
	 * @param productList Array of all the products.
	 */
	public ProductSelector(final Double amountProvided, final Integer numberOfItems,final Product[] productList )
	{
		this.amountProvided = amountProvided;
		this.numberOfItems = numberOfItems;
		this.productList = productList;
		this.selectedProducts = new Product[numberOfItems];		
	}
	
	/**
	 * This function selects k number of products that closest to the specified amount
	 */
	public final void selectProducts() 
	{	
		if (numberOfItems > productList.length)
		{
			return;
		}
		determineOptimumProducts(new Product[numberOfItems], 0, 0);
		System.out.println("-------------");
		System.out.println("Selected Products :");
		for (int i=0 ; i < selectedProducts.length ; i++)
		{
			System.out.println(selectedProducts[i]+ "Price ::"+selectedProducts[i].price);
		}
	}

	/**
	 * Determine optimum products.
	 *
	 * @param subset the subset
	 * @param subsetLength the subset length
	 * @param nextIndex the next index
	 */
	private void determineOptimumProducts( final Product[] subset, final Integer subsetLength, final Integer nextIndex) {
	    if (subsetLength == subset.length) 
	    {
	    	checkClosestSum(subset);
	    } 
	    else 
	    {
	        for (int j = nextIndex; j < productList.length; j++) {
	            subset[subsetLength] = productList[j];
	            determineOptimumProducts( subset, subsetLength + 1, j + 1);
	        }
	    }
	}
	
	/**
	 * This function checks whether the subset of product 
	 * are having their total price closest to the total amount
	 * provided
	 * @param productSet Set of products 
	 */
	private void checkClosestSum(final Product[] productSet)
	{
		Double totalAmount = 0.0;
		for (Product product: productSet)
		{
			totalAmount += product.getPrice();
		}
		Double newDiff = Math.abs(totalAmount - this.amountProvided);
		if (diff > newDiff)
		{
			diff = newDiff;
			this.selectedProducts=productSet.clone();					
		}
	}
}

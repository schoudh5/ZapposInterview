package zappos;

/**
 * The Class Product.
 */
public class Product
{
	
	/** The style id. */
	String styleId;
	
	/** The price. */
	String price;
	
	/** The original price. */
	String originalPrice;
	
	/** The product url. */
	String productUrl;
	
	/** The color id. */
	String colorId;
	
	/** The brand name. */
	String brandName;
	
	/** The product name. */
	String productName;
	
	/** The thumbnail image url. */
	String thumbnailImageUrl;
	
	/** The percent off. */
	String percentOff;
	
	/** The product id. */
	String productId;
	
	
	
	/**
	 * Instantiates a new product.
	 *
	 * @param productName the product name
	 * @param productID the product id
	 * @param price the price
	 */
	public Product(
			String styleId,
			String price,
			String originalPrice,
			String productUrl,
			String colorId,
			String productName,
			String brandName,
			String thumbnailImageUrl,
			String percentOff,
			String productId)
	{
		this.styleId=styleId;
		this.price=price;
		this.originalPrice=originalPrice;
		this.productUrl=productUrl;
		this.colorId=colorId;
		this.productName=productName;
		this.brandName=brandName;
		this.thumbnailImageUrl=thumbnailImageUrl;
		this.percentOff=percentOff;
		this.productId=productId;
		
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return this.productName;
	}
	
	public Double getPrice()
	{
		Double cost=0.0;
		if(price !=null )
		{
			cost= Double.parseDouble(this.price.substring(1));
		}
		return cost;
	}
}

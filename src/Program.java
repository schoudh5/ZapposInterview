import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import zappos.*;

public class Program
{	
	public static void main(String[] args) throws Exception 
	{
		
		String url=Utility.ReadProperty("productUrl");
		Scanner scr=new Scanner(System.in);
		String numberOfProducts;
		String totalAmount;
		
		System.out.println("Use of Zappos Search API. URL ::"+url);
		System.out.println("You can change the URL in config.properties file");
		
		System.out.println("Enter Amount :");
		totalAmount=scr.nextLine();		
		System.out.println("Enter Number of Products :");
		numberOfProducts=scr.nextLine();
		
		String response=Utility.doHttpUrlConnection(url);
		if(Utility.isNumeric(totalAmount)&& Utility.isInteger(numberOfProducts))
		{
			Integer reqProducts=Integer.parseInt(numberOfProducts);
			Double totalCost=Double.parseDouble(totalAmount);
			//String pasredDataString=Utility.readFile("saurabpage", Charset.defaultCharset());
			ZapposSearchResult searchResult = null;
			try
			{
				searchResult = new Gson().fromJson(response, ZapposSearchResult.class);
				List<Product> itemsSearched=searchResult.getResults();
				if(searchResult.getResults().size() >= reqProducts && totalCost > 0.0)
				{
					ProductSelector pSelector=new ProductSelector(totalCost, reqProducts,itemsSearched.toArray(new Product[itemsSearched.size()]));
					pSelector.selectProducts();
				}
				else {
					System.out.println("Invalid input....");
				}
			}
			catch (Exception e)
			{
				System.out.println("Some Problem with API used..check rate limit and other parameters");
			}								    								  
		}
		else {
			System.out.println("Invalid input....");
		}	    
	    scr.close();
	}
}

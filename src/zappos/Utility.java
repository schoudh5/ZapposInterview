package zappos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


/**
 * This class contains general functions.
 */
public class Utility
{
	
	/**
	 * This functions makes a http connection 
	 * and return the response http response returned by the url
	 *
	 * @param desiredUrl url for which http connection is to be used
	 * @return response from the url
	 * @throws Exception Exception if something bad happens
	 */
	public static String doHttpUrlConnection(String desiredUrl)  throws Exception
	{
		URL url = null;
		BufferedReader reader = null;
		StringBuilder stringBuilder;
		String response="";
		try
		{
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// just want to do an HTTP GET here
			connection.setRequestMethod("GET");
			// give it 15 seconds to respond
			connection.setReadTimeout(15*1000);
			connection.connect();

			// read the output from the server
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			stringBuilder = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null)
			{
				stringBuilder.append(line + "\n");
			}
			response=stringBuilder.toString();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{	 
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		}
		return response;
	}

	/**
	 * Read property from properties file.
	 *
	 * @param propertyName the property name
	 * @return Value of the property stored in the property file
	 */
	public static String ReadProperty(String propertyName)
	{
		Properties prop = new Properties();
		InputStream input = null;
		String propValue="";
		try 
		{
	 
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			propValue= prop.getProperty("product.URL");
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			if (input != null) 
			{
				try 
				{
					input.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return propValue;
	}
	
	public static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public static boolean isInteger(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}

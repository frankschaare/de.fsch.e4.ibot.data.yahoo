/**
 * 
 */
package de.fsch.e4.ibot.data.yahoo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author hit
 *
 */
public class YQLConnection implements IYQLConnection 
{
private	HttpResponse response = null;
	/**
	 * 
	 */
	public YQLConnection() {}

	/* (non-Javadoc)
	 * @see de.fsch.e4.ibot.data.yahoo.IYQLConnection#getData()
	 */
	@Override
	public void getData() 
	{
	String request = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20local.search%20where%20query%3D%22food%22%20and%20location%3D%22crested%20butte%2C%20co%22&format=xml";

	DefaultHttpClient client = new DefaultHttpClient();
	HttpGet get = new HttpGet(request);

		try 
		{
		response = client.execute(get);
		} 
		catch (ClientProtocolException e) 
		{
		e.printStackTrace();
		} 
		catch (IOException e) 
		{
		e.printStackTrace();
		}


		if (response.getEntity() != null) 
		{
			try 
			{
			InputStream in = response.getEntity().getContent();
			} 
			catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			}	
		}

	}

}

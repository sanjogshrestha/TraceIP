package traceip.sanjogpractise.com.traceip.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author SANJOG.STHA
 * @version 1.0
 * @category GPS
 * @zyobalabs pvt ltd 
 * utility classes for creating network
 *
 */
public class NetworkUtility
{

	/**
	 * checks if mobile is connected any internet
	 * @param pContext app context
	 * @return true if internet available
	 */
	public static boolean isNetworkConnected(Context pContext) 
	{
		ConnectivityManager cm = (ConnectivityManager)pContext. getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) 
		{
			// There are no active networks.
			return false;
		} 
		else 
		{
			return true;
		}
	}
}

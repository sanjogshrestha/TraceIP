package traceip.sanjogpractise.com.traceip.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import android.os.StrictMode;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.InputStream;

import traceip.sanjogpractise.com.traceip.R;

/**
 * Created by g40 on 3/6/2015.
 */
public class ServerUtils extends Activity
{
    String value = getIntent().getExtras().getString("key");
    //private Structure pData;


    public static String getIPresponse(Context pContext, Structure pData) {


            int SDK_INT = android.os.Build.VERSION.SDK_INT;
            if (SDK_INT > Build.VERSION_CODES.FROYO) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            // Making HTTP request
            try {

                String Convert_Ip_Url = "http://www.freegeoip.net/json";


                StringBuilder us = new StringBuilder(Convert_Ip_Url);


                us.append("/").append(pData.getIp());

                System.out.println("Convert_Ip_Url=" + Convert_Ip_Url);
                HttpClient httpClient = new DefaultHttpClient();

                HttpGet httpget = new HttpGet(us.toString());
                httpget.setHeader(HTTP.CONTENT_TYPE,"application/json");
                HttpResponse httpResponse = httpClient.execute(httpget);
                HttpEntity httpEntity = httpResponse.getEntity();
                InputStream is = httpEntity.getContent();
                String lResponse = ServerParser.getIPresponse(pContext, is, pData);
                System.out.println("Login Response=" + lResponse);
                if (lResponse != null) {
                    return lResponse;
                }
                return null;

            } catch (Exception e) {
                System.out.println("Registration response exception occured= "
                        + e.getMessage());
                return pContext.getString(R.string.exception_message_text);
            }
        }
}
package traceip.sanjogpractise.com.traceip.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.provider.Settings;
import android.provider.SyncStateContract;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by g40 on 3/6/2015.
 */
public class ServerParser extends Activity {
    public static String getIPresponse(Context pContext, InputStream lResponse, Structure pData) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(lResponse, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        lResponse.close();
        String response = sb.toString();
        System.out.println("Login Results " + response);
        boolean lStatus = response.equalsIgnoreCase("success");
        if (!lStatus) {
            return response;
        }

        return null;
    }

}
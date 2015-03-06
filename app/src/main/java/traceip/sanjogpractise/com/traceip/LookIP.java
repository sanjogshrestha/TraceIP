package traceip.sanjogpractise.com.traceip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import traceip.sanjogpractise.com.traceip.Utils.Content;
import traceip.sanjogpractise.com.traceip.Utils.DialogUtility;
import traceip.sanjogpractise.com.traceip.Utils.NetworkUtility;
import traceip.sanjogpractise.com.traceip.Utils.ServerUtils;
import traceip.sanjogpractise.com.traceip.Utils.Structure;

/**
 * Created by g40 on 3/6/2015.
 */
public class LookIP extends Activity{
    private GoogleMap googleMap;
    public static Structure str;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);
            str = new Structure();
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            googleMap.setBuildingsEnabled(true);

            new Locate_async().execute();

        }
    public class Locate_async extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            showCustomDialogs(PROGRESS_DIALOG);

        }

        @Override
        protected String doInBackground(Void... String) {
                if (!NetworkUtility.isNetworkConnected(LookIP.this))
            {

                return getString(R.string.internet_fail);
            } else {

                    String value = getIntent().getExtras().getString("key");
                    str.setIp(value);
                String lValue = ServerUtils.getIPresponse(LookIP.this, str);

                    System.out.println("ip1="+value);

                if (lValue != null) {
                    Log.i(lValue, "Reset_Value");
                    return lValue;
                }
                return null;
            }

        }

        /* Specifying specific results when hitting api*/
        @Override
        protected void onPostExecute(String result) {
            dismissCustomDialogs(PROGRESS_DIALOG);
            Gson gson = new GsonBuilder().create();
            final Content content = gson.fromJson(result, Content.class);
                LatLng lt = new LatLng(content.getLatitude(), content.getLongitude());

                    googleMap.addMarker(new MarkerOptions()
                            .position(lt)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker))
                            .snippet("City =" +content.getCity() + "  "+"Zip Code ="+content.getZip_code())
                            .title(content.getCountry_name())
                    );



                            //Create a new CameraPosition
                            CameraPosition cameraPosition =
                                    new CameraPosition.Builder()
                                            .target(lt)
                                            .bearing(2)
                                            .tilt(90)
                                            .zoom(12)
                                            .build();


                            googleMap.animateCamera(
                                    CameraUpdateFactory.newCameraPosition(cameraPosition),
                                    5000,
                                    null);

                }

        }
    /**
     * constant value for progress dialog
     */
    private final int PROGRESS_DIALOG = 1;
    /**
     * Progress dialog view.
     */
    private Dialog mProgressDialog;

    /**
     * Displays our custom dialogs
     */
    private void showCustomDialogs(int pId) {
        switch (pId) {
            case PROGRESS_DIALOG:
                mProgressDialog = DialogUtility.getProgressDialog(LookIP.this, null);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
                break;
            default:
                break;
        }
    }

    /**
     * Dismiss our custom dialogs
     */
    private void dismissCustomDialogs(int pId) {
        switch (pId) {
            case PROGRESS_DIALOG:
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.cancel();
                }
                break;

            default:
                break;
        }
    }
    }



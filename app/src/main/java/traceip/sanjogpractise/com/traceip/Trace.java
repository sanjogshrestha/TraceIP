package traceip.sanjogpractise.com.traceip;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import traceip.sanjogpractise.com.traceip.Utils.IpValidator;
import traceip.sanjogpractise.com.traceip.Utils.NetworkUtility;
import traceip.sanjogpractise.com.traceip.Utils.Structure;


public class Trace extends ActionBarActivity
{

    private Button look_up_btn;
    private EditText enter_ip;
    private TextView ip;
    private Structure str;
    String ip_addr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);
        uicomponents();

    }

    private void uicomponents() {
        str = new Structure();
        enter_ip = (EditText)findViewById(R.id.ip_text);
        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
        ip_addr = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        ip=(TextView)findViewById(R.id.your_ip_address);
        ip.setText(ip_addr);

        look_up_btn =(Button)findViewById(R.id.look_btn);
        look_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateIP();
            }
        });
    }

    private void validateIP()
    {
        if(!IpValidator.isValidIP(enter_ip.getText().toString().trim()))
        {
            Toast.makeText(Trace.this,"Please enter the valid IP address",Toast.LENGTH_SHORT).show();
        }
        else
        {


            str.setIp(enter_ip.getText().toString().trim());

            System.out.println("ip="+str.getIp());

            Intent next = new Intent(Trace.this,LookIP.class);
            next.putExtra("key",str.getIp());
            startActivity(next);
            //finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trace, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

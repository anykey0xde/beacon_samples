package pak.ble.sample;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends Activity {

    AndroidBLEBoilerplate ble;
    ExpandableListView bleView;
    BLEScanAdapter bleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ble = new AndroidBLEBoilerplate();
        this.ble.setActivity(this);
        if (!this.ble.init()) {
            die("BLE not working!");
        }



        bleView = (ExpandableListView)findViewById(R.id.scanListView);
        bleAdapter = new BLEScanAdapter(this);
        bleView.setAdapter(bleAdapter);

        d("ok");

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.ble.scan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case AndroidBLEBoilerplate.ENABLE_BT_ACTIVITY:
                if ( resultCode == Activity.RESULT_CANCELED ){
                    die("Must allow BLE!");
                }
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    void updateUI(final BLEScanResult result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bleAdapter.addBLEScanResult(result);
            }
        });
    }

    void updateUIClearBLEList() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bleAdapter.clear();
            }
        });
    }


    static String TAG = MainActivity.class.getSimpleName();

    static void e (String mes) {
        Log.e(TAG, mes);
    }
    static void d (String mes) {
        Log.d(TAG, mes);
    }
    void t (String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT);
    }

    void die (String mes) {
        t(mes);
        Log.d("ble", mes);
        Log.d("ble", "giving up :(");
        finish();
    }

}

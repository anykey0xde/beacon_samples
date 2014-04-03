package pak.ble.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    AndroidBLEBoilerplate ble;
    ExpandableListView    bleView;
    BLEScanAdapter        bleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        d("ON_CREATE");
        setContentView(R.layout.activity_main);

        this.ble = AndroidBLEBoilerplate.getBLE();
        this.ble.setActivity(this);
        if (!this.ble.init()) {
            die("BLE not working!");
        }

        bleView    = (ExpandableListView)findViewById(R.id.scanListView);

        bleAdapter = new BLEScanAdapter(this);
        bleAdapter.bleScanResultMap = ble.bleScanResultMap;

        bleView.setAdapter(bleAdapter);



        d("ok");

    }

    @Override
    protected void onStart() {
        super.onStart();
        d("ON_START");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        d("ON_RESTART");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        d("ON_POST_RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        d("ON_PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("ON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d("ON_DESTROY");
        //save list of scanned devices in BLE DingDong
        this.ble.bleScanResultMap = this.bleAdapter.bleScanResultMap;
    }

    @Override
    protected void onResume() {
        super.onResume();
        d("ON_RESUME");
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
        getMenuInflater().inflate(R.menu.main, menu);
        if (!ble.scanning) {
            menu.findItem(R.id.menu_stop).setVisible(false);
            menu.findItem(R.id.menu_scan).setVisible(true);
            menu.findItem(R.id.menu_refresh).setActionView(null);
        } else {
            menu.findItem(R.id.menu_stop).setVisible(true);
            menu.findItem(R.id.menu_scan).setVisible(false);
            menu.findItem(R.id.menu_refresh).setActionView(R.layout.actionbar_indeterminate_progress);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        d("fuck you android");
        switch (item.getItemId()) {
            case R.id.menu_scan:
                ble.scan();
                break;
            case R.id.menu_stop:
                ble.stopScan();
                break;
        }
        return true;
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

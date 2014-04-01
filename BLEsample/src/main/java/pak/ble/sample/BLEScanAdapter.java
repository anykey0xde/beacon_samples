package pak.ble.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by a2800276 on 31/03/14.
 */
public class BLEScanAdapter extends BaseExpandableListAdapter {

    private final Context ctx;
    Map<String, BLEScanResult> bleScanResultMap;

    public BLEScanAdapter(Context ctx) {
        this.bleScanResultMap = new HashMap<String, BLEScanResult>();
        this.ctx = ctx;
    }

    public void clear() {
        bleScanResultMap.clear();
    }
    public void addBLEScanResult(BLEScanResult ble) {
        bleScanResultMap.put(ble.device.getAddress(), ble);
        notifyDataSetChanged();
    }



    @Override
    public int getGroupCount() {
        return bleScanResultMap.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 2;
    }

    List<BLEScanResult> scanResultsByRSSI () {
        List<BLEScanResult> list = new LinkedList<BLEScanResult>(bleScanResultMap.values());
        Collections.sort(list);
        return list;
    }

    @Override
    public Object getGroup(int i) {
        return scanResultsByRSSI().get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        BLEScanResult res = (BLEScanResult)getGroup(i);
        switch (i2) {
            case 0: return res.getRSSI();
            case 1: return res.getAdvertisement();
        }
        return "?";
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2 << i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        BLEScanResult scanResult = (BLEScanResult)getGroup(i);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.ble_scan_result_group_view, viewGroup, false);


        }
       // TextView tv = (TextView) view.findViewById(R.id.bleGroupExpanded);
       // tv.setText( isExpanded ? "-" : "+") ;

        TextView tv = (TextView) view.findViewById(R.id.bleGroupName);
        tv.setText(scanResult.getName());

        tv = (TextView) view.findViewById(R.id.bleGroupAddr);
        tv.setText(scanResult.device.getAddress());

        tv = (TextView) view.findViewById(R.id.bleGroupRSSI);
        tv.setText(scanResult.getRSSI());


        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new TextView(ctx);
        }
        ((TextView)view).setText(getChild(i,i2).toString());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}

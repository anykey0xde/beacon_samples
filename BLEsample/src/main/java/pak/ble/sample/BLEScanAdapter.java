package pak.ble.sample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by a2800276 on 31/03/14.
 */
public class BLEScanAdapter extends BaseExpandableListAdapter {

    private final MainActivity ctx;
    Map<String,BLEScanResult> bleScanResultMap;

    public BLEScanAdapter(MainActivity ctx) {
        // set up by onStart ...

        this.ctx = ctx;
        this.bleScanResultMap = ctx.ble.bleScanResultMap;
    }







    @Override
    public int getGroupCount() {
        return bleScanResultMap.size();
    }

    @Override
    public int getChildrenCount(int i) {
        Log.d(">getChildrenCount ", "i:" + i);

        BLEAdvertisingData advData = ((BLEScanResult)getGroup(i)).record;
        int count = advData.entries.size()+1;
        Log.d("<getChildrenCount ", "count:" + count);
        return count;
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
        Log.d("getChild ", "i:" + i + "i2:" + i2);
        BLEScanResult res = (BLEScanResult)getGroup(i);
        switch (i2) {
            case 0: return res;
        }
        return "?";
    }

    @Override
    public long getGroupId(int i) {
        Log.d("getGroupId", "> " + i);
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        Log.d("getChildId", "> "+i+" "+i2);
        return (i<<2)+i2;
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


        TextView tv = (TextView) view.findViewById(R.id.bleGroupName);
        tv.setText(scanResult.getName());

        if (scanResult.old) {
            tv.setTextColor(Color.GRAY);
        } else {
            tv.setTextColor(Color.BLACK);
        }

        tv = (TextView) view.findViewById(R.id.bleGroupAddr);
        tv.setText(scanResult.device.getAddress());

        tv = (TextView) view.findViewById(R.id.bleGroupRSSI);
        tv.setText(scanResult.getRSSI());


        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLast, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
//                    (Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.ble_scan_device, viewGroup, false);
//        }
//        final ExpandableListView deviceView = (ExpandableListView)view.findViewById(R.id.bleScanDeviceListView);
//        deviceView.setAdapter(new BLEDeviceAdapter(ctx, (BLEScanResult) getGroup(i)));
//        deviceView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int i) {
//                ctx.bleView.requestLayout();
//            }
//        });
//        return view;

        Log.d("getChildView", "groupPosition: " + groupPosition+ " childPosition: " + childPosition + "isLast: " + isLast);

        if (view == null) {
            view = new TextView(ctx);
        }
        BLEScanResult scanResult = (BLEScanResult)getGroup(groupPosition);
        if (childPosition == 0) {
            ((TextView)view).setText(scanResult.getAdvertisement());
            ((TextView)view).setTypeface(Typeface.MONOSPACE);
        } else {
            ((TextView)view).setText(scanResult.record.entries.get(childPosition-1).toString());
            ((TextView)view).setTypeface(Typeface.DEFAULT);
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}

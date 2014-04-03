package pak.ble.sample;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by a2800276 on 02/04/14.
 */
public class BLEDeviceAdapter extends BaseExpandableListAdapter {

    final BLEScanResult device;
    final Context ctx;

    public BLEDeviceAdapter(Context ctx, BLEScanResult device) {
        this.device = device;
        this.ctx = ctx;
    }

    @Override
    public int getGroupCount() {
        return 2;
    }

    @Override
    public int getChildrenCount(int i) {
        Log.d("bla", "getChildrenCount");
        return 10;
    }

    @Override
    public Object getGroup(int i) {
        switch (i){
            case 0: return "Advertising Data";
            default: return "unknown";
        }
    }

    @Override
    public Object getChild(int i, int i2) {
        Log.d("getChildView", getChild(i, i2).toString());

        Log.d("bla", "getChild");
        switch (i) {
            case 0:
                switch (i2) {
                    case 0: return this.device.getAdvertisement();
                    default : return "unknown";
                }
            default: return "unknown";
        }
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
        view = (TextView)((view == null) ? new TextView(this.ctx) : view);
        ((TextView)view).setText(getGroup(i).toString());
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        Log.d("bla", "getChildView");
        view = (TextView)((view == null) ? new TextView(this.ctx) : view);
        ((TextView)view).setText(getChild(i, i2).toString());
        Log.d("getChildView", getChild(i, i2).toString());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}

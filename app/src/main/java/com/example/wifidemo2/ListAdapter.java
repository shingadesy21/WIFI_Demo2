package com.example.wifidemo2;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<ScanResult> wifiList;

    public ListAdapter(Context context,List<ScanResult> wifiList) {
    this.context=context;
    this.wifiList=wifiList;

    inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return wifiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        Holder holder;
        View view=convertview;
        if(view==null){
            view=inflater.inflate(R.layout.list_item,null);
            holder=new Holder();
            holder.tvDetails=(TextView)view.findViewById(R.id.textWifiName);
            view.setTag(holder);
        }
        else {
            holder=(Holder)view.getTag();
        }
        holder.tvDetails.setText(wifiList.get(i).SSID);
        return view;
    }
    class Holder{
        TextView tvDetails;
    }
}

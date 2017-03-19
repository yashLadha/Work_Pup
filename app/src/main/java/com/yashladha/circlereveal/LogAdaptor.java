package com.yashladha.circlereveal;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CircleReveal on 18/3/17.
 */

public class LogAdaptor extends ArrayAdapter<technicalWork> {

    private Context context;

    public LogAdaptor(@NonNull Context context, @LayoutRes int resource, @NonNull List<technicalWork> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_log, null);
        }
        technicalWork temp = getItem(position);
        TextView type = (TextView) v.findViewById(R.id.tvItemType);
        TextView month = (TextView) v.findViewById(R.id.tvItemMonth);
        TextView date = (TextView) v.findViewById(R.id.tvItemDate);

        type.setText(temp.getType());
        month.setText(temp.getMonth());
        date.setText(temp.getDate());
        return v;
    }
}

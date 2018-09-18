package com.developers.developers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NameAdapter extends ArrayAdapter<TeamName> {

    public NameAdapter(Context context,  ArrayList<TeamName> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TeamName cTeamName = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.title);
        name.setText(cTeamName.getName());

        ImageView image = (ImageView) listItemView.findViewById(R.id.imageview);
        image.setImageResource(cTeamName.getmImage());

        return listItemView;
    }
}

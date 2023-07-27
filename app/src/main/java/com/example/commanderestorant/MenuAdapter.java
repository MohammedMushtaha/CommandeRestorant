package com.example.commanderestorant;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commanderestorant.SharedPreferanse.SharedPreferanse;
import com.example.commanderestorant.auth.Login.LoginActivity;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoOptionView;


class MenuAdapter extends BaseAdapter {

    private ArrayList<String> mOptions = new ArrayList<>();
    private ArrayList<DuoOptionView> mOptionViews = new ArrayList<>();

    MenuAdapter(ArrayList<String> options) {
        mOptions = options;
    }


    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return mOptions.get(position);
    }

    void setViewSelected(int position, boolean selected) {

        // Looping through the options in the menu
        // Selecting the chosen option
        Log.e("asdasd123", "" + position);

        for (int i = 0; i < mOptionViews.size(); i++) {
            if (i == position) {
                mOptionViews.get(i).setSelected(selected);
            } else {
                mOptionViews.get(i).setSelected(!selected);
            }
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        SharedPreferanse.write(SharedPreferanse.position, position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nav, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String itemText = mOptions.get(position);
        viewHolder.textView.setText(itemText);

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}

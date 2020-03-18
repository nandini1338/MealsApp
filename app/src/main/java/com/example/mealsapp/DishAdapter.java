package com.example.mealsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DishAdapter extends ArrayAdapter<DishItem> {

    public DishAdapter (Context context, ArrayList<DishItem> dishList){
        super(context, 0 , dishList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.dishes_spinner_row, parent, false
            );
        }

        ImageView imageViewPic = convertView.findViewById(R.id.dish_view);
        TextView textViewName = convertView.findViewById(R.id.dishname_view);

        DishItem currentItem = getItem(position);

        if(currentItem != null) {
            imageViewPic.setImageResource(currentItem.getPic());
            textViewName.setText(currentItem.getDishName());
        }
        return convertView;
    }
}

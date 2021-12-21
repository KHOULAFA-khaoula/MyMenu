package com.example.restaurant.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.restaurant.R;
import com.example.restaurant.model.Category;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Category> {
    private Context context;

    private Category[] listeCategory;

    public MyAdapter( Context context, Category[] listeCategory) {
        super(context, R.layout.category_item, listeCategory);
        this.listeCategory = listeCategory;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // Permet de lier un layout à un autre
        LayoutInflater inflater = LayoutInflater.from(getContext());

        //Layout View ==> créer un view a adpatée

        View listItemView = inflater.inflate(R.layout.category_item, parent, false);

        TextView CategoryNom = (TextView) listItemView.findViewById(R.id.textView);

        CategoryNom.setText(listeCategory[position].getNom_category());
        listItemView.setBackgroundResource(listeCategory[position].getImage());

        return listItemView;

    }

}

package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant.adapter.MyAdapter;
import com.example.restaurant.model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper myDB;
    ArrayList<String> _id,nomRest,nomCat,descreption,adresse,telephone,option,image,menu_img,reduction,category,speciality;
    //CustomAdapter customAdapter;
    ListView l1;
    Category[] categories;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_home);
      //  recyclerView = findViewById(R.id.recyclerView);
        l1 = findViewById(R.id.listview);
        myDB = new DatabaseHelper(this);
       /* _id = new ArrayList<>();
        nomRest = new ArrayList<>();
        nomCat = new ArrayList<>();
        descreption = new ArrayList<>();
        adresse = new ArrayList<>();
        telephone = new ArrayList<>();
        option = new ArrayList<>();
        image = new ArrayList<>();
        menu_img = new ArrayList<>();
        reduction = new ArrayList<>();
        category = new ArrayList<>();
        speciality = new ArrayList<>();

*/
        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);
        if (firstStart){
            InsertData();
        }
        ShowCategories();
        //customAdapter = new CustomAdapter(Home.this,_id,nomRest,nomCat,reduction);
 /*       customAdapter = new CustomAdapter(Home.this,nomCat);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Home.this));
    */}

    private void InsertData(){
        DatabaseHelper inst = new DatabaseHelper(MainActivity.this);
        inst.addData();
        Log.d("creation","Accessed To DB");
        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }

    void ShowCategories() {
        categories = myDB.getAllCategories();
        myAdapter = new MyAdapter(this, categories);
        l1.setAdapter(myAdapter);
    }

       /* if (cursor.getCount() == 0) {
            //Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            buffer="NO DATA FOUND!!!";
        } else {
            while (cursor.moveToNext()) {
              /*  _id.add(cursor.getString(0));
                nomRest.add(cursor.getString(1));
                nomCat.add(cursor.getString(2));
               descreption.add(cursor.getString(3));
                adresse.add(cursor.getString(4));
                telephone.add(cursor.getString(5));
                option.add(cursor.getString(6));
                image.add(cursor.getString(7));
                menu_img.add(cursor.getString(8));
                reduction.add(cursor.getString(9));*/
                //category.add(cursor.getString(10));
              //  buffer="Category " ;
               // buffer="Category " +cursor.getString(10) +"\n";
                /*   speciality.add(cursor.getString(11));*/
        /*    }
        }
        textResultat.setText(buffer);
    }*/
    //To store the data in array
   /* void StoreData(){
        Cursor cursor = myDB.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
              /*  _id.add(cursor.getString(0));
                nomRest.add(cursor.getString(1));
                nomCat.add(cursor.getString(2));
              /*  descreption.add(cursor.getString(3));
                adresse.add(cursor.getString(4));
                telephone.add(cursor.getString(5));
                option.add(cursor.getString(6));
                image.add(cursor.getString(7));
                menu_img.add(cursor.getString(8));
                reduction.add(cursor.getString(9));
                category.add(cursor.getString(10));
                speciality.add(cursor.getString(11));
            }
        }*/
    }

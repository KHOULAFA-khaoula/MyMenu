package com.example.restaurant;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.restaurant.model.Category;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    public static final String DB_NAME ="My_Menu.db";
    public static final  int DB_version = 1;
    private Context context;
    public static final  String Table_NameF = "restaurant_table";
    public static final  String Table_NameD1 = "category_table";
    public static final  String Table_NameD2 = "option_table";
    public static final  String Column_id = "_id";
    public static final  String Column_Nom = "nomRest";
    public static final  String Column_Description = "descreption";
    public static final  String Column_Adresse = "adresse";
    public static final  String Column_Telephone = "telephone";
    public static final  String Column_Option = "option";
    public static final  String Column_Image = "image";
    public static final  String Column_Menu_img = "menu_img";
    public static final  String Column_Reduction = "reduction";
    public static final  String Column_Category = "category";
    public static final  String Column_Speciality = "speciality";
    public static final  String Column_id_op = "_id";
    public static final  String Column_id_cat = "_id";
    public static final  String Column_Nom_cat = "nomCat";
    public static final  String Column_Img_Cat ="Image_category";
    public static final  String Column_Nom_op = "nomOpt";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_version);
        Log.d("const", "in middle of construction");
        SQLiteDatabase db = this.getWritableDatabase();
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            Log.d("creat","in middle of construction");
            String queryD1 = "create table "+Table_NameD1+"("+Column_id_cat+" Integer primary key AUTOINCREMENT,"+Column_Nom_cat+" Text,"+Column_Img_Cat+" INTEGER"+");";
            //String queryD2 = "create table "+Table_NameD2+"("+Column_id_op+" Integer primary key AUTOINCREMENT,"+Column_Nom_op+" Text"+");";
            String queryF  = "create table "+Table_NameF+"("+Column_id+" Integer primary key AUTOINCREMENT,"+Column_Nom+" Text,"+Column_Nom_cat+" Text,"+Column_Description+" Text,"+Column_Adresse+" Text,"+Column_Telephone+" Text,"+Column_Option+" Text,"+Column_Image+" Text,"+Column_Menu_img+" Text,"+Column_Reduction+" Text,"+Column_Category+" Text,"+Column_Speciality+" Text,"+"FOREIGN KEY("+Column_Option+") REFERENCES "+Table_NameD2+"("+Column_id_op+"),"+"FOREIGN KEY("+Column_Nom_cat+") REFERENCES "+Table_NameD1+"("+Column_id_cat+"));";
            db.execSQL(queryD1);
           // db.execSQL(queryD2);
            db.execSQL(queryF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_NameF);
        onCreate(db);

    }

    void addData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_Nom_cat,"FAST-FOOD");
        cv.put(Column_Img_Cat,R.drawable.fastfood);
        db.insert(Table_NameD1,null,cv);
        cv.put(Column_Nom_cat,"ITALIEN");
        cv.put(Column_Img_Cat,R.drawable.italian);
        db.insert(Table_NameD1,null,cv);
        cv.put(Column_Nom_cat,"COFFE");
        cv.put(Column_Img_Cat,R.drawable.coffe);
        db.insert(Table_NameD1,null,cv);
        cv.put(Column_Nom_cat,"ASIAN");
        cv.put(Column_Img_Cat,R.drawable.asian);
        db.insert(Table_NameD1,null,cv);

    }
    Cursor readCategories(){
        String query = "SELECT * FROM "+Table_NameD1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    public Category[] getAllCategories()
    {
        ArrayList<Category> categoryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Table_NameD1,null);

        while (cursor.moveToNext())
        {
            int id =  cursor.getInt(0);
            String category_name = cursor.getString(1);
            int image = cursor.getInt(2);
            Category category = new Category(id,category_name,image);
            categoryList.add(category);
        }
        return categoryList.toArray(new Category[categoryList.size()]);
    }

}

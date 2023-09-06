package com.example.fitapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(Context context) {
        super(context, "fooddata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Fooddata(mealname TEXT primary key, mealtype TEXT, calories TEXT, protein TEXT, carbs TEXT, fats TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Fooddata");
    }

    public Boolean savedata(String mealname, String mealtype, String calories, String protein, String carbs, String fats){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mealname", mealname);
        contentValues.put("mealtype", mealtype);
        contentValues.put("calories", calories);
        contentValues.put("protein", protein);
        contentValues.put("carbs", carbs);
        contentValues.put("fats", fats);
        long result = sqLiteDatabase.insert("Fooddata", null, contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean updatedata(String mealname, String mealtype, String calories, String protein, String carbs, String fats){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mealtype", mealtype);
        contentValues.put("calories", calories);
        contentValues.put("protein", protein);
        contentValues.put("carbs", carbs);
        contentValues.put("fats", fats);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Fooddata where mealname = ?", new String[] {mealname});
        if (cursor.getCount()>0) {
            long result = sqLiteDatabase.update("Fooddata", contentValues, "mealname=?", new String[] {mealname});
            return result != -1;
        }
        else {
            return  false;
        }
    }

    public Boolean deletedata(String mealname){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Fooddata where mealname = ?", new String[] {mealname});
        if (cursor.getCount()>0) {
            long result = sqLiteDatabase.delete("Fooddata","mealname=?", new String[] {mealname});
            return result != -1;
        }
        else {
            return  false;
        }
    }

    public Cursor getdata(){
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery("select * from Fooddata", null);
    return cursor;
}

    public int getTotalCalories() {
        int totalCal = 0;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT calories FROM Fooddata", null);

        if (cursor.moveToFirst()) {
            do {
                int cals = cursor.getInt(cursor.getColumnIndexOrThrow("calories"));
                totalCal += cals;
            } while (cursor.moveToNext());
        }

        cursor.close();
        return totalCal;
    }

    public int getTotalProtein() {
        int totalpro = 0;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT protein FROM Fooddata", null);

        if (cursor.moveToFirst()) {
            do {
                int pro = cursor.getInt(cursor.getColumnIndexOrThrow("protein"));
                totalpro += pro;
            } while (cursor.moveToNext());
        }

        cursor.close();
        return totalpro;
    }

    public int getTotalCarbs() {
        int totalcarbs = 0;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT carbs FROM Fooddata", null);

        if (cursor.moveToFirst()) {
            do {
                int carb = cursor.getInt(cursor.getColumnIndexOrThrow("carbs"));
                totalcarbs += carb;
            } while (cursor.moveToNext());
        }

        cursor.close();
        return totalcarbs;
    }

    public int getTotalFats() {
        int totalfats = 0;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT fats FROM Fooddata", null);

        if (cursor.moveToFirst()) {
            do {
                int fat = cursor.getInt(cursor.getColumnIndexOrThrow("fats"));
                totalfats += fat;
            } while (cursor.moveToNext());
        }

        cursor.close();
        return totalfats;
    }
}

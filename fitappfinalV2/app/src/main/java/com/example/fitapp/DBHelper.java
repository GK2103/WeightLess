package com.example.fitapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "workoutdata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Workoutdata(exercise TEXT primary key, sets TEXT, reps TEXT, weight TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Workoutdata");

    }

    public Boolean saveuserdata(String exercise, String sets, String reps, String weight){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("exercise", exercise);
        contentValues.put("sets", sets);
        contentValues.put("reps", reps);
        contentValues.put("weight", weight);
        long result = sqLiteDatabase.insert("Workoutdata", null, contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }


    public Boolean updateuserdata(String exercise, String sets, String reps, String weight){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sets", sets);
        contentValues.put("reps", reps);
        contentValues.put("weight", weight);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Workoutdata where exercise = ?", new String[] {exercise});
        if(cursor.getCount()>0) {
            long result = sqLiteDatabase.update("Workoutdata", contentValues,"exercise=?", new String[] {exercise});
            return result != -1;
        }
        else {
            return false;
        }
    }

    public Boolean deleteuserdata(String exercise){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Workoutdata where exercise = ?", new String[] {exercise});
        if(cursor.getCount()>0) {
            long result = sqLiteDatabase.delete("Workoutdata","exercise=?", new String[] {exercise});
            return result != -1;
        }
        else {
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Workoutdata", null);
        return cursor;
    }
}

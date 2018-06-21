package com.yangzxcc.macintoshhd.pehs.sql.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yangzxcc.macintoshhd.pehs.sql.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    //Database Version
    private static final int DATABASE_VERSION = 2;

    //Database Name
    private static final String dbName = "pehsDB";

    //Patient table name
    private static final String tableName = "patient";

    //Patient Tables Columns names
    private static final String idColumn = "id";
    private static final String usernameColumn = "username";
    private static final String passwordColumn = "password";
    private static final String nameColumn = "name";

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, dbName, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + tableName + "(" +
                idColumn + " integer primary key autoincrement," +
                usernameColumn + " text, " +
                passwordColumn + " text, " +
                nameColumn + " text " +
                        ")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        //Drop Patient Table if exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
        //Create tables again
        onCreate(sqLiteDatabase);
    }
    public boolean create(Patient patient){
         boolean result = true;
         try {
             SQLiteDatabase sqLiteDatabase = getWritableDatabase();
             ContentValues contentValues = new ContentValues();
             contentValues.put(usernameColumn,patient.getUsername());
             contentValues.put(passwordColumn,patient.getPassword());
             contentValues.put(nameColumn,patient.getName());
             result = sqLiteDatabase.insert(tableName,null,contentValues) > 0;
             sqLiteDatabase.close();

         }catch (Exception e){
             result = false;
         }
         return result;
    }
    public boolean update(Patient patient){
        boolean result = true;
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(usernameColumn,patient.getUsername());
            contentValues.put(passwordColumn,patient.getPassword());
            contentValues.put(nameColumn,patient.getName());
            result = sqLiteDatabase.update(tableName,contentValues,idColumn + " = ?",new String[]{String.valueOf(patient.getId())}) > 0;

            sqLiteDatabase.close();

        }catch (Exception e){
            result = false;
        }
        return result;
    }
    public Patient login(String username, String password){
        Patient patient = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where " +
                    "username = ? and password = ?", new String[]{username,password});
            if (cursor.moveToFirst()){
                patient = new Patient();
                patient.setId(cursor.getInt(0));
                patient.setUsername(cursor.getString(1));
                patient.setPassword(cursor.getString(2));
                patient.setName(cursor.getString(3));
            }
        } catch (Exception e){
            patient = null;
        }
        return patient;
    }
    public Patient find(int id){
        Patient patient = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where " +
                    "id = ?",new String[]{String.valueOf(id)});
            if (cursor.moveToFirst()){
                patient = new Patient();
                patient.setId(cursor.getInt(0));
                patient.setUsername(cursor.getString(1));
                patient.setPassword(cursor.getString(2));
                patient.setName(cursor.getString(3));
            }
        } catch (Exception e){
            patient = null;
        }
        return patient;
    }
    public Patient checkUsername(String username){
        Patient patient = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName + " where " +
                    "username = ?",new String[]{username});
            if (cursor.moveToFirst()){
                patient = new Patient();
                patient.setId(cursor.getInt(0));
                patient.setUsername(cursor.getString(1));
                patient.setPassword(cursor.getString(2));
                patient.setName(cursor.getString(3));
            }
        } catch (Exception e){
            patient = null;
        }
        return patient;
    }
}

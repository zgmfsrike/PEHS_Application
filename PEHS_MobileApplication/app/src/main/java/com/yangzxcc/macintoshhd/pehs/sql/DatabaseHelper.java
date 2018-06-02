package com.yangzxcc.macintoshhd.pehs.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Statement;

public class DatabaseHelper extends SQLiteOpenHelper{


    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "PEHS.db";

    //Patient table name
    public static final String TABLE_PATIENT = "patient";

    //Patient Tables Columns names
    private static final String COLUMN_PATIENT_ID = "patientId";
    public static final String COLUMN_PATIENT_USERNAME = "username";
    public static final String COLUMN_PATIENT_PASSWORD = "password";
    public static final String COLUMN_PATIENT_NAME = "name";
    public static final String COLUMN_PATIENT_SURNAME = "surname";
    private static final String COLUMN_PATIENT_DOB = "dateOfBirth";
    public static final String COLUMN_PATIENT_ADDRESS = "address";
    public static final String COLUMN_PATIENT_EMAIL = "email";
    public static final String COLUMN_PATIENT_TELEPHONE_NUMBER = "telephoneNumber";
    private static final String COLUMN_PATIENT_GENDER = "gender";
    private static final String COLUMN_PATIENT_BLOOD_TYPE = "bloodType";
    private static final String COLUMN_PATIENT_NATIONAL_ID = "nationalId";
    private static final String COLUMN_PATIENT_NATIONALITY = "nationality";
    private static final String COLUMN_PATIENT_DRUG_ALLERGY = "drugAllergy";
    private static final String COLUMN_PATIENT_UNDERLYING_DISEASE = "underlyingDisease";

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PATIENT + "(patientId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, password TEXT, name TEXT, surname TEXT, address TEXT, " +
                "email TEXT, telephoneNumber TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop Patient Table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENT);
        //Create tables again
        onCreate(db);
    }
}

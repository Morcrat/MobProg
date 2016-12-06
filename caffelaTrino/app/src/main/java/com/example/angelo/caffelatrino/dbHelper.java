package com.example.angelo.caffelatrino;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    public SQLiteDatabase DB;
    public String DBPath;
    public static String DBName = "BrandTrue";
    public static final int version = '1';
    public static Context currentContext;
    public static String tableName = "Alcol";

    public dbHelper(Context context) {
        super(context, DBName, null, version);
        currentContext = context;
        DBPath = "/data/data/" + context.getPackageName() + "/databases";
        createDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub

    }

    private void createDatabase() {
        boolean dbExists = checkDbExists();

        if (dbExists) {
        } else {
            DB = currentContext.openOrCreateDatabase(DBName, 0, null);
            DB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    tableName +
                    " (Brand VARCHAR, Gradation INT(3));");

            DB.execSQL("INSERT INTO " +
                    tableName +
                    " Values ('moretta farese', 25);");
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " Values ('ponce', 25);");
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " Values ('resentin', 20);");
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " Values ('grappa', 25);");
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " Values ('sambuca', 25);");
            DB.execSQL("INSERT INTO " +
                    tableName +
                    " Values ('brandy', 20);");
        }


    }

    private boolean checkDbExists() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DBPath + DBName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

        }

        if (checkDB != null) {

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }
}
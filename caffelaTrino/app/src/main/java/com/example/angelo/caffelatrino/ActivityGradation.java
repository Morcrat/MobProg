package com.example.angelo.caffelatrino;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityGradation extends AppCompatActivity {

    private ArrayList<String> resultsBrand = new ArrayList<String>();
    private ArrayList<Integer> resultsGradation = new ArrayList<>();
    private ArrayList<String> results = new ArrayList<String>();
    private String tableName = dbHelper.tableName;
    private SQLiteDatabase newDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradation);

        final ListView listViewAlcol = (ListView) findViewById(R.id.listViewAlcol);
        openAndQueryDatabase();

        listViewAlcol.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , results));

        listViewAlcol.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                ActivityCoffee.setValueBrand(resultsBrand.get(position));
                ActivityCoffee.setValueGradation(resultsGradation.get(position));
                ActivityGradation.this.finish();
            }
        });

    }


    private void openAndQueryDatabase() {
        try {
            dbHelper dbHelper = new dbHelper(this.getApplicationContext());
            newDB = dbHelper.getWritableDatabase();

            String  brand  = this.getString(R.string.brand);
            String  content  = this.getString(R.string.content);

            Cursor c = newDB.rawQuery("SELECT Brand, Gradation FROM " + tableName , null);
            if (c != null ) {
                if (c.moveToFirst()) {
                    do {
                        String brandName = c.getString(c.getColumnIndex("Brand"));
                        int gradation = c.getInt(c.getColumnIndex("Gradation"));

                        resultsBrand.add(brandName);
                        resultsGradation.add(gradation);
                        results.add( brand + ": " + brandName +"   " + content + ": " + gradation);
                    }while (c.moveToNext());
                }
            }
        } catch (SQLiteException se ) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
            if (newDB != null)
                newDB.execSQL("DELETE FROM " + tableName);
            newDB.close();
        }

    }
}

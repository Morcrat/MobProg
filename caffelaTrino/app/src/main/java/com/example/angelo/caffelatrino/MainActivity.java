package com.example.angelo.caffelatrino;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectCoffee(View view) {
        Button button = (Button) view;

        String  espresso  = this.getString(R.string.espresso);
        String  ginseng  = this.getString(R.string.ginseng);

        String espressoCoffee = this.getString(R.string.espressoCoffee);
        String ginsengCoffee = this.getString(R.string.ginsengCoffee);
        String barleyCoffee = this.getString(R.string.barleyCoffee);

        Intent intent = new Intent(this, ActivityCoffee.class);

        if(button.getText().equals(espresso)){
            ActivityCoffee.setValueCoffee(espressoCoffee);
        }else {
            if (button.getText().equals(ginseng)) {
                ActivityCoffee.setValueCoffee(ginsengCoffee);
            }
            else{
                ActivityCoffee.setValueCoffee(barleyCoffee);
            }
        }
        startActivity(intent);

    }

    public void exit(View view){
        String  exitString = this.getString(R.string.exitStr);
        String  yes  = this.getString(R.string.yes);
        String  no   = this.getString(R.string.no);
        new AlertDialog.Builder(this)
                .setMessage(exitString)
                .setCancelable(false)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton(no, null)
                .show();
    }
}

package com.example.angelo.caffelatrino;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

public class ActivityCoffee extends AppCompatActivity {

    private static String valueBrand = "";
    private static String valueCoffee = "";
    private static Integer valueGradation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        CheckBox checkBoxSugar      = (CheckBox) findViewById(R.id.checkBoxSugar);
        CheckBox checkBoxBrownSugar = (CheckBox) findViewById(R.id.checkBoxBrownSugar);
        CheckBox checkBoxSweetener  = (CheckBox) findViewById(R.id.checkBoxSweetener);
        CheckBox checkBoxHoney      = (CheckBox) findViewById(R.id.checkBoxHoney);

        checkBoxSugar.setVisibility(View.INVISIBLE);
        checkBoxBrownSugar.setVisibility(View.INVISIBLE);
        checkBoxSweetener.setVisibility(View.INVISIBLE);
        checkBoxHoney.setVisibility(View.INVISIBLE);

        checkBoxSugar.setChecked(true);

        ToggleButton toggleButtonGradation = (ToggleButton) findViewById(R.id.toggleButtonGradation);
        ToggleButton toggleButtonMilk = (ToggleButton) findViewById(R.id.toggleButtonMilk);

        String ginsengCoffee = this.getString(R.string.ginsengCoffee);
        String barleyCoffee = this.getString(R.string.barleyCoffee);

        toggleButtonGradation.setVisibility(View.VISIBLE);
        toggleButtonMilk.setVisibility(View.VISIBLE);

        if(valueCoffee.equals(ginsengCoffee) || valueCoffee.equals(barleyCoffee)){

            toggleButtonGradation.setVisibility(View.INVISIBLE);
            toggleButtonMilk.setVisibility(View.INVISIBLE);

        }
    }

    public void gradation (View view) throws InterruptedException {
        ToggleButton toggleButton = (ToggleButton) view;
        ToggleButton toggleButtonMilk = (ToggleButton) findViewById(R.id.toggleButtonMilk);
        if(toggleButton.isChecked()) {
            toggleButtonMilk.setChecked(false);
            Intent intent = new Intent(this, ActivityGradation.class);
            startActivity(intent);
        }
    }

    public void milk(View view){
        ToggleButton toggleButton = (ToggleButton) view;
        ToggleButton toggleButtonGradation = (ToggleButton) findViewById(R.id.toggleButtonGradation);
        if(toggleButton.isChecked()){
            toggleButtonGradation.setChecked(false);
            setValueBrand("");
            setValueGradation(0);
        }

    }

    public static void setValueBrand(String str){
        valueBrand = str;

    }

    public static void setValueGradation(int grad){
        valueGradation = grad;

    }

    public static void setValueCoffee(String str){
        valueCoffee = str;

    }

    public void exclusiveButtonDimensions(View view) {
        CheckBox checkBox = (CheckBox) view;
        String str = (String) checkBox.getText();

        CheckBox checkBoxShort = (CheckBox) findViewById(R.id.checkBoxShort);
        CheckBox checkBoxLong  = (CheckBox) findViewById(R.id.checkBoxLarge);

        String  large  = this.getString(R.string.large);
        String  strong  = this.getString(R.string.strong);

        if (str.equals(large)){
            checkBoxShort.setChecked(false);
        }

        if (str.equals(strong)){
            checkBoxLong.setChecked(false);
        }

    }

    public void exclusiveButtonSugar(View view) {
        CheckBox checkBoxButton = (CheckBox) view;
        String str = (String) checkBoxButton.getText();

        CheckBox checkBoxSugar      = (CheckBox) findViewById(R.id.checkBoxSugar);
        CheckBox checkBoxBrownSugar = (CheckBox) findViewById(R.id.checkBoxBrownSugar);
        CheckBox checkBoxSweetener  = (CheckBox) findViewById(R.id.checkBoxSweetener);
        CheckBox checkBoxHoney      = (CheckBox) findViewById(R.id.checkBoxHoney);

        String  sugar  = this.getString(R.string.sugar);
        String  brownSugar  = this.getString(R.string.brownSugar);
        String  sweetener  = this.getString(R.string.sweetener);
        String  honey  = this.getString(R.string.honey);

        if (str.equals(sugar)){
            checkBoxBrownSugar.setChecked(false);
            checkBoxSweetener.setChecked(false);
            checkBoxHoney.setChecked(false);
        }

        if (str.equals(brownSugar)){
            checkBoxSugar.setChecked(false);
            checkBoxSweetener.setChecked(false);
            checkBoxHoney.setChecked(false);
        }

        if (str.equals(sweetener)) {
            checkBoxSugar.setChecked(false);
            checkBoxBrownSugar.setChecked(false);
            checkBoxHoney.setChecked(false);
        }

        if(str.equals(honey)){
            checkBoxSugar.setChecked(false);
            checkBoxBrownSugar.setChecked(false);
            checkBoxSweetener.setChecked(false);
        }

        if(!checkBoxBrownSugar.isChecked() &&  !checkBoxSweetener.isChecked() && !checkBoxHoney.isChecked()){
            checkBoxSugar.setChecked(true);
        }

    }

    public void sugarPlus(View view){

        ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        ProgressBar progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        ProgressBar progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);

        CheckBox checkBoxSugar      = (CheckBox) findViewById(R.id.checkBoxSugar);
        CheckBox checkBoxBrownSugar = (CheckBox) findViewById(R.id.checkBoxBrownSugar);
        CheckBox checkBoxSweetener  = (CheckBox) findViewById(R.id.checkBoxSweetener);
        CheckBox checkBoxHoney      = (CheckBox) findViewById(R.id.checkBoxHoney);

        if(progressBar1.getProgress() == 1){
            if(progressBar2.getProgress() == 1){
                if(progressBar3.getProgress() == 1){
                    if(progressBar4.getProgress() == 1){
                        progressBar5.setProgress(1);
                    }
                    else{
                        progressBar4.setProgress(1);
                    }
                }
                else{
                    progressBar3.setProgress(1);
                }
            }
            else{
                progressBar2.setProgress(1);
            }

        }
        else{
            progressBar1.setProgress(1);
            checkBoxSugar.setVisibility(View.VISIBLE);
            checkBoxBrownSugar.setVisibility(View.VISIBLE);
            checkBoxSweetener.setVisibility(View.VISIBLE);
            checkBoxHoney.setVisibility(View.VISIBLE);
        }

    }

    public void sugarLess(View view){

        ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        ProgressBar progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        ProgressBar progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);

        CheckBox checkBoxSugar      = (CheckBox) findViewById(R.id.checkBoxSugar);
        CheckBox checkBoxBrownSugar = (CheckBox) findViewById(R.id.checkBoxBrownSugar);
        CheckBox checkBoxSweetener  = (CheckBox) findViewById(R.id.checkBoxSweetener);
        CheckBox checkBoxHoney      = (CheckBox) findViewById(R.id.checkBoxHoney);

        if(progressBar5.getProgress() == 0){
            if(progressBar4.getProgress() == 0){
                if(progressBar3.getProgress() == 0){
                    if(progressBar2.getProgress() == 0){
                        progressBar1.setProgress(0);

                        checkBoxSugar.setVisibility(View.INVISIBLE);
                        checkBoxBrownSugar.setVisibility(View.INVISIBLE);
                        checkBoxSweetener.setVisibility(View.INVISIBLE);
                        checkBoxHoney.setVisibility(View.INVISIBLE);
                    }
                    else{
                        progressBar2.setProgress(0);
                    }
                }
                else{
                    progressBar3.setProgress(0);
                }
            }
            else{
                progressBar4.setProgress(0);
            }
        }
        else{
            progressBar5.setProgress(0);
        }

    }

    public void back(View view){
        finish();
    }

    public void reset(){

        CheckBox checkBoxGlass = (CheckBox) findViewById(R.id.checkBoxGlass);
        CheckBox checkBoxDecaf = (CheckBox) findViewById(R.id.checkBoxDecaf);

        ToggleButton toggleButtonGradation = (ToggleButton) findViewById(R.id.toggleButtonGradation);
        ToggleButton toggleButtonMilk = (ToggleButton) findViewById(R.id.toggleButtonMilk);

        CheckBox checkBoxShort = (CheckBox) findViewById(R.id.checkBoxShort);
        CheckBox checkBoxLong  = (CheckBox) findViewById(R.id.checkBoxLarge);

        ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        ProgressBar progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        ProgressBar progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);

        CheckBox checkBoxSugar      = (CheckBox) findViewById(R.id.checkBoxSugar);
        CheckBox checkBoxBrownSugar = (CheckBox) findViewById(R.id.checkBoxBrownSugar);
        CheckBox checkBoxSweetener  = (CheckBox) findViewById(R.id.checkBoxSweetener);
        CheckBox checkBoxHoney      = (CheckBox) findViewById(R.id.checkBoxHoney);

        checkBoxGlass.setChecked(false);
        checkBoxDecaf.setChecked(false);

        toggleButtonGradation.setChecked(false);
        toggleButtonMilk.setChecked(false);

        checkBoxLong.setChecked(false);
        checkBoxShort.setChecked(false);

        progressBar1.setProgress(0);
        progressBar2.setProgress(0);
        progressBar3.setProgress(0);
        progressBar4.setProgress(0);
        progressBar5.setProgress(0);

        checkBoxSugar.setChecked(true);
        checkBoxBrownSugar.setChecked(false);
        checkBoxSweetener.setChecked(false);
        checkBoxHoney.setChecked(false);

        checkBoxSugar.setVisibility(View.INVISIBLE);
        checkBoxBrownSugar.setVisibility(View.INVISIBLE);
        checkBoxSweetener.setVisibility(View.INVISIBLE);
        checkBoxHoney.setVisibility(View.INVISIBLE);

    }

    public void buy(View view){

        CheckBox checkBoxGlass = (CheckBox) findViewById(R.id.checkBoxGlass);
        CheckBox checkBoxDecaf = (CheckBox) findViewById(R.id.checkBoxDecaf);

        ToggleButton toggleButtonGradation = (ToggleButton) findViewById(R.id.toggleButtonGradation);
        ToggleButton toggleButtonMilk = (ToggleButton) findViewById(R.id.toggleButtonMilk);

        CheckBox checkBoxShort = (CheckBox) findViewById(R.id.checkBoxShort);
        CheckBox checkBoxLong  = (CheckBox) findViewById(R.id.checkBoxLarge);

        ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        ProgressBar progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        ProgressBar progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);

        CheckBox checkBoxBrownSugar = (CheckBox) findViewById(R.id.checkBoxBrownSugar);
        CheckBox checkBoxSweetener  = (CheckBox) findViewById(R.id.checkBoxSweetener);
        CheckBox checkBoxHoney      = (CheckBox) findViewById(R.id.checkBoxHoney);

        String  yes  = this.getString(R.string.yes);
        String  no  = this.getString(R.string.no);

        String str = "un caffe' " + valueCoffee + " ";

        if(checkBoxGlass.isChecked()){
            str = str + "in vetro ";
        }

        if(checkBoxDecaf.isChecked()){
            str = str + "decaffeinato ";
        }

        if(checkBoxLong.isChecked()){
            str = str + "lungo ";
        }

        if(checkBoxShort.isChecked()){
            str = str + "corto ";
        }

        if(toggleButtonGradation.isChecked()) {
            str = str + "corretto con " + valueBrand + " a " + valueGradation + "° e ";
        }

        if(toggleButtonMilk.isChecked()){
            str = str + "macchiato ";
        }

        if(progressBar1.getProgress() == 1){
            if(progressBar2.getProgress() == 1){
                if(progressBar3.getProgress() == 1){
                    if(progressBar4.getProgress() == 1){
                        if(progressBar5.getProgress() == 1){
                            str = str + "con due cucchiaini e mezzo di ";
                        }
                        else{
                            str = str + "con due cucchiaini di ";
                        }
                    }
                    else{
                        str = str + "con un cucchiaino e mezzo di ";
                    }
                }
                else{
                    str = str + "con un cucchiaino di ";
                }
            }
            else{
                str = str + "con mezzo cucchiaino di ";
            }

            String strSugar = "zucchero ";

            if(checkBoxBrownSugar.isChecked()){
                strSugar =  "zucchero di canna";
            }

            if(checkBoxSweetener.isChecked()){
                strSugar = "dolcificante";
            }

            if(checkBoxHoney.isChecked()){
                strSugar = "miele";
            }

            str = str + strSugar;

        }
        else{
            str = str + "senza zucchero ";
        }

        new AlertDialog.Builder(this)
                .setMessage("vuoi ordinare " + str +"?")
                .setCancelable(false)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        thanks();
                    }
                })
                .setNegativeButton(no, null)
                .show();

    }

    public void thanks(){
        String thanks = this.getString(R.string.thanks);
        String close = this.getString(R.string.close);
        new AlertDialog.Builder(this)
                .setMessage(thanks)
                .setCancelable(false)
                .setPositiveButton(close, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        reset();
                        finish();
                    }
                })
                .show();

    }


}

package com.example.shaer.tipcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void makeToast(String x){
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show();
    }
    public void calculator(double x){
        EditText t15 = (EditText) findViewById(R.id.tip15);
        EditText t20 = (EditText) findViewById(R.id.tip20);
        EditText t25 = (EditText) findViewById(R.id.tip25);
        EditText f15 = (EditText) findViewById(R.id.total15);
        EditText f20 = (EditText) findViewById(R.id.total20);
        EditText f25 = (EditText) findViewById(R.id.total25);

        double tip15 = Math.round(x*(.15));
        double tip20 = Math.round(x*(.20));
        double tip25 = Math.round(x*(.25));
        t15.setText(String.format("%.2f",tip15));
        t20.setText(String.format("%.2f",tip20));
        t25.setText(String.format("%.2f",tip25));
        f15.setText(String.format("%.2f",x+tip15));
        f20.setText(String.format("%.2f",x+tip20));
        f25.setText(String.format("%.2f",x+tip25));
    }
    public void onSubmit(View view) {
        EditText am = (EditText) findViewById(R.id.amount);
        EditText si = (EditText) findViewById(R.id.size);
        if((am.getText().toString().length()<=0)||(si.getText().toString().length()<=0)){
            makeToast("Enter A Positive Whole Number");
        }else {
            double divider =(Double.parseDouble(am.getText().toString()))/(Double.parseDouble(si.getText().toString()));
            calculator(divider);
        }
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etF;
    private EditText etC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etF = (EditText) findViewById(R.id.et_f);
        etC = (EditText) findViewById(R.id.et_c);

    }

    public void convert(View view) {
        String f = etF.getText().toString();
        if (TextUtils.isEmpty(f)) {
            Toast.makeText(this, "Please enter Fahrenheit.", Toast.LENGTH_SHORT).show();
            return;
        }
        etC.setText(getC(Double.parseDouble(f)));

    }

    private String getC(double f) {
        double result = (f - 32) * 5 / 9.f;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(result);
    }
}

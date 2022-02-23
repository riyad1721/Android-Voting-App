package com.example.demovotefinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioButton android, java, angular, python;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android = (RadioButton)findViewById(R.id.radioButton2);
        angular = (RadioButton)findViewById(R.id.radioButton5);
        java = (RadioButton)findViewById(R.id.radioButton7);
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String result = " ";
                result+= (android.isChecked())?"":(angular.isChecked())?"":(java.isChecked())?"":"";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                switch (v.getId()) {

                    case R.id.button2:
                        Intent intent = new Intent(getApplicationContext(), Fingerprint.class);
                        startActivity(intent);

                        break;

                }
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton2:
                if(checked)
                    str = "আপেল";
                    angular.setChecked(false);
                    java.setChecked(false);
                break;
            case R.id.radioButton5:
                if(checked)
                    str = "লেবু";
                    android.setChecked(false);
                    java.setChecked(false);

                break;
            case R.id.radioButton7:
                if(checked)
                    str = "কমলালেবু";
                    android.setChecked(false);
                    angular.setChecked(false);
                break;

        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

}
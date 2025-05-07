package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        RadioGroup cityGroup = findViewById(R.id.radioCity);
        Switch vipSw = findViewById(R.id.switchVip);
        RadioGroup osiguranje = findViewById(R.id.osiguranje);
        EditText nameET = findViewById(R.id.etName);
        EditText dateET = findViewById(R.id.edDate);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String date = dateET.getText().toString();

                int selectedCityId = cityGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioCity = findViewById(selectedCityId);
                String city = selectedRadioCity.getText().toString();

                boolean vip = vipSw.isChecked();
                int selectedInsId = osiguranje.getCheckedRadioButtonId();
                RadioButton selectedIns = findViewById(selectedInsId);
                String osiguranje = selectedIns.getText().toString();


                Intent result = new Intent(MainActivity.this,finishActivity.class);
                result.putExtra("name",name);
                result.putExtra("date",date);
                result.putExtra("city",city);
                result.putExtra("vip",vip);
                result.putExtra("insurance",osiguranje);
                startActivity(result);
            }
        });
    }
}
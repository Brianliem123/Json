package com.fa.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView name,age,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.txt_name);
        age = (TextView) findViewById(R.id.txt_age);
        gender = (TextView) findViewById(R.id.txt_gender);

        deserialize();

    }
    public void deserialize() {
        String json = loadJSONFromRaw();
        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject jsonDataDiri = jsonObject.getJSONObject("person");
            String nama = jsonDataDiri.getString("name");
            int umur = jsonDataDiri.getInt("age");
            String JK = jsonDataDiri.getString("gender");

            Data data = new Data(nama, JK, umur);

            name.setText(data.getName());
            gender.setText(data.getGender());
            age.setText(String.valueOf(data.getAge()));
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromRaw(){
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.datadiri);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}


package com.maxsop.readandwritelocalfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // json object
        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAssets());
            JSONArray jsonArray = jsonObject.getJSONArray("users");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userData = jsonArray.getJSONObject(i);

                name.add(userData.getString("name"));
                email.add(userData.getString("email"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // set adapter
        HelperAdapter helperAdapter = new HelperAdapter(name, email, MainActivity.this);
        recyclerView.setAdapter(helperAdapter);
    }

    private String JsonDataFromAssets() {
        String json = null;

        try {
            InputStream inputStream = getAssets().open("user.json");

            int sizeofFile = inputStream.available();
            byte[] bufferData = new byte[sizeofFile];

            inputStream.read(bufferData);
            inputStream.close();

            json = new String(bufferData, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}
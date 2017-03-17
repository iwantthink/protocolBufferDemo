package com.hypers.www.protocolbufferdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button mBtnBuild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("", "");
        try {
            JSONObject options = new JSONObject();
            JSONObject info = new JSONObject();
            info.put("v_id", 123456789);
            options.put("info", info);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        setContentView(R.layout.activity_main);
        mBtnBuild = (Button) findViewById(R.id.btn_build);
        mBtnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildMrb();
            }
        });
    }

    private void buildMrb() {
        Addressbook.SearchRequest request =
                Addressbook.SearchRequest.newBuilder().setQuery("apple")
                        .setPageNumber(2)
                        .setResultPerPage(3).build();
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "address");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("MainActivity", file.getAbsolutePath());
        try {
            FileOutputStream os = new FileOutputStream(file);
            request.writeTo(os);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

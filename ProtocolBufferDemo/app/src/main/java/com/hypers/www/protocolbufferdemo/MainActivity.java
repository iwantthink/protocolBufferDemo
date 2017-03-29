package com.hypers.www.protocolbufferdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hypers.www.protocolbufferdemo.nano.AddressBookProtos;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mBtnBuild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnBuild = (Button) findViewById(R.id.btn_build);
        mBtnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildPb();
                try {
                    buildJson();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    enum PhoneType {
        Mobile,
        HOME,
        WORK
    }

    private void buildJson() throws Exception {
        JSONArray book = new JSONArray();
        for (int i = 0; i < 100; i++) {
            JSONObject person = new JSONObject();
            person.put("id", i);
            person.put("name", "mrb" + i);
            person.put("email", "mrb" + i + "@gmail.com");
            JSONArray phones = new JSONArray();
            JSONObject phone = new JSONObject();
            phone.put("number", "110_" + i);
            phone.put("type", PhoneType.Mobile);
            phones.put(phone);
            person.put("phones", phones);
            book.put(person);
        }

        Log.d("MainActivity", "json book = " + book.toString());

        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "addressjson");
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            byte[] b = book.toString().getBytes();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(b);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            Log.d("MainActivity", "fis.available():" + fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
    }

    private void buildPb() {

        AddressBookProtos.AddressBook book =
                new AddressBookProtos.AddressBook();
        ArrayList<AddressBookProtos.Person> personsList =
                new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            AddressBookProtos.Person p = new AddressBookProtos.Person();
            p.name = "mrb" + i;
            p.email = "mrb" + i + "@gmail.com";
            p.id = i;
            AddressBookProtos.Person.PhoneNumber number = new AddressBookProtos.Person.PhoneNumber();
            number.number = "110_" + i;
            number.type = AddressBookProtos.Person.MOBILE;
            p.phones = new AddressBookProtos.Person.PhoneNumber[]{number};
            personsList.add(p);
        }
        AddressBookProtos.Person[] personsArray =
                personsList.toArray(new AddressBookProtos.Person[personsList.size()]);
        book.people = personsArray;

        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "address");
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("MainActivity", file.getAbsolutePath());
        FileOutputStream fos = null;
        try {
            byte[] arry = AddressBookProtos.AddressBook.toByteArray(book);
            Log.d("MainActivity", "arry.length:" + arry.length);
            fos = new FileOutputStream(file);
            fos.write(arry);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            Log.d("MainActivity", "fis.available():" + fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

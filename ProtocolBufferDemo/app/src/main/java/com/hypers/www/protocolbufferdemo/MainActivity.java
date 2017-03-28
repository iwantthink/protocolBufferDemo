package com.hypers.www.protocolbufferdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hypers.www.protocolbufferdemo.nano.AddressBookProtos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
                buildMrb();
            }
        });
    }

    private void buildMrb() {

        AddressBookProtos.AddressBook book =
                new AddressBookProtos.AddressBook();

        AddressBookProtos.Person p1 = new AddressBookProtos.Person();
        p1.name = "mrb";
        p1.email = "mrb@gmail.com";
        p1.id = 1;

        AddressBookProtos.Person.PhoneNumber number = new AddressBookProtos.Person.PhoneNumber();
        number.number = "110";
        number.type = AddressBookProtos.Person.MOBILE;
        p1.phones = new AddressBookProtos.Person.PhoneNumber[]{number};
        book.people = new AddressBookProtos.Person[]{p1};

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
        try {
            byte[] arry = AddressBookProtos.AddressBook.toByteArray(book);
            Log.d("MainActivity", "arry.length:" + arry.length);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(arry);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

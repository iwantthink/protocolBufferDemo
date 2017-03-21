package com.hypers.www.protocolbufferdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
//        Addressbook.SearchRequest request =
//                Addressbook.SearchRequest.newBuilder().setQuery("apple")
//                        .setPageNumber(2)
//                        .setResultPerPage(3).build();

        AddressBookProtos.AddressBook book =
                AddressBookProtos.AddressBook.newBuilder()
                        .addPeople(AddressBookProtos.Person.newBuilder()
                                .setName("mrb")
                                .setEmail("mrb@gmail.com")
                                .setId(0)
                                .addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder()
                                        .setNumber("110")
                                        .setType(AddressBookProtos.Person.PhoneType.HOME)
                                        .build())
                                .build()
                        )
                        .addPeople(AddressBookProtos.Person.newBuilder()
                                .setName("cyq")
                                .setEmail("cyq@gmail.com")
                                .setId(1)
                                .addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder()
                                        .setNumber("112")
                                        .setType(AddressBookProtos.Person.PhoneType.HOME)
                                        .build())
                                .build()
                        )
                        .build();

        List<AddressBookProtos.Person> list = book.getPeopleList();
        for (AddressBookProtos.Person person : list) {
            Log.d("MainActivity", "person.getId():" + person.getId());
            Log.d("MainActivity", "person.getName():" + person.getName());
        }


//        book.toBuilder().addPeople(AddressBookProtos.Person.newBuilder()
//                .setName("cyq")
//                .setEmail("cyq@gmail.com")
//                .setId(1)
//                .addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder()
//                        .setNumber("120")
//                        .setType(AddressBookProtos.Person.PhoneType.HOME)
//                        .build())
//                .build())
//                .build();

//        AddressBookProtos.AddressBook.parseFrom(byte);


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
            byte[] arry = book.toByteArray();
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

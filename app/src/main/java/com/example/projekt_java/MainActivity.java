package com.example.projekt_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    EditText imePrezime;
    EditText lozinka ;
    EditText broj ;
    EditText grad ;
    EditText adresa ;
    EditText pbr ;
    TextView pogled;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         imePrezime = (EditText)findViewById(R.id.editText9);
         lozinka = (EditText)findViewById(R.id.editText3);
         broj = (EditText)findViewById(R.id.editText4);
         grad = (EditText)findViewById(R.id.editText5);
         adresa = (EditText)findViewById(R.id.editText10);
         pbr = (EditText)findViewById(R.id.editText11);
         pogled = findViewById(R.id.textView);
    }
    public void save(View v){
        String imePrezime1 = imePrezime.getText().toString();
        String lozinka1 = lozinka.getText().toString();
        String broj1 = broj.getText().toString();
        String grad1 = grad.getText().toString();
        String adresa1 = adresa.getText().toString();
        String pbr1 = pbr.getText().toString();
        String text1 = concatenate(imePrezime1,lozinka1,broj1,grad1,adresa1,pbr1);

        FileOutputStream fos = null;
       try {
           fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
           fos.write(text1.getBytes());

           imePrezime.getText().clear();
           lozinka.getText().clear();
           broj.getText().clear();
           grad.getText().clear();
           adresa.getText().clear();
           pbr.getText().clear();
           Toast.makeText(this, "Saved to" + getFilesDir() +"/" +FILE_NAME, Toast.LENGTH_LONG).show();

       } catch(FileNotFoundException e){
           e.printStackTrace();
       }catch(IOException e){
           e.printStackTrace();
       } finally {
           if(fos!=null){
               try {
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
    }

    public static String concatenate(String... s)
    {
        StringBuilder sb = new StringBuilder();
        String nl = "\n";
        for (int i = 0; i < s.length; i++){
            sb = sb.append(s[i]);
            sb = sb.append(nl);
        }
        return sb.toString();
    }

    public void nextActivity(View v){
        Intent i = new Intent(this, NextActivity.class);
        startActivity(i);
    }
}

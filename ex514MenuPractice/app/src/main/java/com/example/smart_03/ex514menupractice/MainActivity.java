package com.example.smart_03.ex514menupractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editAngle;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("귀여운 동물");

        editAngle = (EditText) findViewById(R.id.editAngle);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView1.setRotation( Float.parseFloat(editAngle.getText().toString()));
                return true;

            case R.id.item1:
                imageView1.setImageResource(R.drawable.cat);
                return true;

            case R.id.item2:
                imageView1.setImageResource(R.drawable.dog);
                return true;

            case R.id.item3:
                imageView1.setImageResource(R.drawable.horse);
                return true;


        }
        return false;

    }




}


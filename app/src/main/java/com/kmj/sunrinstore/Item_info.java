package com.kmj.sunrinstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Item_info extends AppCompatActivity {
    private int img;

    ImageView imgv;
    TextView name;
    TextView price;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        Intent intent = getIntent();

        ImageView imgv = findViewById(R.id.img_prof);
        name = findViewById(R.id.info_name);
        price = findViewById(R.id.info_price);
        btn=findViewById(R.id.info_btn);
        img = intent.getIntExtra("product_img",R.drawable.ic_launcher_foreground);
        Log.e("imgid",String.valueOf(img));
        imgv.setImageResource(img);
        name.setText(intent.getStringExtra("product"));
        price.setText(intent.getStringExtra("price"));



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}

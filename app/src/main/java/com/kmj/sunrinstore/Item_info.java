package com.kmj.sunrinstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class Item_info extends AppCompatActivity {
    private int img;
    String myname;
    ImageView imgv;
    TextView name;
    TextView price;
    EditText et;
    Button btn;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    ChatAdapter chatAdapter;
    DatabaseReference myRef;
    ArrayList<ChatModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        mRecyclerView = (RecyclerView) findViewById(R.id.info_recycler);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        et = findViewById(R.id.info_input);
        myname = pref.getString("name", "");
        Intent intent = getIntent();
        data = new ArrayList<>();
        ImageView imgv = findViewById(R.id.img_prof);
        name = findViewById(R.id.info_name);
        price = findViewById(R.id.info_price);
        btn = findViewById(R.id.info_btn);
        img = intent.getIntExtra("product_img", R.drawable.ic_launcher_foreground);
        Log.e("imgid", String.valueOf(img));
        imgv.setImageResource(img);
        name.setText(intent.getStringExtra("product"));
        price.setText(intent.getStringExtra("price"));

        myRef = FirebaseDatabase.getInstance().getReference();

        chatAdapter=new ChatAdapter(data);
        mRecyclerView.setAdapter(chatAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = et.getText().toString();
                if (comment.equals("")) {
                    Toast.makeText(Item_info.this, "글자를 입력하고 눌러주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    et.setText("");
                    myRef.child(String.valueOf(img)).push().setValue(new ChatModel(comment,myname));
                }

            }
        });

        myRef.child(String.valueOf(img)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ChatModel chatModel = dataSnapshot.getValue(ChatModel.class);
                data.add(0,new ChatModel(chatModel.getContent(), chatModel.getName()));

                chatAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

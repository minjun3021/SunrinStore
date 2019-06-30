package com.kmj.sunrinstore;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView gridView;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    FloatingActionButton changeBtn;
    int mode=0;
    private ArrayList<List_item> data = null;
    private ArrayList<GridItem> dataG = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.app_toolbar);

        changeBtn=findViewById(R.id.changeBtn);
        setSupportActionBar(toolbar);
        toolbar.setTitle("선린매점");
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.main_recycler);
        mLinearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        gridView = findViewById(R.id.main_gridrecycler);
        mGridLayoutManager=new GridLayoutManager(this,3);
        gridView.setLayoutManager(mGridLayoutManager);

        list_1st();
        toList();
        CustomListAdapter customListAdapter=new CustomListAdapter(this,data,R.layout.list_item);
        recyclerView.setAdapter(customListAdapter);

        toGrid();
        CustomGridAdapter customGridAdapter=new CustomGridAdapter(this,data,R.layout.grid_item);
        gridView.setAdapter(customGridAdapter);

        changeBtn.setOnClickListener(changeBtnListener);

        recyclerView.setNestedScrollingEnabled(false);
        gridView.setNestedScrollingEnabled(false);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(R.layout.list_item,10);





    }
    private Button.OnClickListener changeBtnListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mode==0){
                mode=1;
                changeBtn.setImageResource(R.drawable.ic_grid);
                recyclerView.setVisibility(View.INVISIBLE);
                gridView.setVisibility(View.VISIBLE);

            }
            else{
                mode=0;
                changeBtn.setImageResource(R.drawable.ic_list);
                recyclerView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.INVISIBLE);
            }
        }
    };
    public void list_1st() {
        //리스트뷰가 먼저 보이기
        recyclerView.setVisibility(View.VISIBLE);
        gridView.setVisibility(View.INVISIBLE);
    }

    public void toList() {

        // listview
        data = new ArrayList<>();
        List_item item1 = new List_item(R.drawable.potatochip, "감자알칩", "500");
        List_item item2 = new List_item(R.drawable.picnic, "피크닉", "500");
        List_item item3 = new List_item(R.drawable.lemoncha, "레몬녹차", "500");
        List_item item4 = new List_item(R.drawable.peachcha, "복숭아녹차", "500");
        List_item item5 = new List_item(R.drawable.macstar, "맛스타", "500");
        List_item item6 = new List_item(R.drawable.tankboy, "탱크보이", "500");
        List_item item7 = new List_item(R.drawable.bbushubbushu, "뿌셔뿌셔", "1000");
        List_item item8 = new List_item(R.drawable.yammy, "마시따", "1000");
        List_item item9 = new List_item(R.drawable.bbabbico, "빠삐코", "1000");
        List_item item10 = new List_item(R.drawable.pocari_sweat, "포카리스웨트", "1000");
        List_item item11 = new List_item(R.drawable.saekomdalkom, "새콤달콤", "1000");
        List_item item12 = new List_item(R.drawable.isheou, "아이셔", "1000");

        data.add(item1);
        data.add(item2);
        data.add(item3);
        data.add(item4);
        data.add(item5);
        data.add(item6);
        data.add(item7);
        data.add(item8);
        data.add(item9);
        data.add(item10);
        data.add(item11);
        data.add(item12);






    }

    public void toGrid() {
        //gridview
        dataG = new ArrayList<>();


        GridItem item1 = new GridItem(R.drawable.potatochip, "감자알칩", "500");
        GridItem item2 = new GridItem(R.drawable.picnic, "피크닉", "500");
        GridItem item3 = new GridItem(R.drawable.lemoncha, "레몬녹차", "500");
        GridItem item4 = new GridItem(R.drawable.peachcha, "복숭아녹차", "500");
        GridItem item5 = new GridItem(R.drawable.macstar, "맛스타", "500");
        GridItem item6 = new GridItem(R.drawable.tankboy, "탱크보이", "500");
        GridItem item7 = new GridItem(R.drawable.bbushubbushu, "뿌셔뿌셔", "1000");
        GridItem item8 = new GridItem(R.drawable.yammy, "마시따", "1000");
        GridItem item9 = new GridItem(R.drawable.bbabbico, "빠삐코", "1000");
        GridItem item10 = new GridItem(R.drawable.pocari_sweat, "포카리스웨트", "1000");
        GridItem item11 = new GridItem(R.drawable.saekomdalkom, "새콤달콤", "1000");
        GridItem item12 = new GridItem(R.drawable.isheou, "아이셔", "1000");

        dataG.add(item1);
        dataG.add(item2);
        dataG.add(item3);
        dataG.add(item4);
        dataG.add(item5);
        dataG.add(item6);
        dataG.add(item7);
        dataG.add(item8);
        dataG.add(item9);
        dataG.add(item10);
        dataG.add(item11);
        dataG.add(item12);



    }

}

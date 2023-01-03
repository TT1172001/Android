package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items=new ArrayList<>();
        items.add(new ItemModel(R.drawable.textview_background,"Nghia","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background2,"Tomy","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background3,"Henry","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background4,"Cristal","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background,"Nghia","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background2,"Tomy","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background3,"Henry","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background4,"Cristal","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background,"Nghia","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background2,"Tomy","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background3,"Henry","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background4,"Cristal","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background,"Nghia","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background2,"Tomy","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background3,"Henry","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background4,"Cristal","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background,"Nghia","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background2,"Tomy","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background3,"Henry","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));
        items.add(new ItemModel(R.drawable.textview_background4,"Cristal","$19 Only (First 10 sport) - Bestselling...Are you looking to Learn Web Designin","12:34 PM"));

        ItemAdapter adapter=new ItemAdapter(items);
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter) ;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }
}
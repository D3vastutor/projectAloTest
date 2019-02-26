package com.laptop.machtal.alotest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.laptop.machtal.alotest.Method.Gambar;
import com.laptop.machtal.alotest.adapter.GambarAdapter;

import java.util.ArrayList;
import java.util.List;

public class GambarActivity extends AppCompatActivity {

    List<Gambar> listGambar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvGambar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listGambar = new ArrayList<>();

        listGambar.add(
                new Gambar(
                        1,
                    R.drawable.rasberry
                ));
        listGambar.add(
                new Gambar(
                        2,
                    R.drawable.nanas
                ));
        listGambar.add(
                new Gambar(
                        3,
                        R.drawable.kumquat
                ));

        GambarAdapter adapter = new GambarAdapter(this, listGambar);
        recyclerView.setAdapter(adapter);
    }
}

package com.laptop.machtal.alotest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.machtal.alotest.Method.Gambar;
import com.laptop.machtal.alotest.R;
import com.laptop.machtal.alotest.adapter.GambarAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab1 extends Fragment {

    RecyclerView recyclerView;
    List<Gambar> listGambar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab1, container,false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvGambar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listGambar = new ArrayList<>();
        listGambar.add(
                new Gambar(
                        1,
                        R.drawable.rasberry
                )
        );
        listGambar.add(
                new Gambar(
                        2,
                        R.drawable.nanas
                )
        );
        listGambar.add(
                new Gambar(
                        3,
                        R.drawable.kumquat
                )
        );

        GambarAdapter adapter = new GambarAdapter(getActivity(), listGambar);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}

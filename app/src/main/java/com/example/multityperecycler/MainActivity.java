package com.example.multityperecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.multityperecycler.Adapter.AdapterCustom;
import com.example.multityperecycler.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {
        context = this;
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(context, 1));

        List<Member> members = ArrayMember();
        refreshAdapter(members);
    }


    void refreshAdapter(List<Member> members){
        AdapterCustom adapterCustom =new AdapterCustom(context,members);
        recyclerview.setAdapter(adapterCustom);

    }


    List<Member> ArrayMember() {
        List<Member> members = new ArrayList<>();

        for(int i=0; i<20; i++) {
            if (i >= 0 && i%2==0) {
                members.add(new Member("Otabek " + i, "Boboyev " + i, false));
            }else{members.add(new Member("Otabek " + i, "Boboyev " + i, true));}
        }


        return members;
    }
}
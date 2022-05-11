package com.example.multityperecycler.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multityperecycler.R;
import com.example.multityperecycler.model.Member;

import java.util.List;

public class AdapterCustom extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Member> members;
    private static final int type_available_not = 1;
    private static final int type_available_yes = 0;

    public AdapterCustom(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);

        if (member.isAvailable()) {
            return type_available_yes;
        }
        return type_available_not;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == type_available_yes) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_yes, parent, false);
            return new CustomholderYES(view);
        }

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_not,parent,false);
        return new CustomholderNot(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);
        if (holder instanceof CustomholderYES) {
            TextView ism = ((CustomholderYES) holder).ism;
            TextView familiya = ((CustomholderYES) holder).familiya;

            ism.setText(member.getIsm());
            familiya.setText(member.getFamiliya());
        }


        if (holder instanceof CustomholderNot) {
            TextView ism = ((CustomholderNot) holder).ism;
            TextView familiya = ((CustomholderNot) holder).familiya;

            ism.setText(member.getIsm());
            familiya.setText(member.getFamiliya());
        }
    }

}

class CustomholderYES extends RecyclerView.ViewHolder {
    View view;
    TextView ism, familiya;

    CustomholderYES(View v) {
        super(v);
        view = v;

        ism = view.findViewById(R.id.ism);
        familiya = view.findViewById(R.id.familiya);
    }
}


class CustomholderNot extends RecyclerView.ViewHolder {
    View view;
    TextView ism, familiya;

    CustomholderNot(View v) {
        super(v);
        view = v;

        ism = view.findViewById(R.id.ism);
        familiya = view.findViewById(R.id.familiya);
    }
}
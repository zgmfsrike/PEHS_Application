package com.yangzxcc.macintoshhd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.fragments.PhysicalFragment;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {

    private List<HealthRecord> healthRecordList;



    public HealthAdapter(List<HealthRecord> healthRecordList) {
        this.healthRecordList = healthRecordList;
    }

    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new HealthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, int position) {

        holder.title.setText(healthRecordList.get(position).getTitle());
//        holder.text.setText(healthRecordList.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return healthRecordList.size();
    }

    class HealthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title,text;

        public HealthViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.tvTitle);
//            text = itemView.findViewById(R.id.tvText);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();

            for(int i = 0; i<healthRecordList.size(); i++){
//                Bundle bundle = new Bundle();
//                bundle.putString("edttext", "From Activity");
//
//                PhysicalFragment fragobj = new PhysicalFragment();
//                fragobj.setArguments(bundle);
                v.getContext().startActivity(new Intent(v.getContext(),Record.class));
            }

        }
    }
}


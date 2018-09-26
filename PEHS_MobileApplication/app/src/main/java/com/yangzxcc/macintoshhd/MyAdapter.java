package com.yangzxcc.macintoshhd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public MyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }
    private List<HealthRecord> healthRecordListList;
    private LayoutInflater inflater;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HealthRecord healthRecord = healthRecordListList.get(position);
        holder.setData(healthRecord,position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private int position;
        private HealthRecord healthRecord;
        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView)itemView.findViewById(R.id.tvTitle);
        }

        public void setData(HealthRecord current, int position) {
            this.title.setText(healthRecord.getTitle());
            this.position = position;
        }
    }
}


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

    private List<HealthRecord> healthRecordList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<HealthRecord> healthRecordList) {
        inflater = LayoutInflater.from(context);
        this.healthRecordList = healthRecordList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HealthRecord current = healthRecordList.get(position);
        holder.setData(current,position);
    }

    @Override
    public int getItemCount() {
        return healthRecordList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView title;
        private int position;
        private HealthRecord healthRecord;
        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView)itemView.findViewById(R.id.tvTitle);
            id = (TextView)itemView.findViewById(R.id.user_id);
        }

        public void setData(HealthRecord healthRecord, int position) {
            this.id.setText(healthRecord.getId());
            this.title.setText(healthRecord.getTitle());
            this.position = position;
            this.healthRecord = healthRecord;
        }
    }
}


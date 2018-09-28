package com.yangzxcc.macintoshhd;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {

    private Context mCtx;
    private List<HealthRecord> healthRecordList;


    public HealthAdapter(List<HealthRecord> healthRecordList, Context mCtx) {
        this.healthRecordList = healthRecordList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_item,null);
        HealthViewHolder holder = new HealthViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, int position) {
        HealthRecord healthRecord = healthRecordList.get(position);
        holder.title.setText(healthRecord.getTitle());

    }

    @Override
    public int getItemCount() {
        return healthRecordList.size();
    }

    class HealthViewHolder extends RecyclerView.ViewHolder{

        TextView id,title;

        public HealthViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), Record.class));
                }
            });
            title = itemView.findViewById(R.id.tvTitle);
//            id = itemView.findViewById(R.id.user_id);
        }
    }
}


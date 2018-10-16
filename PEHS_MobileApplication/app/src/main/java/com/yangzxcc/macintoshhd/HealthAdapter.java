package com.yangzxcc.macintoshhd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.Serializable;
import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {

//    private List<HealthRecordTest> healthRecordList;
    private List<HealthRecord> healthRecords;

    public HealthAdapter(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }
    //    public HealthAdapter(List<HealthRecordTest> healthRecordList) {
//        this.healthRecordList = healthRecordList;
//    }

    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new HealthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, final int position) {

//        HealthInformation health = healthInformations.get(0);
//        healthRecords = health.getHealthRecords();
//                HealthRecord record = healthRecords.get(0);
//                physicalInformations = record.getPhysicalInformation();
//                chemistryInformations = record.getChemistryInformation();
//                bloodInformations = record.getBloodInformation();
//                urineInformations = record.getUrineInformation();
        final HealthRecord current = healthRecords.get(position);
        holder.title.setText(current.getDate());
//        current.getPhysicalInformation();

//        holder.title.setText(current);// Not sure
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Record.class);
                intent.putExtra("physical", (Serializable) current.getPhysicalInformation());
                intent.putExtra("chem", (Serializable) current.getChemistryInformation());
                intent.putExtra("blood", (Serializable) current.getBloodInformation());
                intent.putExtra("urine", (Serializable) current.getUrineInformation());
                v.getContext().startActivity(intent);
            }
        });

//        final HealthRecordTest current = healthRecordList.get(position);
//        holder.title.setText(current.getTitle());
//        holder.text.setText(current.getText());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(),Record.class);
//                intent.putExtra("title",current.getTitle());
//                intent.putExtra("text",current.getText());
//                v.getContext().startActivity(intent);
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return healthRecords.size();
    }

    public static class HealthViewHolder extends RecyclerView.ViewHolder{

        private TextView title, text;

        public HealthViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            text = (TextView)itemView.findViewById(R.id.tvText);
        }
    }
}


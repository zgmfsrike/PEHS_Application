package com.yangzxcc.macintoshhd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.activities.Record;
import com.yangzxcc.macintoshhd.infos.HealthInformation;
import com.yangzxcc.macintoshhd.infos.HealthRecordInformation;
import com.yangzxcc.macintoshhd.models.HealthRecord;
import com.yangzxcc.macintoshhd.pehs.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {

//    private List<HealthRecord> healthRecordList;
    private List<HealthRecordInformation> healthRecordInformations;

    public HealthAdapter(List<HealthRecordInformation> healthRecordInformations) {
        this.healthRecordInformations = healthRecordInformations;
    }
    //    public HealthAdapter(List<HealthRecord> healthRecordList) {
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

        final HealthRecordInformation current = healthRecordInformations.get(position);
        holder.title.setText((CharSequence) healthRecordInformations); // Not sure
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

//        final HealthRecord current = healthRecordList.get(position);
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
        return healthRecordInformations.size();
    }

    public static class HealthViewHolder extends RecyclerView.ViewHolder {

        private TextView title, text;

        public HealthViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            text = (TextView)itemView.findViewById(R.id.tvText);
        }
    }
}


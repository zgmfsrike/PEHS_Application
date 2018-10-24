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
import com.yangzxcc.macintoshhd.pehs.R;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {


    private List<HealthInformation> healthInformation;

    public HealthAdapter(List<HealthInformation> healthInformation) {
        this.healthInformation = healthInformation;
    }


    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new HealthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, final int position) {

        final HealthInformation current = healthInformation.get(position);
        holder.title.setText(current.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Record.class);
                intent.putExtra("weight",current.getWeight());
                intent.putExtra("height",current.getHeight());
                intent.putExtra("wrist",current.getWrist());
                intent.putExtra("bmi",current.getbMI());
                intent.putExtra("systolic",current.getSystolic());
                intent.putExtra("diastolic",current.getDiastolic());
                intent.putExtra("pulse",current.getPulse());
//                -----
                intent.putExtra("bloodWbc",current.getBloodWBC());
                intent.putExtra("bloodRbc",current.getBloodRBC());
                intent.putExtra("hgb",current.gethGB());
                intent.putExtra("hct",current.gethCT());
                intent.putExtra("mcv",current.getmCV());
                intent.putExtra("mch",current.getmCH());
                intent.putExtra("mchc",current.getmCHC());
                intent.putExtra("plt",current.getpLTCount());
                intent.putExtra("neu",current.getNeutrophil());
                intent.putExtra("lym",current.getLymphocyte());
                intent.putExtra("mono",current.getMonocyte());
                intent.putExtra("eos",current.getEosinophil());
                intent.putExtra("bas",current.getBasophil());
//                -----
                intent.putExtra("color",current.getColor());
                intent.putExtra("app",current.getAppearance());
                intent.putExtra("sg",current.getSpecificGravity());
                intent.putExtra("ph",current.getpH());
                intent.putExtra("albumin",current.getAlbumin());
                intent.putExtra("sugar",current.getSugar());
                intent.putExtra("urineRbc",current.getUrineRBC());
                intent.putExtra("urineWbc",current.getUrineWBC());
                intent.putExtra("epi",current.getEpithelialCell());
//                -----
                intent.putExtra("glucose",current.getGlucose());
                intent.putExtra("bun",current.getbUN());
                intent.putExtra("creatine",current.getCreatine());
                intent.putExtra("uric",current.getUricAcid());
                intent.putExtra("chol",current.getCholesterol());
                intent.putExtra("tri",current.getTriglyceride());
                intent.putExtra("hdl",current.gethDLC());
                intent.putExtra("ldl",current.getCalculatedLDL());
                intent.putExtra("ast",current.getaSTSGOT());
                intent.putExtra("alt",current.getaLTSGPT());
                intent.putExtra("alp",current.getaLP());
                v.getContext().startActivity(intent);
            }
        });

//        --------------------------------------------------------------------------------
//        final HealthRecord current = healthRecords.get(position);
//        holder.title.setText(current.getDate());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(),Record.class);
//                intent.putExtra("physical", (Serializable) current.getPhysicalInformation());
//                intent.putExtra("chem", (Serializable) current.getChemistryInformation());
//                intent.putExtra("blood", (Serializable) current.getBloodInformation());
//                intent.putExtra("urine", (Serializable) current.getUrineInformation());
//                v.getContext().startActivity(intent);
//            }
//        });
//        --------------------------------------------------------------------------------
//
// HealthInformation health = healthInformations.get(0);
//        healthRecords = health.getHealthRecords();
//                HealthRecord record = healthRecords.get(0);
//                physicalInformations = record.getPhysicalInformation();
//                chemistryInformations = record.getChemistryInformation();
//                bloodInformations = record.getBloodInformation();
//                urineInformations = record.getUrineInformation();

// holder.title.setText(new Gson().toJson(current.getHealthRecords()));
//        current.getPhysicalInformation();

//        holder.title.setText(current);// Not sure
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(),Record.class);
//                intent.putExtra("record", (Serializable) current.getHealthRecords());
//                view.getContext().startActivity(intent);
//            }
//        });

//

//                ------------------------------------------------------------------------------------------------
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
//                        ------------------------------------------------------------------------------------------------
    }
    @Override
    public int getItemCount() {
        return healthInformation.size();
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


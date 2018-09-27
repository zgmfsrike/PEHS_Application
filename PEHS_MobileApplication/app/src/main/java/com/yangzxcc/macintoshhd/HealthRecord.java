package com.yangzxcc.macintoshhd;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HealthRecord {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<HealthRecord> getHealthList() {

        List<HealthRecord> RecordList = new ArrayList<>();
        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setTitle("Title");
        RecordList.add(healthRecord);

        return RecordList;
    }
}


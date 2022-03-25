package com.example.oldagemanagmentsystem;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class MedicinesLogs extends AppCompatActivity {

    BarChart chart;
    BarDataSet barDataSet1, barDataSet2;

    ArrayList barEntries;

    String[] days = new String[]{"MSDE", "NSTI", "DMCE"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicines_logs);

        chart = findViewById(R.id.statBar);

        barDataSet1 = new BarDataSet(getBarEntriesOne(), "Dosages taken");
        barDataSet1.setColor(getApplicationContext().getResources().getColor(R.color.purple_200));
        barDataSet2 = new BarDataSet(getBarEntriesTwo(), "");
        barDataSet2.setColor(Color.BLUE);

        BarData data = new BarData(barDataSet1, barDataSet2);

        chart.setData(data);

        chart.getDescription().setEnabled(false);

        XAxis xAxis = chart.getXAxis();

        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        chart.setDragEnabled(true);
        chart.setVisibleXRangeMaximum(3);

        float barSpace = 0.1f;

        float groupSpace = 0.5f;
        data.setBarWidth(0.15f);

        chart.getXAxis().setAxisMinimum(0);

        chart.animate();
        chart.groupBars(0, groupSpace, barSpace);
        chart.invalidate();
    }

    // array list for first set
    private ArrayList<BarEntry> getBarEntriesOne() {

        // creating a new array list
        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1f, 4));
        barEntries.add(new BarEntry(2f, 6));
        barEntries.add(new BarEntry(3f, 8));
        barEntries.add(new BarEntry(4f, 2));
        barEntries.add(new BarEntry(5f, 4));
        barEntries.add(new BarEntry(6f, 1));
        return barEntries;
    }

    private ArrayList<BarEntry> getBarEntriesTwo() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 8));
        barEntries.add(new BarEntry(2f, 12));
        barEntries.add(new BarEntry(3f, 4));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(5f, 7));
        barEntries.add(new BarEntry(6f, 3));
        return barEntries;
    }
}

package com.example.oldagemanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MedicineActivity extends AppCompatActivity {
    MaterialButton todo;

    CardView tablets_card, liquids_card, ointments_card, powders_card, logreport_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_dashboard);

        todo=(MaterialButton)findViewById(R.id.todoB);

        tablets_card = findViewById(R.id.tablets_card);
        liquids_card = findViewById(R.id.liquids_card);
        ointments_card = findViewById(R.id.ointments_card);
        powders_card = findViewById(R.id.powders_card);
        logreport_card = findViewById(R.id.logreport_card);

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this,ToDoTask.class));
                //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        tablets_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this,MedicinesTablets.class)); }
        });

        liquids_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this, MedicinesLiquids.class));
            }
        });

        ointments_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this, MedicinesLiquids.class));
            }
        });

        powders_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this, MedicinesLiquids.class));
            }
        });

        logreport_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this, MedicinesLiquids.class));
            }
        });
    }
}
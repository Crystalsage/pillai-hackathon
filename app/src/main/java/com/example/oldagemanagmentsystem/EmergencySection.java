package com.example.oldagemanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EmergencySection extends AppCompatActivity {
    TextView call_ambulance, call_electrician, call_hearse;
    CardView firecard, policecard, hospitalcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_section);

        Intent intent = new Intent(Intent.ACTION_DIAL);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        firecard = findViewById(R.id.firecard);
        firecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("tel:" + "1234xx"));
                getApplicationContext().startActivity(intent);
            }
        });

        policecard = findViewById(R.id.policecard);
        policecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("tel:" + "1234xx"));
                getApplicationContext().startActivity(intent);
            }
        });

        hospitalcard = findViewById(R.id.hospitalcard);
        hospitalcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("tel:" + "1234xx"));
                getApplicationContext().startActivity(intent);
            }
        });

        call_ambulance = findViewById(R.id.quickaction_call_ambulance);
        call_ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("tel:" + "1234xx"));
                getApplicationContext().startActivity(intent);
            }
        });

        call_electrician = findViewById(R.id.quickaction_call_hearse_van);
        call_electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("tel:" + "1234xx"));
                getApplicationContext().startActivity(intent);
            }
        });

        call_hearse = findViewById(R.id.quickaction_call_electrician);
        call_hearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("tel:" + "1234xx"));
                getApplicationContext().startActivity(intent);
            }
        });
    }
}

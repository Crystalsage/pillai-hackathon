package com.example.oldagemanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MedicineActivity extends AppCompatActivity {
    MaterialButton todo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        todo=(MaterialButton)findViewById(R.id.todoB);

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this,ToDoTask.class));
                //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
    }
}
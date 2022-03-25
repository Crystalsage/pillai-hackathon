package com.example.oldagemanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainDasboard extends AppCompatActivity {

    CardView cd1,cd2,cd3,cd4,cd5;
    Button log_out;
    PopupWindow popupWindow;
    Button showPopupBtn, closePopupBtn;
 //   LinearLayout linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dasboard);

        cd1=(CardView)findViewById(R.id.user_record);

        cd2=(CardView)findViewById(R.id.notices);

        cd3=(CardView)findViewById(R.id.logoutadmin);

        cd4=(CardView)findViewById(R.id.bookings);

        cd5=(CardView)findViewById(R.id.food_mod);

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Food_Activity.class));
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Donation_screen.class));
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EmergencySection.class));
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainDasboard.this,MedicineActivity.class));
            }
        });

        log_out=(Button)findViewById(R.id.log_out_admin);


        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Records_Activity_Main.class));
            }
        });


        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) MainDasboard.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.logout_confirm,null);

                closePopupBtn = (Button) customView.findViewById(R.id.cancel);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                //close the popup window on button click
                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });

    }
}
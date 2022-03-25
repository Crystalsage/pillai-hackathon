package com.example.oldagemanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DisplayUserData extends AppCompatActivity {
    TextView name,religion,age,literate,pension,health,bed_wr;
    ImageView show_img;
    RadioGroup lit_rg;
    RadioButton rb_yes_lit, rb_no_lit;
    String d_name,d_religion,d_age,d_bed_w,d_health_con,d_lit,d_pension,d_imag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_data);

        lit_rg=(RadioGroup)findViewById(R.id.literate_rg);

        rb_yes_lit=(RadioButton)findViewById(R.id.yes_lit);
        rb_no_lit=(RadioButton)findViewById(R.id.no_lit);
        name=(TextView)findViewById(R.id.name_disp);
//        religion=(TextView)findViewById(R.id.religion_disp);
        age=(TextView)findViewById(R.id.age_disp);
//        literate=(TextView)findViewById(R.id.liter_disp);
//        pension=(TextView)findViewById(R.id.pension_disp);
        health=(TextView)findViewById(R.id.health_disp);
        bed_wr=(TextView)findViewById(R.id.bed_disp);

        show_img=(ImageView)findViewById(R.id.user_img_disp);



        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){

            d_name=bundle.getString("d_name");
            d_religion=bundle.getString("d_religion");
            d_age=bundle.getString("d_age");
            d_bed_w=bundle.getString("d_bedw");
            d_health_con=bundle.getString("d_healthcon");
            d_lit= bundle.getString("d_literate");
            d_pension=bundle.getString("d_pension");
            d_imag=bundle.getString("d_imgurl");


            if (d_lit.equals("Yes")){
                rb_yes_lit.setChecked(true);
            }

            name.setText(d_name);
//            religion.setText(d_religion);
            age.setText(d_age+ "\tyears old");
//            literate.setText(d_lit);
//            pension.setText(d_pension);
            health.setText("Health Status :\t"+d_health_con);
            bed_wr.setText("Bed Allocated :\t"+d_bed_w);

            Picasso.get().load(d_imag).into(show_img);


        }else {
            Toast.makeText(this, "Failed to Load", Toast.LENGTH_SHORT).show();

        }

    }
}
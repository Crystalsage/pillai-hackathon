package com.example.oldagemanagmentsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class ManageDataFemale extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6,et7;
    String age,bed,health,literate,name,pension,religion,userid,uniqueId;
    Button add_female;
    ImageView add_image;
    FirebaseFirestore firestore;
    FirebaseAuth fAuth;
    String img_url="null";
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;
    StorageReference storageReference;

    String p_name,p_religion,p_age,user_id,bed_w,health_con,lit_u,pension_u,imag_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_data_female);
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        uniqueId = ref.push().getKey();
        et1=(EditText) findViewById(R.id.age_et_female);
        et2=(EditText) findViewById(R.id.bed_et_female);
        et3=(EditText) findViewById(R.id.health_con_et_female);
        et4=(EditText) findViewById(R.id.literacy_et_female);
        et5=(EditText) findViewById(R.id.name_et_female);
        et6=(EditText) findViewById(R.id.pension_et_female);
        et7=(EditText) findViewById(R.id.religion_et_female);

        add_female=(Button)findViewById(R.id.add_female);

        fAuth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        add_image=(ImageView)findViewById(R.id.add_image_folder_female);

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){


            add_female.setText("Update Details");
            user_id=bundle.getString("u_id");
            p_name=bundle.getString("u_name");
            p_religion=bundle.getString("u_religion");
            p_age=bundle.getString("u_age");
            bed_w=bundle.getString("u_bedw");
            health_con=bundle.getString("u_healthcon");
            lit_u= bundle.getString("u_literate");
            pension_u=bundle.getString("u_pension");
            imag_u=bundle.getString("u_imgurl");



            et2.setText(bed_w);
            et3.setText(health_con);
            et4.setText(lit_u);
            et6.setText(pension_u);
            et5.setText(p_name);
            et7.setText(p_religion);
            et1.setText(p_age);

            Picasso.get().load(imag_u).into(add_image);


        }else {

        }

        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFileChooser();
            }
        });



        add_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();
                if (bundle!= null){

                    String id= user_id;
                    String bed_w = et2.getText().toString();
                    String health_con = et3.getText().toString();
                    String lit_u = et4.getText().toString();
                    String pension_u = et6.getText().toString();
                    String p_name = et5.getText().toString();
                    String p_age = et1.getText().toString();
                    String p_religion = et7.getText().toString();

                    updateData(id,bed_w,health_con,lit_u,pension_u,p_name,p_age,p_religion);


                }else{

                }

                age = et1.getText().toString();
                bed = et2.getText().toString();
                health = et3.getText().toString();
                literate = et4.getText().toString();
                name = et5.getText().toString();
                pension = et6.getText().toString();
                religion = et7.getText().toString();
                // userid = fAuth.getCurrentUser().getUid();
                DocumentReference documentReference = firestore.collection("Female Users").document(uniqueId);
                Map<String, Object> user = new HashMap<>();
                user.put("Id",uniqueId);
                user.put("Age", age);
                user.put("bed_w", bed);
                user.put("health_con", health);
                user.put("Literacy", literate);
                user.put("Name", name);
                user.put("Pension", pension);
                user.put("Religion", religion);
                user.put("Image",img_url);
                user.put("search",name.toLowerCase());
                //user.put("userType",spin_val);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ManageDataFemale.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ManageDataFemale.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
                startstorageprocessimage();
            }
        });

//        add_female.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                age=et1.getText().toString();
//                bed=et2.getText().toString();
//                health=et3.getText().toString();
//                literate=et4.getText().toString();
//                name=et5.getText().toString();
//                pension=et6.getText().toString();
//                religion=et7.getText().toString();
//            }
//        });
    }

    private void updateData(String id, String bed_w, String health_con, String lit_u, String pension_u, String p_name, String p_age, String p_religion) {
        firestore.collection("Female Users").document(id)
                .update("Age",p_age,"bed_w",bed_w,"health_con",health_con,"Literacy",lit_u,"Pension",pension_u,"Name",p_name,"Religion",p_religion)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ManageDataFemale.this, "Data Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ManageDataFemale.this, "Data updating failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openFileChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    private void startstorageprocessimage() {
        if(mImageUri==null){
            Toast.makeText(ManageDataFemale.this, "PLS UPLOAD AN IMAGE", Toast.LENGTH_SHORT).show();
        }

        final StorageReference reference=storageReference.child("Profile Pics").child("Female/"+name+System.currentTimeMillis()+".jpeg");
        reference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("Female Users").document(uniqueId);
                        Map<String,Object> user= new HashMap<>();
                        user.put("Image",uri.toString());
                        documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(ManageDataFemale.this, "Photo Updated", Toast.LENGTH_SHORT).show();
                                //preogressbar.setVisibility(View.INVISIBLE);
                                Toast.makeText(ManageDataFemale.this, "Data Updated, Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainDasboard.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ManageDataFemale.this, "Photo Updating Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            Picasso.Builder builder = new Picasso.Builder(this);
            builder.listener(new Picasso.Listener()
            {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
                {
                    exception.printStackTrace();
                }
            });
            builder.build().load(mImageUri).into(add_image);
        }
    }
}
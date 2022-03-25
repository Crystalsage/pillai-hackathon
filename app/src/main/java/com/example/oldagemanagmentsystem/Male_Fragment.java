package com.example.oldagemanagmentsystem;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Male_Fragment extends Fragment {

    private ArrayList<PersonViewItems> coursesArrayList;
    private viewPersonAdapter courseRVAdapter;
    RecyclerView recview;
    ImageButton imageButton;
    Toolbar toolbar;

    FloatingActionButton add_male;
    private FirebaseFirestore db;
    ProgressBar loadingPB;

    TextView tvdisp;


    public Male_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_male_, container, false);
        setHasOptionsMenu(true);

        add_male=(FloatingActionButton)view.findViewById(R.id.add_male_users);
        imageButton=(ImageButton)view.findViewById(R.id.GoBackButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),MainDasboard.class));
            }
        });

        toolbar=view.findViewById(R.id.toolbar_records);
        toolbar.setTitle("Male Records");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        recview=(RecyclerView)view.findViewById(R.id.male_recycler);
        recview.setNestedScrollingEnabled(false);
        loadingPB = view.findViewById(R.id.idProgressBar);
        db=FirebaseFirestore.getInstance();
        coursesArrayList = new ArrayList<>();
        recview.setHasFixedSize(true);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        courseRVAdapter = new viewPersonAdapter(coursesArrayList, getContext(),Male_Fragment.this);

        // setting adapter to our recycler view.
        recview.setAdapter(courseRVAdapter);


        add_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),ManageData.class));
            }
        });

        showData();
        return view;
    }

    private void showData(){
        db.collection("Male Users").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                PersonViewItems c = d.toObject(PersonViewItems.class);
                                coursesArrayList.add(c);
                            }
                            courseRVAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.records_menu, menu);

        MenuItem item= menu.findItem(R.id.search_the_item);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchData(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.fitosi:
                showagefifdata();
                break;
            case R.id.lit:
                showlitdata();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void showlitdata() {

        db.collection("Male Users").whereEqualTo("Literacy","Literate").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        coursesArrayList.clear();
                        if (!queryDocumentSnapshots.isEmpty()) {
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                PersonViewItems c = d.toObject(PersonViewItems.class);
                                coursesArrayList.add(c);
                            }
                            courseRVAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });

    }

    private void showagefifdata() {
    }

    private void searchData(String s) {
        db.collection("Male Users").whereEqualTo("search",s.toLowerCase()).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        coursesArrayList.clear();
                        if (!queryDocumentSnapshots.isEmpty()) {
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                PersonViewItems c = d.toObject(PersonViewItems.class);
                                coursesArrayList.add(c);
                            }
                            courseRVAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });

    }

    public void deleteData(int index){
        db.collection("Male Users").document(coursesArrayList.get(index).getId())
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "Data Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(),Records_Activity_Main.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Failed to update Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

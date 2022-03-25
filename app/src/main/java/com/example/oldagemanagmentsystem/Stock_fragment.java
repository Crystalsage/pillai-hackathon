package com.example.oldagemanagmentsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class Stock_fragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<com.example.oldagemanagmentsystem.ModalClassStock>userlist;
    AdapterStock adapterStock;
    Toolbar toolbar;
//    ProgressBar loadingPB;
    private FirebaseFirestore db;





    public Stock_fragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_stock_fragment, container, false);
        setHasOptionsMenu(true);





        userlist = new ArrayList<>();
        userlist.add(new com.example.oldagemanagmentsystem.ModalClassStock(R.drawable.wheat,"Wheat","Quantity","300KG","_________________________________________-"));
        userlist.add(new com.example.oldagemanagmentsystem.ModalClassStock(R.drawable.rice,"Rice","Quantity","100KG","_________________________________________-"));
        userlist.add(new com.example.oldagemanagmentsystem.ModalClassStock(R.drawable.dal,"Dal","Quantity","50KG","_________________________________________-"));

        toolbar= view.findViewById(R.id.toolbar_stock);
        toolbar.setTitle("Stock Inventory");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        recyclerView = view.findViewById(R.id.stock_recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
//        loadingPB = view.findViewById(R.id.idProgressBarStock);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapterStock= new AdapterStock(userlist);
        recyclerView.setAdapter(adapterStock);
        adapterStock.notifyDataSetChanged();


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.stock_menu, menu);

        MenuItem item= menu.findItem(R.id.search_the_item_stock);

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

    private void searchData(String s) {

        db.collection("Male Users").whereEqualTo("Name",s.toLowerCase())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
//                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                com.example.oldagemanagmentsystem.ModalClassStock c = d.toObject(com.example.oldagemanagmentsystem.ModalClassStock.class);
                                userlist.add(c);
                            }
                            adapterStock.notifyDataSetChanged();
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




}
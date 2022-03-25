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


public class Recipie_fragment extends Fragment {

    View view;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModalClassRecipie> userlist;
    AdapterRecipie adapterRecipie;
    Toolbar toolbar;
    private FirebaseFirestore db;

    public Recipie_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recipie_fragment, container, false);
        setHasOptionsMenu(true);

        userlist = new ArrayList<>();
        userlist.add(new ModalClassRecipie(R.drawable.dalmakhini,"Dal Makhini","Dal","Lentils have been an integral part of my diet. In India, we pretty much eat lentils everyday and in my house especially there was never a day when there was no dal on the table.\n" +
                "\n" +
                "The most common dal that mom used to make every day was obviously the arhar/toor dal (split pigeon pea lentil). Then there was masoor dal (red lentils), chana dal and moong dal which she also made once in a while.\n" +
                "\n" +
                "But one dal that was made only on special occasions was Dal Makhani.\n" +
                "\n"));



        toolbar= view.findViewById(R.id.toolbar_recipie);
        toolbar.setTitle("Recipies");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        recyclerView = view.findViewById(R.id.recipie_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapterRecipie= new AdapterRecipie(userlist);
        recyclerView.setAdapter(adapterRecipie);
        adapterRecipie.notifyDataSetChanged();





        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.recipie_menu, menu);

        MenuItem item= menu.findItem(R.id.search_the_item_recipie);

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

        db.collection("Male Users").whereEqualTo("Name", s.toLowerCase())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
//                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                ModalClassRecipie c = d.toObject(ModalClassRecipie.class);
                                userlist.add(c);
                            }
                            adapterRecipie.notifyDataSetChanged();
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
package com.example.oldagemanagmentsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecipie extends RecyclerView.Adapter<AdapterRecipie.ViewHolder> {

    private List<com.example.oldagemanagmentsystem.ModalClassRecipie> userlist;
    public AdapterRecipie (List<com.example.oldagemanagmentsystem.ModalClassRecipie> userlist) {this.userlist = userlist; }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipie_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int resource = userlist.get(position).getImageview1();
        String name = userlist.get(position).getTextview1();
        String ingredients = userlist.get(position).getTextview2();
        String procedure = userlist.get(position).getTextview3();
//        String div = userlist.get(position).getDivider();

        holder.setData(resource, name, ingredients, procedure);

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView1;
        private TextView textView,textView1,textView2,divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.imageview_recipie);
            textView = itemView.findViewById(R.id.textview);
            textView1 = itemView.findViewById(R.id.textview1);
            textView2 = itemView.findViewById(R.id.textview2);

//            divider = itemView.findViewById(R.id.divider);
        }

        public void setData(int resource, String name, String ingredients, String procedure) {

            imageView1.setImageResource(resource);
            textView.setText(name);
            textView1.setText(ingredients);
            textView2.setText(procedure);
//            divider.setText(div);
        }
    }
}

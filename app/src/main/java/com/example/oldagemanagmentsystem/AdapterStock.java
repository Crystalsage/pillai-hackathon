package com.example.oldagemanagmentsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterStock extends RecyclerView.Adapter<AdapterStock.ViewHolder> {


private List<com.example.oldagemanagmentsystem.ModalClassStock> userlist;
public AdapterStock (List<com.example.oldagemanagmentsystem.ModalClassStock> userlist) {this.userlist = userlist; }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            int resource = userlist.get(position).getImageview1();
            String name = userlist.get(position).getTextview1();
            String quan = userlist.get(position).getTextview2();
            String amount = userlist.get(position).getTextview3();
            String div = userlist.get(position).getDivider();

            holder.setData(resource, name, quan, amount, div);

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


    private ImageView imageView1;
    private TextView textView,textView1,textView2,divider;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.imageview_stock);
            textView = itemView.findViewById(R.id.textview);
            textView1 = itemView.findViewById(R.id.textview1);
            textView2 = itemView.findViewById(R.id.textview2);

            divider = itemView.findViewById(R.id.divider);




        }

        public void setData(int resource, String name, String quan, String amount, String div) {
        imageView1.setImageResource(resource);
        textView.setText(name);
        textView1.setText(quan);
        textView2.setText(amount);
        divider.setText(div);

        }
    }
}

package com.example.oldagemanagmentsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FemaleAdapter extends RecyclerView.Adapter<FemaleAdapter.ViewHolder>{
    private ArrayList<PersonViewItems> coursesArrayList;
    private Context context;
    private FemaleFragment femaleFragment;

    public FemaleAdapter(ArrayList<PersonViewItems> coursesArrayList, Context context, FemaleFragment femaleFragment) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
        this.femaleFragment = femaleFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.person, parent, false);

        FemaleAdapter.ViewHolder viewHolder= new FemaleAdapter.ViewHolder(itemView);
        viewHolder.setOnClickListener(new FemaleAdapter.ViewHolder.ClickListener() {
            @Override
            public void onItemCLick(View view, int position) {

                String name = coursesArrayList.get(position).getName();
                String religion = coursesArrayList.get(position).getReligion();
                String age = coursesArrayList.get(position).getAge();
                String literate= coursesArrayList.get(position).getLiteracy();
                String pension= coursesArrayList.get(position).getPension();
                String health_con= coursesArrayList.get(position).getHealth_con();
                String imahe_url= coursesArrayList.get(position).getImage();
                String bed_wr=coursesArrayList.get(position).getBed_w();

                Intent intent = new Intent(context,DisplayUserData.class);
                intent.putExtra("d_name",name);
                intent.putExtra("d_religion",religion);
                intent.putExtra("d_literate",literate);
                intent.putExtra("d_pension",pension);
                intent.putExtra("d_healthcon",health_con);
                intent.putExtra("d_imgurl",imahe_url);
                intent.putExtra("d_age",age);
                intent.putExtra("d_bedw",bed_wr);

                context.startActivity(intent);


            }

            @Override
            public void onItemLongClick(View view, int position) {

                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                String [] options = {"Update","Delete"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0){

                            String name = coursesArrayList.get(position).getName();
                            String religion = coursesArrayList.get(position).getReligion();
                            String age = coursesArrayList.get(position).getAge();
                            String Id= coursesArrayList.get(position).getId();
                            String literate= coursesArrayList.get(position).getLiteracy();
                            String pension= coursesArrayList.get(position).getPension();
                            String health_con= coursesArrayList.get(position).getHealth_con();
                            String imahe_url= coursesArrayList.get(position).getImage();
                            String bed_wr=coursesArrayList.get(position).getBed_w();


                            Intent intent = new Intent(context,ManageDataFemale.class);

                            intent.putExtra("u_id",Id);
                            intent.putExtra("u_name",name);
                            intent.putExtra("u_religion",religion);
                            intent.putExtra("u_literate",literate);
                            intent.putExtra("u_pension",pension);
                            intent.putExtra("u_healthcon",health_con);
                            intent.putExtra("u_imgurl",imahe_url);
                            intent.putExtra("u_age",age);
                            intent.putExtra("u_bedw",bed_wr);

                            context.startActivity(intent);


                        }
                        if (i==1){


                            femaleFragment.deleteData(position);

                        }
                    }
                }).create().show();

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonViewItems courses = coursesArrayList.get(position);
        holder.fullname.setText(courses.getName());
        holder.religion.setText(courses.getReligion());
        holder.age.setText(courses.getAge());
        Picasso.get()
                .load(courses.getImage())
                .fit()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return coursesArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fullname;
        TextView religion;
        TextView age;
        ImageView imageView;
        View mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mView=itemView;

            fullname = itemView.findViewById(R.id.fullname);
            religion = itemView.findViewById(R.id.religion);
            age = itemView.findViewById(R.id.age);
            imageView=itemView.findViewById(R.id.person_pic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mclickListener.onItemCLick(view,getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mclickListener.onItemLongClick(view,getAdapterPosition());
                    return false;
                }
            });
        }
        public FemaleAdapter.ViewHolder.ClickListener mclickListener;

        public interface ClickListener{
            void onItemCLick(View view, int position);
            void onItemLongClick(View view, int position);
        }
        public void setOnClickListener(FemaleAdapter.ViewHolder.ClickListener clickListener){

            mclickListener=clickListener;

        }
    }
}

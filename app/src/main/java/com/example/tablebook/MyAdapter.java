package com.example.tablebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
 private  final RecyclerViewInterface recyclerViewInterface;
    String data1[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String[] s1, int[] img, RecyclerViewInterface recyclerViewInterface){
        context=ct;
        data1=s1;
        images=img;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.mytext.setText(data1[position]);
    holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mytext;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            myImage=itemView.findViewById(R.id.myImage);
            mytext=itemView.findViewById(R.id.mytext);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(MyAdapter.this.recyclerViewInterface !=null){
                        int pos=getAdapterPosition();

                        if (pos !=RecyclerView.NO_POSITION){
                            MyAdapter.this.recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }


    }


}

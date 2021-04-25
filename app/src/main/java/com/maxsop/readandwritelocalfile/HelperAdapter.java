package com.maxsop.readandwritelocalfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {

    ArrayList<String> name;
    ArrayList<String> email;
    Context context;

    public HelperAdapter(ArrayList<String> name, ArrayList<String> email, Context context) {
        this.name = name;
        this.email = email;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        MyViewClass myViewClass = new MyViewClass(view);

        return myViewClass;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.name.setText(name.get(position));
        holder.email.setText(email.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;

        public MyViewClass(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
        }
    }
}

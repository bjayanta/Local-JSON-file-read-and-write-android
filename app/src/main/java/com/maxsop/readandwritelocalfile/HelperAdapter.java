package com.maxsop.readandwritelocalfile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {

    ArrayList<String> name;
    ArrayList<String> email;

    public HelperAdapter(ArrayList<String> name, ArrayList<String> email) {
        this.name = name;
        this.email = email;
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

    }

    @Override
    public int getItemCount() {
        return 0;
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

package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Ricyle extends RecyclerView.Adapter<Ricyle.ViewHolder> {
    private List<String> lk;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;
    Ricyle(Context context, List<String> llk){
        this.inflater=LayoutInflater.from(context);
        this.lk=llk;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Ricyle.ViewHolder holder, int position) {
        String jb =lk.get(position);
        holder.textView.setText(jb);

    }

    @Override
    public int getItemCount() {
        return lk.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        ViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.recy);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

            if (clickListener !=null)clickListener.onItemClick(v,getAdapterPosition());
        }

    }
    String getItem(int id){return lk.get(id);}
    public void setClickListener(ItemClickListener st){
        this.clickListener=st;
    }
    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}

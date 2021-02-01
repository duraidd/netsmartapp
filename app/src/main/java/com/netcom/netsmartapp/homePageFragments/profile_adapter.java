package com.netcom.netsmartapp.homePageFragments;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netcom.netsmartapp.R;

import java.util.List;

public class profile_adapter extends RecyclerView.Adapter<profile_adapter.ViewHolder> {
    private List<profile_model> listItems;
    Context context;

    public profile_adapter(List<profile_model> listItems, Context context) {
        this.listItems = listItems;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_content,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        profile_model temp=listItems.get(position);
        profile_model listItem=listItems.get(position);
        holder.img.setImageResource(listItem.getLogo());
        holder.txt1.setText(listItem.getAbout());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,profile_fragment.class);
                i.putExtra("Account",temp.getLogo());
                i.putExtra("Account",temp.getAbout());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
               // context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.about);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}

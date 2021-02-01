package com.netcom.netsmartapp.homePageFragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.netcom.netsmartapp.R;

import java.util.ArrayList;

public class home_adapter extends RecyclerView.Adapter<home_adapter.myviewholder>
{
    ArrayList<home_model> dataholder;

    public home_adapter(ArrayList<home_model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_card_item_home,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.img1.setImageResource(dataholder.get(position).getImage());
        holder.img_name1.setText(dataholder.get(position).getImg_name());
        holder.homeCardView.setCardBackgroundColor(Color.parseColor(dataholder.get(position).getSub_card_bg()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a =dataholder.get(position).getImg_name();
                Toast.makeText(v.getContext(),a, Toast.LENGTH_SHORT ).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView img_name1;
        CardView homeCardView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            ImageView image;
            img1=itemView.findViewById(R.id.img);
            img_name1=itemView.findViewById(R.id.img_name);
            homeCardView = itemView.findViewById(R.id.home_card_view);
        }
    }


}

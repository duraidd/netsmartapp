package com.netcom.netsmartapp;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ClassRecyclerViewAdapter extends RecyclerView.Adapter<ClassRecyclerViewAdapter.ViewHolder> {
    private final ClassSelectionActivity context;
    private ArrayList<String> mData;
    private LayoutInflater mInflater;
    private int selectedPosition = -1;
    private String chooser_rv;
    public ClassRecyclerViewAdapter(ClassSelectionActivity classSelectionActivity, ArrayList<String> classes, String chooser_rv) {
        this.context = classSelectionActivity;
        this.mInflater = LayoutInflater.from(classSelectionActivity);
        this.mData = classes;
        this.chooser_rv = chooser_rv;

    }

    @NonNull
    @Override
    public ClassRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_class_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassRecyclerViewAdapter.ViewHolder holder, int position) {

        String classes =mData.get(position);
        holder.classes_text_view.setText(classes);

        if (selectedPosition == position) {
            Log.w("pos: ", String.valueOf(selectedPosition));
            holder.itemView.setSelected(true); //using selector drawable
            holder.card_holder.invalidate();
            holder.card_holder.setStrokeColor(Color.parseColor("#1E7C49"));
            holder.card_holder.setStrokeWidth(5);
        } else {
            Log.w("else pos: ", String.valueOf(selectedPosition));
            holder.itemView.setSelected(false);
            holder.card_holder.invalidate();
            holder.card_holder.setStrokeColor(Color.parseColor("#ffffff"));
            holder.card_holder.setStrokeWidth(5);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chooser_rv.equals("class_chooser_rv")){
                    context.selected_class = classes;
                    if(classes.equals("9th")){
                        context.term_head_layout.setVisibility(View.VISIBLE);
                        context.group_head_layout.setVisibility(View.GONE);
                    }
                    else if(classes.equals("11th") ||classes.equals("12th") ){
                        context.group_head_layout.setVisibility(View.VISIBLE);
                        context.term_head_layout.setVisibility(View.GONE);
                    }
                    else{
                        context.selected_term = "";
                        context.selected_group = "";
                        context.term_head_layout.setVisibility(View.GONE);
                        context.group_head_layout.setVisibility(View.GONE);
                    }
                }
                else if (chooser_rv.equals("term_chooser_rv")){
                    context.selected_term = classes;
                    context.selected_group = "";
                }
                else if (chooser_rv.equals("group_chooser_rv")){
                    context.selected_group = classes;
                    context.selected_term = "";
                }


                if (selectedPosition >= 0)
                    notifyItemChanged(selectedPosition);
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView classes_text_view;
        MaterialCardView card_holder;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            classes_text_view= itemView.findViewById(R.id.classes_text_view);
            card_holder= itemView.findViewById(R.id.card_holder);



        }
    }
}

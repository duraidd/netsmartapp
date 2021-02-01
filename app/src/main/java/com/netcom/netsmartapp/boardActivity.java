package com.netcom.netsmartapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import java.util.HashMap;

public class boardActivity extends AppCompatActivity {
    Button board_nxt_btn;
    MaterialCardView eng_med_card,tam_med_card,cbse,icse;
    String selectedBoard ="";
    HashMap<String, String> reg_data = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_board);

        reg_data = (HashMap<String, String>) getIntent().getSerializableExtra("data_to_pass");
        eng_med_card = findViewById(R.id.eng_med_card);
        tam_med_card = findViewById(R.id.tam_med_card);
        cbse = findViewById(R.id.cbse);
        icse = findViewById(R.id.icse);
        board_nxt_btn=findViewById(R.id.board_nxt_btn);
        eng_med_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eng_med_card.invalidate();
                tam_med_card.invalidate();
                cbse.invalidate();
                icse.invalidate();
                eng_med_card.setStrokeWidth(5);
                tam_med_card.setStrokeWidth(0);
                cbse.setStrokeWidth(0);
                icse.setStrokeWidth(0);
                board_nxt_btn.setVisibility(View.VISIBLE);
                selectedBoard = "english_medium";

            }
        });
        tam_med_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eng_med_card.invalidate();
                tam_med_card.invalidate();
                cbse.invalidate();
                icse.invalidate();
                tam_med_card.setStrokeWidth(5);
                eng_med_card.setStrokeWidth(0);
                cbse.setStrokeWidth(0);
                icse.setStrokeWidth(0);
                board_nxt_btn.setVisibility(View.VISIBLE);
                selectedBoard = "tamil_medium";

            }
        });
        cbse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eng_med_card.invalidate();
                tam_med_card.invalidate();
                cbse.invalidate();
                icse.invalidate();
                cbse.setStrokeWidth(5);
                eng_med_card.setStrokeWidth(0);
                tam_med_card.setStrokeWidth(0);
                icse.setStrokeWidth(0);
                board_nxt_btn.setVisibility(View.VISIBLE);
                selectedBoard = "cbse";

            }
        });
        icse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eng_med_card.invalidate();
                tam_med_card.invalidate();
                cbse.invalidate();
                icse.invalidate();
                icse.setStrokeWidth(5);
                eng_med_card.setStrokeWidth(0);
                tam_med_card.setStrokeWidth(0);
                cbse.setStrokeWidth(0);
                board_nxt_btn.setVisibility(View.VISIBLE);
                selectedBoard = "icse";

            }
        });
        board_nxt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selectedBoard.equals("")){
                    reg_data.put("board",selectedBoard);
                    Intent c=new Intent(boardActivity.this,ClassSelectionActivity.class);
                    c.putExtra("data_to_pass",reg_data);
                    startActivity(c);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Choose Board",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
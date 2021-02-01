package com.netcom.netsmartapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassSelectionActivity extends AppCompatActivity {
     ClassRecyclerViewAdapter adapter;
      RecyclerView rvclasses,rvterms, rvgroups;
      String  selected_class = "";
      String  selected_term = "";
      String  selected_group = "";
      Button final_submit_btn;
      LinearLayout term_head_layout, group_head_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_selection);

        Map<String, String> groupMap = new HashMap<String, String>() {{
            put("g1", "Maths, Computer Science");
            put("g2", "Maths, Biology");
            put("g3", "Pure Science");
            put("g4", "Accountancy, Commerce");

        }};

        Map<String, String> termMap = new HashMap<String, String>() {{
            put("t1", "Term 1");
            put("t2", "Term 2");
            put("t3", "Term 3");

        }};

        HashMap<String, String> reg_data = (HashMap<String, String>) getIntent().getSerializableExtra("data_to_pass");
        ArrayList<String> classes=new ArrayList<>();
        classes.add("12th");
        classes.add("11th");
        classes.add("10th");
        classes.add("9th");
        ArrayList<String> terms = new ArrayList<>(termMap.values());
        ArrayList<String> groups=new ArrayList<>(groupMap.values());
        rvclasses = findViewById(R.id.rvclasses);
        rvterms   = findViewById(R.id.rvterms);
        rvgroups   = findViewById(R.id.rvgroups);
        final_submit_btn = findViewById(R.id.final_submit_btn);
        term_head_layout = findViewById(R.id.term_head_layout);
        group_head_layout = findViewById(R.id.group_head_layout);


        rvclasses.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new ClassRecyclerViewAdapter(this, classes,"class_chooser_rv");
        rvclasses.setAdapter(adapter);

        rvterms.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new ClassRecyclerViewAdapter(this, terms,"term_chooser_rv");
        rvterms.setAdapter(adapter);

        rvgroups.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new ClassRecyclerViewAdapter(this, groups,"group_chooser_rv");
        rvgroups.setAdapter(adapter);


        final_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_data.put("class",selected_class);
                if(!selected_group.equals("")){
                    String gKeyName = getKeyName(groupMap,selected_group);
                    reg_data.put("group","true");
                    reg_data.put("group_no",gKeyName);
                    reg_data.put("term","false");
                    reg_data.put("term_no","t0");

                }
                if(!selected_term.equals("")){
                    String tKeyName = getKeyName(termMap, selected_term);
                    reg_data.put("term","true");
                    reg_data.put("term_no",tKeyName);
                    reg_data.put("group","false");
                    reg_data.put("group_no","g0");
                }

                Intent in = new Intent(ClassSelectionActivity.this, HomePageActivity.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(), "Welcome to Netcom Smart"+reg_data,Toast.LENGTH_LONG).show();
            }
        });

    }

    private String getKeyName(Map<String, String> mapToCheck, String value_to_check) {
        String key = null;
        for (Map.Entry<String, String> entry : mapToCheck.entrySet()) {
            if (entry.getValue().equals(value_to_check)) {
                key = entry.getKey();
            }
        }
        return key;
    }
}

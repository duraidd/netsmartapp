package com.netcom.netsmartapp.homePageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.netcom.netsmartapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<home_model> dataholder;

    public home_fragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment first_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_fragment, container, false);
        recyclerView=view.findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        dataholder=new ArrayList<>();
        home_model ob1 =new home_model(R.drawable.sub_mat_ico,"Maths","#282E65");
        dataholder.add(ob1);
        home_model ob2 =new home_model(R.drawable.sub_tam_ico,"Tamil", "#4720B6");
        dataholder.add(ob2);
        home_model ob3 =new home_model(R.drawable.sub_eng_ico,"English","#E15555");
        dataholder.add(ob3);
        home_model ob4 =new home_model(R.drawable.sub_geo_ico,"Social","#00A1AB");
        dataholder.add(ob4);
        home_model ob5 =new home_model(R.drawable.sub_sci_ico,"Science","#CD49A0");
        dataholder.add(ob5);
        recyclerView.setAdapter(new home_adapter(dataholder));
        return view;
    }
}
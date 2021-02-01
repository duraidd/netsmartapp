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
 * Use the {@link profile_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profile_fragment extends Fragment {

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    ArrayList<profile_model> profileDataholder;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profile_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fourth_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static profile_fragment newInstance(String param1, String param2) {
        profile_fragment fragment = new profile_fragment();
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
        View view=inflater.inflate(R.layout.fragment_profile_fragment, container, false);
        recyclerView=view.findViewById(R.id.profile_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));

        profileDataholder=new ArrayList<>();


        profile_model ob1=new profile_model("Account",R.drawable.profile_account_icon);
        profileDataholder.add(ob1);
        profile_model ob2=new profile_model("My Subscription",R.drawable.profile_my_subscription_icon);
        profileDataholder.add(ob2);
        profile_model ob3=new profile_model("About us",R.drawable.profile_about_us_icon);
        profileDataholder.add(ob3);
        profile_model ob4=new profile_model("Report an issue",R.drawable.profile_report_an_issue_icon);
        profileDataholder.add(ob4);
        profile_model ob5=new profile_model("Share the app",R.drawable.profile_share_app_icon);
        profileDataholder.add(ob5);
        profile_model ob6=new profile_model("Sign Out",R.drawable.profile_sign_out_icon);
        profileDataholder.add(ob6);
        recyclerView.setAdapter(new profile_adapter(profileDataholder, getContext()));
        return view;
    }
}
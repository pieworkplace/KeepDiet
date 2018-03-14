package com.keepdiet.android.keepdiet;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        User user = ((MainActivity) getActivity()).getUser();
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ((TextView) view.findViewById(R.id.more_account)).setText(user.getUsername());
        return view;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.more_start_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StartGroupActivity.class));
            }
        });
        view.findViewById(R.id.more_find_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FindGroupActivity.class));
            }
        });
    }

}

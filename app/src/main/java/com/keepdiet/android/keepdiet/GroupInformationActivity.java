package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.Group;

public class GroupInformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_information);
        Toolbar toolbar = findViewById(R.id.toolbar_group_information);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Intent intent = getIntent();
        Group group = (Group) intent.getSerializableExtra("Group");

        LinearLayout layout = findViewById(R.id.group_information_linear_layout);

        TextView groupNameTextView = layout.findViewById((R.id.group_name));
        TextView groupLocationTextView = layout.findViewById((R.id.groupLocation));
        TextView groupTargetTextView = layout.findViewById((R.id.groupTarget));
        TextView groupMaxMemberTextView = layout.findViewById((R.id.maxMember));
        TextView groupCurrentMemberTextView = layout.findViewById((R.id.member));

        groupNameTextView.setText(group.getName());
        groupLocationTextView.setText(group.getLocation());
        groupTargetTextView.setText(group.getGroupTarget());
        groupMaxMemberTextView.setText(Integer.toString(group.getMaxUser()));
        groupCurrentMemberTextView.setText(Integer.toString(group.getCurrentUserNum()));

    }
}

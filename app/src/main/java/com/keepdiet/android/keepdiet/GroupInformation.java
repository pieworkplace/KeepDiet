package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.keepdiet.android.keepdiet.userData.Group;

public class GroupInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_information);
        Intent intent = getIntent();
        Group group = (Group) intent.getSerializableExtra("Group");
        if (group == null){
            Toast.makeText(GroupInformation.this, "aaaaa", Toast.LENGTH_SHORT).show();
        }

        LinearLayout layout = findViewById(R.id.group_information_linear_layout);

        TextView groupNameTextView = layout.findViewById((R.id.groupName));
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

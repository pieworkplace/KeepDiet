package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.keepdiet.android.keepdiet.userData.Group;
import com.keepdiet.android.keepdiet.utils.GroupInformationAdapter;

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

        RecyclerView recyclerView = findViewById(R.id.group_information_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GroupInformationAdapter(group.groupToList()));
        Button joinOrDeleteButton = findViewById(R.id.join_or_delete);
        if (intent.getStringExtra("joinOrDelete").equals("join")){
            joinOrDeleteButton.setText(R.string.join_this_group);
        }else {
            joinOrDeleteButton.setText(R.string.delete_this_group);
        }


    }
}

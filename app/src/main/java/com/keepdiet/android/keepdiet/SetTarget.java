package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SetTarget extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_target);
        findViewById(R.id.addTarget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View targetView = getLayoutInflater().inflate(R.layout.start_group_new_target, null);
                ((LinearLayout) findViewById(R.id.start_group_add_target_linear_layout)).addView(targetView);
            }
        });
    }
}

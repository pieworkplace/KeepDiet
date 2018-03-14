package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindGroupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindGroupActivity.this, FindGroupResult.class
                ));
            }
        });
    }
}

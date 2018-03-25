package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class FindGroupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group);
        Toolbar toolbar = findViewById(R.id.toolbar_find_group);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SearchView searchView = findViewById(R.id.search_group_search_view);
        searchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(FindGroupActivity.this, "yes", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FindGroupActivity.this, FindGroupResult.class));
                }
                else {
                    Toast.makeText(FindGroupActivity.this, "no", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

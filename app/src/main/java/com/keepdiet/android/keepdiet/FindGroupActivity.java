package com.keepdiet.android.keepdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FindGroupActivity extends Activity {

    private SearchView searchView;
    private View rootView;

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

        searchView = findViewById(R.id.search_group_search_view);
        rootView = findViewById(R.id.find_group_layout);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    startActivity(new Intent(FindGroupActivity.this, QuickSearchGroupActivity.class));
                }
            }
        });
        findViewById(R.id.advanced_search_in_find_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindGroupActivity.this, AdvancedSearchGroupActivity.class));
            }
        });
        findViewById(R.id.start_group_in_find_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindGroupActivity.this, StartGroupActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchView.setQuery("", false);
        rootView.requestFocus();
    }
}

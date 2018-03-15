package com.keepdiet.android.keepdiet;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SearchFoodActivity extends AppCompatActivity {

    public static final int CREATE_FOOD_IN_SEARCH = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        Toolbar toolbar = findViewById(R.id.toolbar_search_food);
//        toolbar.inflateMenu(R.menu.add_food_menu);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.create_food_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(SearchFoodActivity.this, AddFoodActivity.class), CREATE_FOOD_IN_SEARCH);
            }
        });
        SearchView searchView = findViewById(R.id.search_food_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                FoodSearchAsyncTask foodSearchAsyncTask = new FoodSearchAsyncTask();
                foodSearchAsyncTask.execute();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_FOOD_IN_SEARCH && resultCode == RESULT_OK){
            setResult(RESULT_OK, data);
            finish();
        }
    }

    private class FoodSearchAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            Toast.makeText(SearchFoodActivity.this, "This is my Toast message!", Toast.LENGTH_LONG).show();
            FrameLayout frameLayout = findViewById(R.id.search_food_result_from_internet);
            frameLayout.removeAllViews();
            frameLayout.addView(getLayoutInflater().inflate(R.layout.progress_circle, null));
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            FrameLayout frameLayout = findViewById(R.id.search_food_result_from_internet);
            frameLayout.removeAllViews();
            frameLayout.addView(getLayoutInflater().inflate(R.layout.no_result_error, null));
        }
    }
}

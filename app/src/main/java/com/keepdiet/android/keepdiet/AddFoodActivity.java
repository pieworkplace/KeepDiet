package com.keepdiet.android.keepdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.keepdiet.android.keepdiet.userData.Food;

public class AddFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add_food);
        toolbar.inflateMenu(R.menu.add_food_menu);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String title = ((EditText) findViewById(R.id.diary_content_title_edit)).getText().toString();
                int caloryPerUnit = Integer.parseInt(((EditText) findViewById(R.id.diary_content_calory_per_unit_edit)).getText().toString());
                double unitNumber = Double.parseDouble(((EditText) findViewById(R.id.diary_content_amount_edit)).getText().toString());
                String unitName = ((EditText) findViewById(R.id.diary_content_unit_name_edit)).getText().toString();
                Food food = new Food(title, caloryPerUnit, unitNumber, unitName);
                Intent intent = new Intent();
                intent.putExtra("Food", food);
                setResult(RESULT_OK, intent);
                finish();
                return true;
            }
        });
    }

}

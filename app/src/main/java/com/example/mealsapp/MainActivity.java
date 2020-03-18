package com.example.mealsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar sBar;
    private TextView  sText;
    private ArrayList<DishItem> dishList1;
    private DishAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sBar = (SeekBar) findViewById(R.id.quantity_seekBar);
        sText = (TextView) findViewById((R.id.text_seekBar));
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        initList();
        Spinner spinnerDishes = findViewById(R.id.dishes_spinner);
        adapter1 = new DishAdapter(this, dishList1);
        spinnerDishes.setAdapter(adapter1);

        spinnerDishes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DishItem clickedDish = (DishItem) parent.getItemAtPosition(position);
                String clickedDishName = clickedDish.getDishName();
                Toast.makeText(MainActivity.this, clickedDishName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initList(){
        dishList1 = new ArrayList<>();
        dishList1.add(new DishItem("Pav Bhaji", R.drawable.pavbhaji));
        dishList1.add(new DishItem("Pani Puri", R.drawable.panipuri));
        dishList1.add(new DishItem("Samosa", R.drawable.samosa));
        dishList1.add(new DishItem("Aloo Tikki", R.drawable.at));
        dishList1.add(new DishItem("Dahi Bhalle", R.drawable.pavbhaji));
        dishList1.add(new DishItem("Dosa", R.drawable.dosa));
        dishList1.add(new DishItem("Idli Sambhar", R.drawable.idli_sambhar));
        dishList1.add(new DishItem("Spring Rolls", R.drawable.sr));
        dishList1.add(new DishItem("Momos", R.drawable.momos));
        dishList1.add(new DishItem("Dhokla", R.drawable.dhokla));
    }
}

package com.example.time_pattern;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.time_pattern.Models.TodoList;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button btn,timeButton;
    private ListView itemList;
    private int hour,minute;

    private ArrayList<String> items;
    private TodoList todoList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        itemList = findViewById(R.id.item_list);
        timeButton = findViewById(R.id.time_btn);

        items = FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemList.setAdapter(adapter);

        btn.setOnClickListener(this);
        itemList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_btn:
                String itemEntered = timeButton.getText().toString();
                adapter.add(itemEntered);
                timeButton.setText("Select Time");
                //itemET.setText("");

                FileHelper.writeData(items, this);

                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
    }

    public void PopTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour,minute));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Select time");
        timePickerDialog.show();
    }
}
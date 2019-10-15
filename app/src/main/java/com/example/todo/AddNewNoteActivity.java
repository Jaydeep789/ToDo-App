package com.example.todo;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewNoteActivity extends AppCompatActivity {

    public static final String TITLE_KEY = "com.example.todo.TITLE_KEY";
    public static final String DESCRIPTION_KEY = "com.example.todo.DESCRIPTION_KEY";
    public static final String PRIORITY_KEY = "com.example.todo.PRIORITY_KEY";

    private EditText title, description;
    private NumberPicker priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");

        title = (EditText) findViewById(R.id.edittext_title);
        description = (EditText) findViewById(R.id.editText_desc);
        priority = (NumberPicker) findViewById(R.id.number_picker);

        priority.setMinValue(1);
        priority.setMaxValue(10);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_note, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote() {
        String Title = title.getText().toString();
        String Description = description.getText().toString();
        int Priority = priority.getValue();

        if (TextUtils.isEmpty(Title) || TextUtils.isEmpty(Description)) {
            Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(TITLE_KEY, Title);
        data.putExtra(DESCRIPTION_KEY, Description);
        data.putExtra(PRIORITY_KEY, Priority);
        setResult(RESULT_OK, data);
        finish();

    }
}

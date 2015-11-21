package com.example.nnagtode.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    /* variable declaration */
    EditText etEditText;

    String displayText;

    int UpdatePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        displayText = getIntent().getStringExtra("ItemName");
        UpdatePosition = getIntent().getIntExtra("ItemPosition", 0);

        etEditText = (EditText) findViewById(R.id.etEditText);

        etEditText.setText( displayText);
        etEditText.setSelection(etEditText.getText().length());
    }

    public void onSubmit(View v) {
        EditText etEditText = (EditText) findViewById(R.id.etEditText);
        Intent data = new Intent();
        data.putExtra("UpdatedItem", etEditText.getText().toString());
        data.putExtra("ItemPosition", UpdatePosition);

        data.putExtra("code", 200);
        setResult(RESULT_OK, data);

        this.finish();
    }

}

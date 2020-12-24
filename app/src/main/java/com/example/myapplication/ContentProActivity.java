package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContentProActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_pro);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StaffProvider.NAME,
                ((EditText) findViewById(R.id.editText2)).getText().toString());

        values.put(StaffProvider.GRADE,
                ((EditText) findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(
                StaffProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.MyApplication.StaffProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StaffProvider._ID)) +
                                ", " + c.getString(c.getColumnIndex(StaffProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex(StaffProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}
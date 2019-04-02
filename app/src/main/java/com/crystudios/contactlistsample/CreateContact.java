package com.crystudios.contactlistsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crystudios.contactlistsample.Views.CreateContactFragment;

public class CreateContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_contact_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CreateContactFragment.newInstance())
                    .commitNow();
        }
    }
}

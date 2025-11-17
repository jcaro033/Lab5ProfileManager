package com.example.profilemanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button openMaps = (Button) findViewById(R.id.openMaps);
            openMaps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText teamAddress = (EditText) findViewById(R.id.addressInput);

                    //creates url from string
                    Uri mapsUrl = Uri.parse("https://maps.google.co.in/maps?q=" + teamAddress.getText());

                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsUrl);

                    mapIntent.setPackage("com.google.android.apps.maps");

                    startActivity(mapIntent);
                }
            });
            return insets;
        });

    }

}
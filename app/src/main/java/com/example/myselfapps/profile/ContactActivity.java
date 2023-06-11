package com.example.myselfapps.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.myselfapps.R;

public class ContactActivity extends AppCompatActivity {
//    10 Juni 2023
//    10120211 - Arif Rachmat Darmawan - IF6
    CardView cvEmail, cvWhatsapp, cvInstagram;
    String urlWhatsapp = "https://wa.link/0vss0o", urlEmail = "mailto:Fajarjuniansah24@gmail.com", urlInstagram = "https://www.instagram.com/fajarjuniansah/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        cvEmail = findViewById(R.id.cv_email);
        cvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlEmail));
                startActivity(intent);
            }
        });

        cvWhatsapp = findViewById(R.id.cv_whatsapp);
        cvWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlWhatsapp));
                startActivity(intent);
            }
        });

        cvInstagram = findViewById(R.id.cv_instagram);
        cvInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlInstagram));
                startActivity(intent);
            }
        });
    }

}
package com.example.videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton fabCart = findViewById(R.id.fabCart);
        Button btnVender = findViewById(R.id.btnVender);
        Button btnComprar = findViewById(R.id.btnComprar);
        btnVender.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, Vender.class);
            startActivity(intent);
        });
        btnComprar.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, ComprarActivity.class);
            startActivity(intent);
        });

        fabCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 3. Crear un Intent para abrir la CartActivity
                Intent intent = new Intent(Menu.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
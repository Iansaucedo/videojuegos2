package com.example.videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Confirmar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.confirmar_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nombre = getIntent().getStringExtra("nombre");
        String apellidos = getIntent().getStringExtra("apellidos");
        String domicilio = getIntent().getStringExtra("domicilio");
        String dni = getIntent().getStringExtra("dni");
        String email = getIntent().getStringExtra("email");
        String cuentaBancaria = getIntent().getStringExtra("cuentaBancaria");

        // Set data to TextViews
        ((TextView) findViewById(R.id.tvNombre)).setText("Nombre: " + nombre);
        ((TextView) findViewById(R.id.tvApellidos)).setText("Apellidos: " + apellidos);
        ((TextView) findViewById(R.id.tvDomicilio)).setText("Domicilio: " + domicilio);
        ((TextView) findViewById(R.id.tvDNI)).setText("DNI: " + dni);
        ((TextView) findViewById(R.id.tvEmail)).setText("Email: " + email);
        ((TextView) findViewById(R.id.tvCuentaBancaria)).setText("Cuenta Bancaria: " + cuentaBancaria);

        Button btnGoToMenu = findViewById(R.id.btnGoToMenu);
        btnGoToMenu.setOnClickListener(v -> {
            Intent intent = new Intent(Confirmar.this, Menu.class); // Replace Menu.class with your actual menu activity class
            startActivity(intent);
            finish();
        });
    }
}
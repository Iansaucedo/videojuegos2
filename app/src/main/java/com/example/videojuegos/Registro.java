package com.example.videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnGoToMenu = findViewById(R.id.btnGoToMenu);
        btnGoToMenu.setOnClickListener(v -> {
            String nombre = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etNombre)).getText().toString();
            String apellidos = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etApellidos)).getText().toString();
            String domicilio = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etDomicilio)).getText().toString();
            String dni = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etDNI)).getText().toString();
            String email = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etEmail)).getText().toString();
            String contrasena = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etContraseña)).getText().toString();
            String cuentaBancaria = ((com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etCuentaBancaria)).getText().toString();

            Intent intent = new Intent(Registro.this, Confirmar.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("apellidos", apellidos);
            intent.putExtra("domicilio", domicilio);
            intent.putExtra("dni", dni);
            intent.putExtra("email", email);
            intent.putExtra("contrasena", contrasena);
            intent.putExtra("cuentaBancaria", cuentaBancaria);
            startActivity(intent);
        });
    }
}
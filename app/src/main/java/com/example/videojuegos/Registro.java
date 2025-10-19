package com.example.videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputEditText;

public class Registro extends AppCompatActivity {
    private TextInputLayout tilNombre, tilApellidos, tilDomicilio, tilDNI, tilEmail, tilContraseña, tilCuentaBancaria;
    private TextInputEditText etNombre, etApellidos, etDomicilio, etDNI, etEmail, etContraseña, etCuentaBancaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        // Initialize views
        tilNombre = findViewById(R.id.tilNombre);
        tilApellidos = findViewById(R.id.tilApellidos);
        tilDomicilio = findViewById(R.id.tilDomicilio);
        tilDNI = findViewById(R.id.tilDNI);
        tilEmail = findViewById(R.id.tilEmail);
        tilContraseña = findViewById(R.id.tilContraseña);
        tilCuentaBancaria = findViewById(R.id.tilCuentaBancaria);
        
        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDomicilio = findViewById(R.id.etDomicilio);
        etDNI = findViewById(R.id.etDNI);
        etEmail = findViewById(R.id.etEmail);
        etContraseña = findViewById(R.id.etContraseña);
        etCuentaBancaria = findViewById(R.id.etCuentaBancaria);

        Button btnGoToMenu = findViewById(R.id.btnGoToMenu);
        btnGoToMenu.setOnClickListener(v -> {

                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                String domicilio = etDomicilio.getText().toString();
                String dni = etDNI.getText().toString();
                String email = etEmail.getText().toString();
                String contrasena = etContraseña.getText().toString();
                String cuentaBancaria = etCuentaBancaria.getText().toString();

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
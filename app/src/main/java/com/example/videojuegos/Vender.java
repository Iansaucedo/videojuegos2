package com.example.videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Vender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vender);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnPublicar = findViewById(R.id.button2);
        btnPublicar.setOnClickListener(v -> {
            String nombreVideojuego = ((TextInputEditText) findViewById(R.id.ETNombreVideojuego)).getText().toString();
            String plataforma = ((Spinner) findViewById(R.id.desplegablePlat)).getSelectedItem().toString();
            String estado = ((TextInputEditText) findViewById(R.id.ETNombreVideojuego2)).getText().toString();
            String precio = ((TextInputEditText) findViewById(R.id.ETNombreVideojuego3)).getText().toString();

            Intent intent = new Intent(Vender.this, confirmacionActivity.class);
            intent.putExtra("nombre_videojuego", nombreVideojuego);
            intent.putExtra("plataforma", plataforma);
            intent.putExtra("estado", estado);
            intent.putExtra("precio", precio);
            startActivity(intent);
        });
    }
}
package com.example.videojuegos;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class confirmacionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.toolbar), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nombreJuego = getIntent().getStringExtra("nombre_videojuego");
        TextView tvNombreJuego = findViewById(R.id.tvNombreJuego);
        if (nombreJuego != null && !nombreJuego.isEmpty()) {
            tvNombreJuego.setText("Videojuego: " + nombreJuego);
        } else {
            tvNombreJuego.setText("");
        }
    }
}
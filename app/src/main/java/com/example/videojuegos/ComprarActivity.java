package com.example.videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ComprarActivity extends AppCompatActivity {

    // Recursos de juegos
    private int[] titleResIds = {
            R.string.game1_title,
            R.string.game2_title,
            R.string.game3_title
    };

    private int[] descResIds = {
            R.string.game1_desc,
            R.string.game2_desc,
            R.string.game3_desc
    };

    private int[] gameImages = {
            R.drawable.vjuego1,
            R.drawable.vjuego2,
            R.drawable.vjuego3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que este layout tenga LinearLayout con id "gameContainer"

        LinearLayout container = findViewById(R.id.gameContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        // Crear cards dinámicamente
        for (int i = 0; i < titleResIds.length; i++) {
            View itemView = inflater.inflate(R.layout.item_game, container, false);

            ImageView image = itemView.findViewById(R.id.gameImage);
            TextView title = itemView.findViewById(R.id.gameTitle);
            TextView desc = itemView.findViewById(R.id.gameDescription);
            Button buyButton = itemView.findViewById(R.id.buyButton);

            // Asignar contenido
            image.setImageResource(gameImages[i]);
            title.setText(getString(titleResIds[i]));
            desc.setText(getString(descResIds[i]));

            // Acción del botón: abrir CartActivity
            buyButton.setOnClickListener(v -> {
                Intent intent = new Intent(ComprarActivity.this, CartActivity.class);
                startActivity(intent);
            });

            // Añadir la card al contenedor
            container.addView(itemView);
        }
    }
}

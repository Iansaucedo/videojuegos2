package com.example.videojuegos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    // Datos de ejemplo para los ítems en el carrito
    private String[] cartGameTitles = {"The Last of Us", "Red Dead Redemption 2"};
    private double[] cartGamePrices = {19.99, 39.99};
    private int[] cartGameImages = {R.drawable.vjuego1, R.drawable.vjuego2};
    private double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // 1. Obtener el contenedor del layout
        LinearLayout container = findViewById(R.id.cartContainer);
        LayoutInflater inflater = LayoutInflater.from(this);
        TextView totalTextView = findViewById(R.id.totalText);

        // 2. Iterar sobre los datos y crear una vista para cada ítem
        for (int i = 0; i < cartGameTitles.length; i++) {
            // Inflar el layout de la tarjeta (item_card)
            View itemView = inflater.inflate(R.layout.item_card, container, false);

            // Obtener las referencias a las vistas dentro de la tarjeta
            ImageView image = itemView.findViewById(R.id.gameImage);
            TextView title = itemView.findViewById(R.id.gameTitle);
            TextView price = itemView.findViewById(R.id.gamePrice);
            Button removeButton = itemView.findViewById(R.id.removeButton);

            // 3. Establecer los datos en las vistas
            image.setImageResource(cartGameImages[i]);
            title.setText(cartGameTitles[i]);
            price.setText(String.format(Locale.getDefault(), "€%.2f", cartGamePrices[i]));

            // Sumar al total
            total += cartGamePrices[i];

            // 4. (Opcional) Añadir funcionalidad al botón de eliminar
            final View itemToRemove = itemView;
            removeButton.setOnClickListener(v -> {
                // Simplemente oculta la vista por ahora
                itemToRemove.setVisibility(View.GONE);
                // Aquí podrías recalcular el total
            });

            // 5. Añadir la vista de la tarjeta al contenedor principal
            container.addView(itemView);
        }

        // 6. Actualizar el texto del total
        totalTextView.setText(String.format(Locale.getDefault(), "Total: €%.2f", total));
    }
}

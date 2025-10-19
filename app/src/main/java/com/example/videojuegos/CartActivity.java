package com.example.videojuegos;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

// El nombre de la clase DEBE ser CartActivity
public class CartActivity extends AppCompatActivity {

    private double totalAmount = 0.0;
    private TextView totalTextView;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. Asegúrate de que el layout sea activity_cart.xml
        setContentView(R.layout.activity_cart);

        // 2. Obtener las referencias a los componentes del layout del carrito
        container = findViewById(R.id.cartContainer);
        totalTextView = findViewById(R.id.totalText);
        Button payButton = findViewById(R.id.payButton);

        // 3. Cargar los items en el carrito (siguiendo el modelo de ComprarActivity)
        loadCartItems();

        // 4. Configurar el listener para el botón de pagar
        payButton.setOnClickListener(v -> {
            // Aquí irá la lógica para proceder al pago
            // Ejemplo: mostrar un Toast o navegar a otra Activity
            // Toast.makeText(this, "Pago procesado correctamente", Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Carga los datos de los juegos desde los recursos, crea una vista para cada uno
     * y la añade dinámicamente al contenedor del carrito.
     */
    private void loadCartItems() {
        LayoutInflater inflater = LayoutInflater.from(this);

        // --- Carga de datos desde los recursos centralizados (arrays.xml) ---
        String[] gameTitles = getResources().getStringArray(R.array.game_titles);
        TypedArray gameImages = getResources().obtainTypedArray(R.array.game_images);
        String[] gamePricesStr = getResources().getStringArray(R.array.game_prices);

        // --- Bucle para crear y añadir cada tarjeta ---
        for (int i = 0; i < gameTitles.length; i++) {
            // Convertir el precio del juego actual de String a double
            double priceValue = Double.parseDouble(gamePricesStr[i]);

            // Inflar el layout específico para el item del carrito
            View itemView = inflater.inflate(R.layout.item_card, container, false);

            // Obtener las vistas dentro de la tarjeta (item_card)
            ImageView image = itemView.findViewById(R.id.gameImage);
            TextView title = itemView.findViewById(R.id.gameTitle);
            TextView priceLabel = itemView.findViewById(R.id.priceLabel);
            TextView price = itemView.findViewById(R.id.gamePrice);
            Button removeButton = itemView.findViewById(R.id.removeButton);

            // Asignar los datos desde los arrays cargados
            image.setImageResource(gameImages.getResourceId(i, -1));
            title.setText(gameTitles[i]);
            priceLabel.setText(R.string.price_label);
            price.setText(String.format(Locale.getDefault(), "%.2f€", priceValue));
            // Sumar el precio de este item al total
            totalAmount += priceValue;

            // Configurar el botón de eliminar
            final View itemToRemove = itemView;
            removeButton.setOnClickListener(v -> {
                // Restar el precio del total
                totalAmount -= priceValue;
                // Eliminar la vista del contenedor
                container.removeView(itemToRemove);
                // Actualizar el texto del total en la UI
                updateTotal();
            });

            // Añadir la vista del item al contenedor del carrito
            container.addView(itemView);
        }

        // ¡Muy importante! Liberar la memoria del TypedArray después de usarlo.
        gameImages.recycle();

        // Actualizar el texto del total por primera vez
        updateTotal();
    }

    /**
     * Actualiza el TextView que muestra el total de la compra.
     */
    private void updateTotal() {
        if (container.getChildCount() == 0) {
            totalTextView.setText(getString(R.string.cart_empty));
            totalAmount = 0.0;
        } else {
            String totalText = getString(R.string.total_label, totalAmount);
            totalTextView.setText(totalText);
        }
    }
}

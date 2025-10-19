package com.example.videojuegos;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    private double totalAmount = 0.0;
    private TextView totalTextView;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Obtener referencias
        container = findViewById(R.id.cartContainer);
        totalTextView = findViewById(R.id.totalText);
        Button payButton = findViewById(R.id.payButton);

        // Cargar los items en el carrito
        loadCartItems();

        // Configurar botón de pago

        payButton.setOnClickListener(v -> {
            if (totalAmount > 0) {
                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                intent.putExtra("TOTAL_AMOUNT", totalAmount);
                startActivity(intent);
            } else {
                Toast.makeText(this, "El carrito está vacío", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadCartItems() {
        LayoutInflater inflater = LayoutInflater.from(this);

        // Arrays de recursos
        String[] gameTitles = getResources().getStringArray(R.array.game_titles);
        TypedArray gameImages = getResources().obtainTypedArray(R.array.game_images);
        String[] gamePricesStr = getResources().getStringArray(R.array.game_prices);

        for (int i = 0; i < gameTitles.length; i++) {
            double priceValue = Double.parseDouble(gamePricesStr[i]);

            // Inflar layout del item
            View itemView = inflater.inflate(R.layout.item_card, container, false);

            ImageView image = itemView.findViewById(R.id.gameImage);
            TextView title = itemView.findViewById(R.id.gameTitle);
            TextView priceLabel = itemView.findViewById(R.id.priceLabel);
            TextView price = itemView.findViewById(R.id.gamePrice);
            Button removeButton = itemView.findViewById(R.id.removeButton);

            // Asignar datos
            image.setImageResource(gameImages.getResourceId(i, -1));
            title.setText(gameTitles[i]);
            priceLabel.setText(R.string.price_label);
            price.setText(String.format(Locale.getDefault(), "%.2f€", priceValue));

            // Sumar al total
            totalAmount += priceValue;

            // Configurar botón eliminar
            final View itemToRemove = itemView;
            removeButton.setOnClickListener(v -> {
                totalAmount -= priceValue;
                totalAmount = Math.max(totalAmount, 0.0); // prevenir total negativo
                container.removeView(itemToRemove);
                updateTotal();
            });

            container.addView(itemView);
        }

        // Liberar TypedArray
        gameImages.recycle();

        // Mostrar total inicial
        updateTotal();
    }

    private void updateTotal() {
        if (container.getChildCount() == 0) {
            totalTextView.setText(getString(R.string.cart_empty));
            totalAmount = 0.0;
        } else {
            String totalText = String.format(Locale.getDefault(), "Total: %.2f€", totalAmount);
            totalTextView.setText(totalText);
        }
    }
}

package com.example.videojuegos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private TextView paymentTotal;
    private EditText edtName, edtCardNumber, edtExpiry, edtCVV;
    private Button btnConfirmPayment;
    private double totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Obtener referencias
        paymentTotal = findViewById(R.id.paymentTotal);
        edtName = findViewById(R.id.edtName);
        edtCardNumber = findViewById(R.id.edtCardNumber);
        edtExpiry = findViewById(R.id.edtExpiry);
        edtCVV = findViewById(R.id.edtCVV);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        // Obtener el total pasado desde CartActivity
        totalAmount = getIntent().getDoubleExtra("TOTAL_AMOUNT", 0.0);
        paymentTotal.setText(String.format("Total a pagar: %.2f€", totalAmount));

        // Botón confirmar pago
        btnConfirmPayment.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String card = edtCardNumber.getText().toString().trim();
            String expiry = edtExpiry.getText().toString().trim();
            String cvv = edtCVV.getText().toString().trim();

            if (name.isEmpty() || card.isEmpty() || expiry.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí iría la lógica real de pago
                Toast.makeText(this, "Pago de " + String.format("%.2f€", totalAmount) + " realizado con éxito", Toast.LENGTH_LONG).show();
                finish(); // cerrar activity después del pago
            }
        });
    }
}

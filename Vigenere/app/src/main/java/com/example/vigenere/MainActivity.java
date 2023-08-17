package com.example.vigenere;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText plaintextEditText;
    private EditText keyEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plaintextEditText = findViewById(R.id.plaintext_edit_text);
        keyEditText = findViewById(R.id.key_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        Button encryptButton = findViewById(R.id.encrypt_button);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String plaintext = plaintextEditText.getText().toString();
                String key = keyEditText.getText().toString();
                String ciphertext = VigenereCipher.encrypt(plaintext, key);
                resultTextView.setText(ciphertext);
            }
        });

        Button decryptButton = findViewById(R.id.decrypt_button);
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ciphertext = plaintextEditText.getText().toString();
                String key = keyEditText.getText().toString();
                String plaintext = VigenereCipher.decrypt(ciphertext, key);
                resultTextView.setText(plaintext);
            }
   });
}
}
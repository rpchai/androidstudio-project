package com.example.nmitsecuresms;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRecipient;
    private EditText editTextMessage;
    private Button btnEncrypt;
    private Button btnSend;
    private TextView textViewEncryptedMessageContent;
    private String encryptedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRecipient = findViewById(R.id.editTextRecipient);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnEncrypt = findViewById(R.id.btnEncrypt);
        btnSend = findViewById(R.id.btnSend);
        textViewEncryptedMessageContent = findViewById(R.id.textViewEncryptedMessageContent);

        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encryptMessage();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void encryptMessage() {
        // TODO: Implement message encryption logic here
        String message = editTextMessage.getText().toString();

        // Encrypt the message using cryptographic techniques

        // Update the UI to display the encrypted message
        textViewEncryptedMessageContent.setText("Encrypted Message: " + encryptedMessage);
    }

    private void sendMessage() {
        // TODO: Implement message sending logic here
        String recipient = editTextRecipient.getText().toString();
        String encryptedMessage = textViewEncryptedMessageContent.getText().toString();

        // Send the encrypted message to the recipient using SMS

        // Clear the input fields and encrypted message display
        editTextRecipient.setText("");
        editTextMessage.setText("");
        textViewEncryptedMessageContent.setText("");
    }
}

package com.example.vigenere;


import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;
public class VigenereCipher {
    private static final int ALPHABET_SIZE = 26;


    public static String encrypt(String plaintext, String key) {
            plaintext = plaintext.toUpperCase();
            key = key.toUpperCase();
            StringBuilder ciphertext = new StringBuilder();
            int keyIndex = 0;

            for (int i = 0; i < plaintext.length(); i++) {
                char currentChar = plaintext.charAt(i);
                if (Character.isLetter(currentChar)) {
                    int plainCharValue = currentChar - 'A';
                    int keyCharValue = key.charAt(keyIndex) - 'A';
                    int encryptedCharValue = (plainCharValue + keyCharValue) % ALPHABET_SIZE;
                    char encryptedChar = (char) (encryptedCharValue + 'A');
                    ciphertext.append(encryptedChar);
                    keyIndex = (keyIndex + 1) % key.length();
                } else {
                    ciphertext.append(currentChar);
                }
            }

            return ciphertext.toString();
        }


    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int encryptedCharValue = currentChar - 'A';
                int keyCharValue = key.charAt(keyIndex) - 'A';
                int decryptedCharValue = (encryptedCharValue - keyCharValue + ALPHABET_SIZE) % ALPHABET_SIZE;
                char decryptedChar = (char) (decryptedCharValue + 'A');
                plaintext.append(decryptedChar);
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                plaintext.append(currentChar);
            }
        }

        return plaintext.toString();
    }
}

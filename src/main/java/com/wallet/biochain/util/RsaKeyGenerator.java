package com.wallet.biochain.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.Base64;

/**
 * Utility class to generate RSA key pair for JWT signing
 * Run this class once to generate the keys, then comment it out
 */
public class RsaKeyGenerator {

    private static final int KEY_SIZE = 2048;
    private static final String KEYS_DIRECTORY = "src/main/resources/keys";
    private static final String PRIVATE_KEY_FILE = KEYS_DIRECTORY + "/private_key.pem";
    private static final String PUBLIC_KEY_FILE = KEYS_DIRECTORY + "/public_key.pem";

    public static void main(String[] args) {
        try {
            // Create keys directory if it doesn't exist
            Path keysDir = Paths.get(KEYS_DIRECTORY);
            if (!Files.exists(keysDir)) {
                Files.createDirectories(keysDir);
                System.out.println("✓ Created directory: " + KEYS_DIRECTORY);
            }

            // Generate RSA key pair
            System.out.println("Generating RSA key pair (" + KEY_SIZE + " bits)...");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Save private key
            savePrivateKey(keyPair.getPrivate());
            System.out.println("✓ Private key saved: " + PRIVATE_KEY_FILE);

            // Save public key
            savePublicKey(keyPair.getPublic());
            System.out.println("✓ Public key saved: " + PUBLIC_KEY_FILE);

            System.out.println("\n========================================");
            System.out.println("RSA keys generated successfully!");
            System.out.println("========================================");
            System.out.println("\nIMPORTANT: Add these lines to your .gitignore:");
            System.out.println("src/main/resources/keys/*.pem");
            System.out.println("\nYou can now delete or comment out this generator class.");

        } catch (Exception e) {
            System.err.println("Error generating keys: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void savePrivateKey(PrivateKey privateKey) throws IOException {
        String privateKeyPEM = convertToPEM(privateKey.getEncoded(), "PRIVATE KEY");
        try (FileWriter writer = new FileWriter(PRIVATE_KEY_FILE)) {
            writer.write(privateKeyPEM);
        }
    }

    private static void savePublicKey(PublicKey publicKey) throws IOException {
        String publicKeyPEM = convertToPEM(publicKey.getEncoded(), "PUBLIC KEY");
        try (FileWriter writer = new FileWriter(PUBLIC_KEY_FILE)) {
            writer.write(publicKeyPEM);
        }
    }

    private static String convertToPEM(byte[] keyBytes, String keyType) {
        String base64Encoded = Base64.getEncoder().encodeToString(keyBytes);

        StringBuilder pem = new StringBuilder();
        pem.append("-----BEGIN ").append(keyType).append("-----\n");

        // Split into 64-character lines
        int index = 0;
        while (index < base64Encoded.length()) {
            int endIndex = Math.min(index + 64, base64Encoded.length());
            pem.append(base64Encoded, index, endIndex).append("\n");
            index = endIndex;
        }

        pem.append("-----END ").append(keyType).append("-----\n");
        return pem.toString();
    }
}
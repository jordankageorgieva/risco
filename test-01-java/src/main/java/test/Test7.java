package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Test7 {
    public static void main(String[] args) throws Exception {
        byte[] msg = "Hello World".getBytes();
       // byte[] password = "1234567890123456".getBytes(); 
        byte[] password = askForPassword().getBytes();

        byte[] enc;
        
        try {
        	 enc = encrypt(msg, password);
		} catch (InvalidKeyException e) {
			// TODO: handle exception
			 throw new Exception("Invalid AES password length");
		}
       
	
        if (Arrays.equals(msg, enc)) {
            throw new IllegalStateException("The message was not encrypted correctly");
        }

        byte[] plain = decrypt(enc, password);

        if (!Arrays.equals(msg, plain)) {
            throw new IllegalStateException("The message was not decrypted correctly");
        }

        System.out.println("SUCCEEDED!!!");
    }

    public static String askForPassword() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Type password and press [ENTER]: ");
            return reader.readLine();
        } catch (Throwable t) {
            throw new IllegalStateException(t.getMessage(), t);
        }
    }

    public static byte[] encrypt(byte[] plain, byte[] password) throws Exception{
        // Encrypt here and return encrypted
    	
    	// Create a new SecretKeySpec using the provided key
        SecretKeySpec secretKey = new SecretKeySpec(password, "AES");
        
        // Initialize Cipher in encryption mode
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(plain);
        
        // Return the encrypted data as a Base64 encoded string
        return Base64.getEncoder().encode(encryptedData);
    }

    public static byte[] decrypt(byte[] encrypted, byte[] password) throws Exception{
        // Decrypt here and return encrypted
    	
    	// Create a new SecretKeySpec using the provided key
        SecretKeySpec secretKey = new SecretKeySpec(password, "AES");
        
        // Initialize Cipher in decryption mode
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        // Decode the Base64 encoded string to get the encrypted byte data
        byte[] decodedData = Base64.getDecoder().decode(encrypted);
        
        // Decrypt the data
        byte[] decryptedData = cipher.doFinal(decodedData);
        
        return decryptedData;
    }
}

package remaining_topics.Networking.Loading_TrustStore_and_KeyStore_from_InputStream;

import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;

public class TrustLoader {
    public static void main(String args[]) {
        try {
            // Step 1: Load TrustStore file from inside JAR at /ssl/rpgrenadesClient.jks
            InputStream stream = TrustLoader.class.getResourceAsStream("/ssl/rpgrenadesClient.jks");

            // Step 2: Create a KeyStore instance of default type (usually JKS)
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

            // Step 3: Set TrustStore password
            char[] trustStorePassword = "password".toCharArray();

            // Step 4: Load TrustStore data from the InputStream
            trustStore.load(stream, trustStorePassword);

            // Step 5: Create SSLContext for communication
            SSLContext context = SSLContext.getInstance("SSL");

            // Step 6: Create TrustManagerFactory and initialize it with TrustStore
            TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            factory.init(trustStore);

            // Step 7: Get TrustManagers from factory
            TrustManager[] managers = factory.getTrustManagers();

            // Step 8: Initialize SSLContext with the TrustManagers
            context.init(null, managers, null);

            // Step 9: Set the default SSLContext globally
            SSLContext.setDefault(context);

        } catch (KeyStoreException | IOException | NoSuchAlgorithmException |
                 CertificateException | KeyManagementException ex) {
            ex.printStackTrace();
        }
    }
}


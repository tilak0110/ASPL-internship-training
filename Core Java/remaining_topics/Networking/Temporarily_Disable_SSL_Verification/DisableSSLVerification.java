package remaining_topics.Networking.Temporarily_Disable_SSL_Verification;

import javax.net.ssl.*;
import java.security.*;
import java.security.cert.X509Certificate;

public class DisableSSLVerification {
    public static void main(String[] args) {
        try {
            // Step 1: Create a trust manager that trusts all certificates
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null; // No specific trusted issuers
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            // Do nothing - trust all
                        }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            // Do nothing - trust all
                        }
                    }
            };

            // Step 2: Initialize an SSLContext with our all-trusting manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            // Step 3: Set the default SocketFactory to use our unsafe SSLContext
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Step 4: Create a hostname verifier that approves all hosts
            HostnameVerifier allHostsValid = (hostname, session) -> true;

            // Step 5: Apply the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            System.out.println("SSL verification is now disabled — development mode!");

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }
}


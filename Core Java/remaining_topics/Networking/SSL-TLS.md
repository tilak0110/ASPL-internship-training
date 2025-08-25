## Loading TrustStore and KeyStore from InputStream


**What is a TrustStore and KeyStore?**
 - When we use SSL/TLS:
    - KeyStore – Holds your application's private keys and corresponding certificates (used to prove your identity to others).
    - TrustStore – Holds public certificates of other parties (Certificate Authorities or servers) that you trust.
 - Java uses these for encrypted communication via the JSSE (Java Secure Socket Extension).
### Think Of:
 - TrustStore as "people I trust".
 - KeyStore as "my own ID and credentials".

### Step-by-Step Explanation for Loading TrustStore and KeyStore from InputStream:
1. Get the TrustStore file
- /ssl/rpgrenadesClient.jks is inside your project/JAR.
- A .jks file is a Java KeyStore file containing certificates.
2. Create KeyStore object
- KeyStore.getDefaultType() is usually "JKS" but could be "PKCS12".
3. Load the TrustStore
- trustStore.load(stream, password) reads the .jks contents.
4. Setup SSLContext
- SSLContext defines the environment for SSL sockets (which certificates to trust, etc.).
5. Configure TrustManager
- TrustManagerFactory reads trusted certificates.
- A TrustManager decides if a certificate from the server is acceptable.
6. Initialize SSLContext
- context.init(...) loads our TrustManagers into the context.
7. Apply SSLContext globally
- Any HttpsURLConnection or SSLSocket will now use this trust configuration.

### Loading a KeyStore (When the Server Needs to Authenticate Itself)
- Replace TrustStore with KeyStore in naming.
- Use a KeyManagerFactory:

### Why This Matters
- Without a TrustStore/KeyStore setup:
- Your Java app won’t know which certificates it can trust.
- Connecting to HTTPS or SSL/TLS servers can fail with
- javax.net.ssl.SSLHandshakeException: PKIX path building failed.
- By customizing TrustStores and KeyStores, you:
  - Control your app’s security policy.
  - Can communicate securely even with custom/self-signed certificates (common in testing).

# Reading a web page using a simple socket.
1. Connect to a web server
- "stackoverflow.com" is the hostname.
- Port 80 is the standard for HTTP (non-secure).
2. Create I/O streams
- OutputStream: send HTTP request to the server.
- InputStream: read server’s HTTP response.
3. Send the HTTP request
- Request Line – "GET / HTTP/1.1"
- Host Header – "Host: stackoverflow.com"
- Blank line – marks the end of headers.
- use \r\n for proper HTTP line breaks.
4. Read the response
5. Close the socket

# Temporarily Disable SSL Verification (for Testing Purposes).
**Why Disable SSL Verification?**
In development:
- The certificate might be self-signed.
- The certificate chain might not be complete.
- You might not have set up a proper TrustStore yet.

How It Works:
1. Custom TrustManager
- Bypasses certificate validation (checkServerTrusted does nothing).
2. SSLContext customization
- Loads our trust-all TrustManagers so every SSL connection trusts any certificate.
3. HostnameVerifier
- Normally checks if the HTTPS hostname matches the certificate’s CN/SAN value.
- We override it to always return true.
4. HttpsURLConnection Defaults
-The changes are applied globally to all HttpsURLConnection usage in your app.

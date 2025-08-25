What is a Socket?
A socket is an endpoint for sending or receiving data across a computer network. Sockets can be used for building networked applications, like chat servers, games, and file sharing.

There are two main roles:

Server: Waits for incoming connections.

Client: Connects to the server.

## Client Server Communication Using Socket

A. Creating a Basic Socket Server: 
1. Start the Server
    - To create a server that can accept client connections:
        - ServerSocket: Listens for incoming connections.
        - accept(): Blocks until a client connects, then returns a Socket instance for communication.
2. Handling Multiple Clients
    - Each accept() call only handles one client. To support multiple simultaneous clients, use threads:

B. Creating a Basic Client:
- client connects to the server and sends a message.
- IP address: 127.0.0.1 means "localhost" .
- Port: Matches the server's.
Closing Sockets and Error Handling:
- Just like files, sockets use operating system resources.
- try-with-resources: Ensures the socket is closed automatically.
- Exception handling: Catches network errors.

# Key Points
- TCP socket communication: Server waits for clients; 
- clients connect and communicate using streams.
- Multi-threading: Essential for handling multiple clients in parallel.
- Always close sockets: Prevents resource leaks.
- Exception handling: Important for robust network applications.

## Client Server Communication Using Socket
# UDP Basics
- UDP uses DatagramPackets, which are small chunks of data sent individually without establishing a connection.
- There’s no handshake like in TCP. You just send and hope the other side receives it.
- Works best when speed is more important than guaranteed delivery.

# Key Points:
- The server must listen on the same port the client sends to.
- receive() blocks until a packet comes.
- DatagramSocket is closed after processing.

# Advantages of UDP
- Extremely fast (no handshake, no re-transmission delays).
- Works great for broadcasting/multicasting to multiple clients.
- No need to maintain a connection state.

# Disadvantagesof UDP:
- No built-in reliability — if a packet is dropped, it’s gone.
- Receiving application must handle lost or duplicate packets.



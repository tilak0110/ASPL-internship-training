1. What is Multicasting?
- With normal UDP, you send data to one IP:port, and only that receiver gets it.
- With multicasting, you send data to a special multicast IP address in the range 224.0.0.0 to 239.255.255.255.
- Any client that has joined that multicast group will receive the packet.
- Sender only sends once, but multiple listeners get it.

2. How it works
- Server (Sender): Sends a UDP packet to a multicast group IP and port.
- Client (Receiver): Joins the same group and port, then listens for packets.
- All clients that have joined receive the same message simultaneously.

3. Running the Example
- Run the Client first.
- Run the Server.
- The client will print
- 

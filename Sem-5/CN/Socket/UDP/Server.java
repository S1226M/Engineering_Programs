import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];

        DatagramPacket DpReceive;

        System.out.println("Server is running and waiting for client messages...");

        while (true) {
            // Step 2: Create DatagramPacket to receive the data
            DpReceive = new DatagramPacket(receive, receive.length);

            // Step 3: Receive the data in byte buffer
            ds.receive(DpReceive);

            String receivedStr = data(receive, DpReceive.getLength()).toString();
            System.out.println("Client:- " + receivedStr);

            // Exit the server if the client sends "bye"
            if (receivedStr.trim().equalsIgnoreCase("bye")) {
                System.out.println("Client sent 'bye'.....EXITING");
                break;
            }

            // Clear the buffer after every message (optional - not mandatory)
            receive = new byte[65535];
        }

        ds.close(); // Close the socket when done
    }

    // A utility method to convert the byte array data into a string representation.
    public static StringBuilder data(byte[] a, int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            ret.append((char) a[i]);
        }
        return ret;
    }
}


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClintServerClint {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int myPort = 5001;
        DatagramSocket ds = new DatagramSocket(myPort);

        InetAddress serverIP = InetAddress.getByName("10.20.60.244"); // Change to your server IP
        int serverPort = 5614;

        System.out.println("Client started on port " + myPort + ". Connected to server at " + serverIP + ":" + serverPort);

        // Thread to receive messages from server
        Thread receiverThread = new Thread(() -> {
            byte[] buffer = new byte[65535];
            while (true) {
                try {
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                    ds.receive(dp);
                    String msg = new String(dp.getData(), 0, dp.getLength());
                    System.out.println("\nReceived: " + msg + "\nYou: ");
                } catch (IOException e) {
                    break;
                }
            }
        });

        receiverThread.start();

        // Send messages to server
        while (true) {
            System.out.print("You: ");
            String message = sc.nextLine();
            if (message.equalsIgnoreCase("bye")) {
                break;
            }

            DatagramPacket dpSend = new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    serverIP,
                    serverPort
            );
            ds.send(dpSend);
        }

        ds.close();
        sc.close();
        System.out.println("Client exited.");
    }
}

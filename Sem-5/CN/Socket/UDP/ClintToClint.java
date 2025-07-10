import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClintToClint {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Change the following as per the client
        int myPort = 5001; // Client A: 5001, Client B: 5002
        String receiverIP = "10.20.60.244"; // For Client A: IP of Client B
        int receiverPort = 5002; // For Client A: Port of Client B

        DatagramSocket ds = new DatagramSocket(myPort);
        InetAddress receiverAddress = InetAddress.getByName(receiverIP);

        System.out.println("Client started on port " + myPort + ". Sending to " + receiverIP + ":" + receiverPort);

        // Thread to receive messages
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

        // Send messages
        while (true) {
            System.out.print("You: ");
            String message = sc.nextLine();
            if (message.equalsIgnoreCase("bye")) break;

            DatagramPacket dpSend = new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    receiverAddress,
                    receiverPort
            );
            ds.send(dpSend);
        }

        ds.close();
        sc.close();
        System.out.println("Client exited.");
    }
}
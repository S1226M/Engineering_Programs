import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("10.20.60.244"); // Replace with your target IP

        System.out.println("Enter messages to send to the server. Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String inp = sc.nextLine();

            byte[] buf = inp.getBytes();

            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 6523);
            ds.send(DpSend);

            if (inp.equalsIgnoreCase("bye")) {
                System.out.println("Exiting client...");
                break;
            }
        }

        // Clean up resources
        sc.close();
        ds.close();
    }
}

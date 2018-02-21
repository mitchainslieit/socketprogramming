import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class SocketClient {
    private Socket socket;
    private Scanner scanner;
    private SocketClient(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args) throws Exception {
        SocketClient client = new SocketClient(InetAddress.getByName("192.168.5.196"), 50385);

        System.out.println("\r\nConnected to: " + client.socket.getInetAddress());
        client.start();
    }
    private void start() throws IOException {
        String input;
        while (true) {
            input = scanner.nextLine();
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println(input);
            out.flush();
        }
    }
}
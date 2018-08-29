
// A Java program for a Server
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class PcmSoketServer {

	// initialize socket and input stream
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;

	// constructor with port
	public PcmSoketServer(int port) {

		try {

			// starts server and waits for a connection

			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket

			in = new DataInputStream(new FileInputStream("C:\\Users\\anta0517\\Downloads\\pcmwav\\mynewpcm.wav"));
			out = new DataOutputStream(socket.getOutputStream());

			sendPCMDataInChunks(in, out);

			in.close();
			out.close();
			System.out.println("Closing connection");

		} catch (IOException i) {
			System.out.println(i.getMessage());
		}

	}

	private void sendPCMDataInChunks(InputStream is, DataOutputStream dos) throws IOException {

		final int READ_TIMEOUT = 50;
		final int FRAME_SIZE = 2;
		final int NO_OF_CHANNELS = 1;
		final int SAMPLING_RATE = 16;
		
		int read = 0;

		byte[] buffer = new byte[FRAME_SIZE * NO_OF_CHANNELS * SAMPLING_RATE * READ_TIMEOUT];

		while (read != -1) {
			read = is.read(buffer);
			if (read != -1) {
				try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
					out.write(buffer, 0, read);
					dos.write(out.toByteArray());
					TimeUnit.MILLISECONDS.toNanos(READ_TIMEOUT);
					System.out.println(" Size : " + out.size() + ", MILLISECONDS - " + READ_TIMEOUT);
					out.reset();
				}
			}
			//System.out.println(" Size : " + out.size() + ", MILLISECONDS - " + READ_TIMEOUT);
			//out.reset();
		}

		System.out.println(" Total Size : " + out.size());
	}
	
	private void sendPCMDataInChunks_Old(InputStream is, DataOutputStream dos) throws IOException {

		final int READ_TIMEOUT = 50;
		final int FRAME_SIZE = 2;
		final int NO_OF_CHANNELS = 1;
		final int SAMPLING_RATE = 16;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int read = 0;

		byte[] buffer = new byte[FRAME_SIZE * NO_OF_CHANNELS * SAMPLING_RATE * READ_TIMEOUT];

		while (read != -1) {
			read = is.read(buffer);
			if (read != -1) {
				out.write(buffer, 0, read);
				dos.write(out.toByteArray());
				TimeUnit.MILLISECONDS.toNanos(READ_TIMEOUT);
			}
			System.out.println(" Size : " + out.size() + ", MILLISECONDS - " + READ_TIMEOUT);
			out.reset();
		}

		System.out.println(" Total Size : " + out.size());
	}

	public static void main(String args[]) {
		PcmSoketServer server = new PcmSoketServer(5050);
	}
}

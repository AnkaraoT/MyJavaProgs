
// A Java program for a Client
import java.net.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.*;

public class PcmSoketClient {

	// initialize socket and input output streams
	private Socket socket = null;
	//private DataInputStream input = null;
	private DataOutputStream out = null;

	// constructor to put ip address and port
	public PcmSoketClient(String address, int port) {
		// establish a connection
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			//input = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());

			int totalFramesRead = 0;
			File fileIn = new File("C:\\Users\\anta0517\\Downloads\\a2002011001-e02.wav");
			//File fileIn = new File("a2002011001-e02.wav");
			// somePathName is a pre-existing string whose value was
			// based on a user selection.
			//try {
			  AudioInputStream audioInputStream =   AudioSystem.getAudioInputStream(fileIn);
			  int bytesPerFrame =  audioInputStream.getFormat().getFrameSize();
			  
			  if (bytesPerFrame == AudioSystem.NOT_SPECIFIED) {
			    // some audio formats may have unspecified frame size
			    // in that case we may read any amount of bytes
			    bytesPerFrame = 1;
			  } 
			  // Set an arbitrary buffer size of 1024 frames.
			  int numBytes = 1024 * bytesPerFrame; 
			  byte[] audioBytes = new byte[numBytes];
		//	  try {
			    int numBytesRead = 0;
			    int numFramesRead = 0;
			    // Try to read numBytes bytes from the file.
			    while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
			      // Calculate the number of frames actually read.
			      numFramesRead = numBytesRead / bytesPerFrame;
			      totalFramesRead += numFramesRead;
			      // Here, do something useful with the audio data that's 
			      // now in the audioBytes array...
			      
			     // ByteArrayOutputStream baout = new ByteArrayOutputStream();
				 // baout.write(audioBytes);
				  out.write(audioBytes);
			      //out = new DataOutputStream(baout);
			      
			      System.out.println("totalFramesRead-"+totalFramesRead);
			    }
			  /*} catch (Exception ex) { 
			    // Handle the error...
			  }
			} catch (Exception e) {
			  // Handle the error...
			}*/
		
			

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		/*} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}*/

		/*// string to read message from input
		String line = "";

		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			try {
				line = input.readLine();
				out.writeUTF(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}*/

		// close the connection
		//try {
		//	input.close();
			out.close();
			socket.close();
		} catch (IOException | UnsupportedAudioFileException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		PcmSoketClient client = new PcmSoketClient("127.0.0.1", 5050);
	}
}
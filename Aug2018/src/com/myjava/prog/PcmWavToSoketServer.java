package com.myjava.prog;

// A Java program for a Server
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class PcmWavToSoketServer {

	// initialize socket and input stream
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	static int count =0;
	// constructor with port
	public PcmWavToSoketServer(int port) {
		

			
                try{
                	
                	// starts server and waits for a connection
            		
        			server = new ServerSocket(port);
        			System.out.println("Server started");

        			System.out.println("Waiting for a client ...");

        			socket = server.accept();
        			System.out.println("Client accepted");

        			// takes input from the client socket
        			BufferedInputStream bins= new BufferedInputStream(socket.getInputStream());
        			in = new DataInputStream(bins);
        			AudioInputStream ais = null;
        			
        			while (true){                    
                     //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     long fileSize = bins.available();
                     System.out.println("bins.available() - "+fileSize);
                     if(bins.available()!=0){                          
                         /* int fileSize = Integer.parseInt(in.readLine());
                          float sampleRate = Float.parseFloat(in.readLine());
                          int sampleSizeInBits = Integer.parseInt(in.readLine());
                          int Channels = Integer.parseInt(in.readLine());
                          int frameSize = Integer.parseInt(in.readLine());
                          float frameRate = Float.parseFloat(in.readLine());
                          boolean isBigEndian = Boolean.parseBoolean(in.readLine());*/
                          //String hiddenMessage = in.readLine();
                          
                          /*byte[] data = new byte[1024*2];
                          InputStream socketInputStream = socket.getInputStream();
                          socketInputStream.read(data);
                          String sound = new String(data).trim();
                          byte[] mybytearray = in.readByte();*/
                          
                          //AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(filename));
                          
                         // AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sampleRate,8, 1, true, true);
                          AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 2, 44100, false);

                         //java.io.InputStream stream = new ByteArrayInputStream(mybytearray);
                         ais = new AudioInputStream(bins, format, fileSize);
                         AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("C:\\Users\\anta0517\\Downloads\\pcmwav\\mynewpcm"+count+".wav"));
                     }else {
                    	 try {
                    		 if(ais!=null)
                    			 ais.close();
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                     }
                         
        			}
			//System.out.println("Closing connection");

                     
                            
		} catch (IOException i) {
			System.out.println(i.getMessage());
		}				
		
	
	}

	public static void main(String args[]) {
		PcmWavToSoketServer server = new PcmWavToSoketServer(5050);
	}
}

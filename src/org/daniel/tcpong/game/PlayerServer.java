package org.daniel.tcpong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerServer {
	
	private JFrame frame = new JFrame("Ping");
	private JPanel panel = new JPanel();
	
	private ServerSocket server;
	private Socket client;
	
	public PlayerServer() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setContentPane(panel);
		frame.setVisible(true);
		
		panel.setBackground(Color.BLACK);
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					try {
						initConnection();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
			
		});
	}
	
	private void initConnection() throws IOException {
		server = new ServerSocket(12365);
		client = server.accept();
		read();
	}
	
	private void read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println(reader.readLine());
		read();
	}
	
	private void render() {
		Graphics g = panel.getGraphics();
		
	}

}

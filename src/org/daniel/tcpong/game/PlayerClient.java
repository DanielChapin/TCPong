package org.daniel.tcpong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerClient {
	
	private JFrame frame = new JFrame("Pong");
	private JPanel panel = new JPanel();
	
	private Socket server;
	
	public PlayerClient() {
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
				
			}
			
		});
		
		initConnection();
	}
	
	private void initConnection() {
		try {
			server = new Socket("localhost", 12365);
		} catch (IOException e) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			initConnection();
			e.printStackTrace();
		}
		try {
			read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		System.out.println(reader.readLine());
		read();
	}
	
	private void render() {
		Graphics g = panel.getGraphics();
		panel.repaint();
	}

}

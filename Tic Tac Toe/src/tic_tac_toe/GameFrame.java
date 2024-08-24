package tic_tac_toe;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame {
	
	private JFrame frame;
	private GamePanel panel;
	
	public GameFrame() {
		
		frame = new JFrame();
		frame.setTitle("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 500));
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		panel = new GamePanel();
		frame.add(panel.topPanel, BorderLayout.NORTH);
		
		frame.add(panel.mainPanel, BorderLayout.CENTER);
	}

}

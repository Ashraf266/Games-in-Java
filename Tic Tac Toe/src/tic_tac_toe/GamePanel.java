package tic_tac_toe;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel implements Runnable{
	
	private JLabel title;
	public JPanel topPanel;
	public JPanel mainPanel;
	private GameBoard board;
	private Thread gameThread;
	
	public GamePanel()
	{
		title = new JLabel("Tic Tac Toe");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		
		topPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(title);
		
		board= new GameBoard();
		mainPanel = board.board;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns= 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			
			if(delta >= 1) {
				if(board.checkWinner() || board.isBoardFull())
				{
					board.clearBoard();
					title.setText("X: "+board.xScore+"          VS          "+"O: "+board.oScore);
				}
				delta--;
			}
		}
	}

}

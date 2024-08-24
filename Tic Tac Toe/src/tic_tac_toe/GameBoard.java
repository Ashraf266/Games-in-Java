package tic_tac_toe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard {

	public JPanel board;
	public JButton[] button;
	public String playerTurn;
	private int[] boardLogic;
	public int xScore;
	public int oScore;
	
	public GameBoard() {

		board = new JPanel(new GridLayout(3, 3, 0, 0));
		button = new JButton[9];
		playerTurn = "X";
		boardLogic = new int[9];
		xScore=0;
		oScore=0;
		
		Font font = new Font("Monospace", Font.BOLD, 50);
		
		for(int i=0;i<9;i++)
		{
			button[i] = new JButton();
			button[i].setFont(font);
			button[i].addActionListener(new AL(i));
			board.add(button[i]);
		}
		
		
	}
	
	public boolean checkWinner()
	{
		int sum;
		if(Math.abs(sum = boardLogic[0]+boardLogic[1]+boardLogic[2]) == 3
		|| Math.abs(sum = boardLogic[3]+boardLogic[4]+boardLogic[5]) == 3
		|| Math.abs(sum = boardLogic[6]+boardLogic[7]+boardLogic[8]) == 3
		|| Math.abs(sum = boardLogic[0]+boardLogic[3]+boardLogic[6]) == 3
		|| Math.abs(sum = boardLogic[1]+boardLogic[4]+boardLogic[7]) == 3
		|| Math.abs(sum = boardLogic[2]+boardLogic[5]+boardLogic[8]) == 3
		|| Math.abs(sum = boardLogic[0]+boardLogic[4]+boardLogic[8]) == 3
		|| Math.abs(sum = boardLogic[2]+boardLogic[4]+boardLogic[6]) == 3)
		{
			if(sum > 0)
			{
				System.out.println("X wins");
				xScore++;
			}
			else
			{
				System.out.println("O wins");
				oScore++;
			}
			return true;
		}
		return false;
	}
	
	public boolean isBoardFull()
	{
		for(int i=0;i<9;i++)
			if(boardLogic[i] == 0)
				return false;
		return true;
	}
	
	public void clearBoard()
	{
		for(int i=0;i<9;i++)
		{
			button[i].setText("");
		}
		for(int i=0;i<9;i++)
		{
			boardLogic[i] = 0;
		}
		playerTurn="X";
	}
	
	
	
	private class AL implements ActionListener 
	{
		
		private int id;
		public AL(int id)
		{
			this.id = id;
		}
		@Override
		 public void actionPerformed(ActionEvent e) {
			if(button[id].getText() == "")
			{
				button[id].setText(playerTurn);
				if(playerTurn == "X")
				{
					boardLogic[id] = 1;
					playerTurn = "O";
				}
				else
				{
					playerTurn = "X";
					boardLogic[id] = -1;
				}
			}
			
		}
	}
}

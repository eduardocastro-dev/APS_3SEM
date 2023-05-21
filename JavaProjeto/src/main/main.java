package main;
import java.awt.Color;
import javax.swing.*;

public class main extends JFrame{

	public static void main(String[] args)  {
		JFrame obj = new JFrame();
		Jogo jogo = new Jogo();
		
		obj.setBounds(10,10,905,700);
		obj.setBackground(Color.BLACK);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(jogo);
	}

}

package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogo extends JPanel implements KeyListener, ActionListener{
	
	private int[] garixlenght = new int[750];
	private int[] gariylenght = new int[750];
	
	private boolean esquerda = false;
	private boolean direita = false;
	private boolean cima = false;
	private boolean baixo = false;
	
	private ImageIcon direitagari;
	private ImageIcon esquerdagari;
	private ImageIcon cimagari;
	private ImageIcon baixogari;
	
	private int comprimentogari = 3;
	
	private Timer timer;
	private int atraso = 120;
	private int [] coletaxpos = {100,125,150,175,200,225,250,275,300,
			325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,
			725,750,775,800};
	private int [] coletaypos = {100,125,150,175,200,225,250,275,300,
			325,350,375,400,425,450,475,500,525,550};
	
	private ImageIcon lixo;
	
	private Random random = new Random();
	private int xpos = random.nextInt(30);
	private int ypos = random.nextInt(16);
	private int movimento = 0;
	
	private ImageIcon coletado;
	private int pontuacao = 0;
	
	private ImageIcon fundoImage;
	private ImageIcon tituloImage;
	
	public Jogo() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(atraso,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		if(movimento == 0) {
			
			garixlenght[2]= 50;
			garixlenght[1]= 75;
			garixlenght[0]= 100;
			
			gariylenght[2]= 100;
			gariylenght[1]= 100;
			gariylenght[0]= 100;
		}
		
		g.setColor(Color.white);
		g.drawRect(24,10,851,55);
		//Gari Julio
		tituloImage =  new ImageIcon("final.png");
		tituloImage.setImage(tituloImage.getImage().getScaledInstance(850, 54, 1));
		tituloImage.paintIcon(this, g, 25, 11);
		
		//Bordaplano de fundo
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		//plano de fundo
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		fundoImage = new ImageIcon("teste.jpg");
		fundoImage.setImage(fundoImage.getImage().getScaledInstance(850,575,1));
		fundoImage.paintIcon(this, g, 25, 75);;
		
		//pontucao
		g.setColor(Color.white);
		g.setFont(new Font("arail", Font.PLAIN,14));
		g.drawString("PONTOS: " +pontuacao,780,30);
		
		//Comprimento
		g.setColor(Color.white);
		g.setFont(new Font("arail", Font.PLAIN,14));
		g.drawString("COLETAS: " +comprimentogari,780,50);
		
		direitagari = new ImageIcon("JulioD.png");
		direitagari.setImage(direitagari.getImage().getScaledInstance(75, 50, 1));
		direitagari.paintIcon(this, g, garixlenght[0], gariylenght[0]);
		
		for(int a = 0; a < comprimentogari; a++) {
			if(a==0 && direita) {
				direitagari = new ImageIcon("JulioD.png");
				direitagari.setImage(direitagari.getImage().getScaledInstance(75, 50, 1));
				direitagari.paintIcon(this, g, garixlenght[a], gariylenght[a]);
			}
			if(a==0 && esquerda) {
				esquerdagari = new ImageIcon("JulioE.png");
				esquerdagari.setImage(esquerdagari.getImage().getScaledInstance(75, 50, 1));
				esquerdagari.paintIcon(this, g, garixlenght[a], gariylenght[a]);
			}
			if(a==0 && baixo) {
				baixogari = new ImageIcon("JulioF.png");
				baixogari.setImage(baixogari.getImage().getScaledInstance(75, 50, 1));
				baixogari.paintIcon(this, g, garixlenght[a], gariylenght[a]);
			}
			if(a==0 && cima) {
				cimagari = new ImageIcon("JulioC.png");
				cimagari.setImage(cimagari.getImage().getScaledInstance(75, 50, 1));
				cimagari.paintIcon(this, g, garixlenght[a], gariylenght[a]);
			}
			
			if(a !=0) {
				lixo = new ImageIcon("lixo.png");
				lixo.setImage(lixo.getImage().getScaledInstance(75, 50, 1));
				lixo.paintIcon(this, g, garixlenght[a], gariylenght[a]);
			}
		}
		
		coletado = new ImageIcon("coletado.png");
		coletado.setImage(coletado.getImage().getScaledInstance(75, 50, 1));
		if((coletaxpos[xpos] == garixlenght[0] && coletaypos[ypos] == gariylenght[0])) {
			pontuacao++;
			comprimentogari++;
			xpos = random.nextInt(30);
			ypos = random.nextInt(16);
			
		}
		
		coletado.paintIcon(this, g, coletaxpos[xpos], coletaypos[ypos]);
		
		for(int b = 1; b <comprimentogari;b++) {
			if((garixlenght[b] == garixlenght[0] && gariylenght[b] == gariylenght[0])) {
				 esquerda = false;
				 direita = false;
				 cima = false;
				 baixo = false;
				 
				 g.setColor(Color.white);
				 g.setFont(new Font("arial", Font.BOLD, 50));
				 g.drawString("FIM DE JOGO", 300, 300);
				 
				 g.setFont(new Font("arial", Font.BOLD, 20));
				 g.drawString("ESPACO PARA REINICIO", 350, 340);
				 
			}
			if(garixlenght[b] > 845) {
				 esquerda = false;
				 direita = false;
				 cima = false;
				 baixo = false;
				 
				 g.setColor(Color.white);
				 g.setFont(new Font("arial", Font.BOLD, 50));
				 g.drawString("FIM DE JOGO", 300, 300);
				 
				 g.setFont(new Font("arial", Font.BOLD, 20));
				 g.drawString("ESPACO PARA REINICIO", 350, 340);
				
			}
			if(garixlenght[b] < 20) {
				 esquerda = false;
				 direita = false;
				 cima = false;
				 baixo = false;
				 
				 g.setColor(Color.white);
				 g.setFont(new Font("arial", Font.BOLD, 50));
				 g.drawString("FIM DE JOGO", 300, 300);
				 
				 g.setFont(new Font("arial", Font.BOLD, 20));
				 g.drawString("ESPACO PARA REINICIO", 350, 340);
			}
			if(gariylenght[b] < 60) {
				 esquerda = false;
				 direita = false;
				 cima = false;
				 baixo = false;
				 
				 g.setColor(Color.white);
				 g.setFont(new Font("arial", Font.BOLD, 50));
				 g.drawString("FIM DE JOGO", 300, 300);
				 
				 g.setFont(new Font("arial", Font.BOLD, 20));
				 g.drawString("ESPACO PARA REINICIO", 350, 340);
				
			}
			if(gariylenght[b] > 590) {
				 esquerda = false;
				 direita = false;
				 cima = false;
				 baixo = false;
				 
				 g.setColor(Color.white);
				 g.setFont(new Font("arial", Font.BOLD, 50));
				 g.drawString("FIM DE JOGO", 300, 300);
				 
				 g.setFont(new Font("arial", Font.BOLD, 20));
				 g.drawString("ESPACO PARA REINICIO", 350, 340);
			}
			
		}
		
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(direita) {
			for (int r = comprimentogari-1; r>=0;r--) {
				gariylenght[r+1]= gariylenght[r];
			}			
			for (int r = comprimentogari-1; r>=0;r--) {
				if(r==0) {
					garixlenght[r]= garixlenght[r]+25;
				}
				else {
					garixlenght[r]= garixlenght[r-1];
				}

			}
			repaint();
		}
		if(esquerda) {
			for (int r = comprimentogari-1; r>=0;r--) {
				gariylenght[r+1]= gariylenght[r];
			}			
			for (int r = comprimentogari-1; r>=0;r--) {
				if(r==0) {
					garixlenght[r]= garixlenght[r]-25;
				}
				else {
					garixlenght[r]= garixlenght[r-1];
				}

			}
			repaint();
		}
		if(cima) {
			for (int r = comprimentogari-1; r>=0;r--) {
				garixlenght[r+1]= garixlenght[r];
			}			
			for (int r = comprimentogari-1; r>=0;r--) {
				if(r==0) {
					gariylenght[r]= gariylenght[r] - 25;
				}
				else {
					gariylenght[r]= gariylenght[r-1];
				}

			}
			repaint();
		}
		if(baixo) {
			for (int r = comprimentogari-1; r>=0;r--) {
				garixlenght[r+1]= garixlenght[r];
			}			
			for (int r = comprimentogari-1; r>=0;r--) {
				if(r==0) {
					gariylenght[r]= gariylenght[r] + 25;
				}
				else {
					gariylenght[r]= gariylenght[r-1];
				}

			}
			repaint();
		 }
		}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()== KeyEvent.VK_SPACE) {
			movimento = 0;
			pontuacao = 0;
			comprimentogari =3;
			repaint();
		}
		
		if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
			
			movimento++;
			direita = true;
			if(!esquerda) {
				direita = true;
			}else {
				direita = false;
				esquerda = true;
			}
			cima = false;
			baixo = false;		
		}
		
		if (e.getKeyCode()== KeyEvent.VK_LEFT) {
			
			movimento++;
			esquerda = true;
			if(!direita) {
				esquerda = true;
			}else {
				esquerda = false;
				direita = true;
			}
			cima = false;
			baixo = false;		
		}
		if (e.getKeyCode()== KeyEvent.VK_UP) {
			
			movimento++;
			cima = true;
			if(!baixo) {
				cima = true;
			}else {
				cima = false;
				baixo = true;
			}
			direita = false;
			esquerda = false;		
		}
		if (e.getKeyCode()== KeyEvent.VK_DOWN) {
			
			movimento++;
			baixo = true;
			if(!cima) {
				baixo = true;
			}else {
				cima = true;
				baixo = false;
			}
			direita = false;
			esquerda = false;		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

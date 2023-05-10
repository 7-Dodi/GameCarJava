package mygamecar.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import mygamecar.WindowGame;

public class FaseGame extends JPanel implements ActionListener{
	private Image background;
	private PlayerCar player;
	private Timer timer;
	private boolean inGame;
	private List<EnemyCar> enemy;
	SomGame music = new SomGame();
	
	public FaseGame() {
		setFocusable(true); 
		setDoubleBuffered(true);
		
		ImageIcon image = new ImageIcon("Imagens//FaseGameCar.jpg");
		background = image.getImage();
		inGame = true;
		
		player = new PlayerCar();
		player.load();
		
		addKeyListener(new TecladoAdpt());
		
		timer = new Timer(5, this);
		timer.start();
		
		playedEnemy();
		
		try {
			music.tocarAudio("MenuGame.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playedEnemy() {
		int[] coordenadas = new int[30];
		enemy = new ArrayList<EnemyCar>();
		
		for(int k = 0; k < coordenadas.length; k++) {
			int x = (int)( 30 + Math.random() * 300 + 30);
			int y = (int)(Math.random() * 15000 + 480);
			if(x <= 480 && x >= 20) {
				enemy.add(new EnemyCar(x+10, y));
			}else {
				while(x <= 400 && x >= 20) {
					x = (int)(30 + Math.random() * 500 + 30);
					y = (int)(Math.random() * 8000 + 480);
				}
				enemy.add(new EnemyCar(x+10, y));
			}
		}
	}
	
	public void paint (Graphics g) {
		Graphics2D grafic = (Graphics2D) g;
		if(inGame == true) {
			grafic.drawImage(background, 0, 0, null);
			grafic.drawImage(player.getPlayer(), player.getX(), player.getY(), this);
			
			for(int k = 0; k< enemy.size(); k++) {
				EnemyCar m = enemy.get(k);
				m.loadEnemy(k);
				grafic.drawImage(m.getEnemy(), m.getX(), m.getY(), this);
			}
		}else {
			ImageIcon gameOver = new ImageIcon("Imagens//2.jpg");
			grafic.drawImage(gameOver.getImage(), 0, 0, null);
			music.pararAudio();
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.movimented();
		
		for(int k = 0; k< enemy.size(); k++) {
			EnemyCar m = enemy.get(k);
			m.loadEnemy(k);
			if(m.isVisivel()) {
				m.movimented();
			}else {
				enemy.remove(k);
			}
		}
		
		checarColision();
		
		repaint();
	}
	
	public void checarColision () {
		Rectangle formaPlayer = player.getBounds();
		Rectangle formaEnemy;
		
		for(int k = 0; k < enemy.size(); k++) {
			EnemyCar tempEnemy = enemy.get(k);
			formaEnemy = tempEnemy.getBounds();
			if(formaPlayer.intersects(formaEnemy)) {
				player.setVisivel(false);
				tempEnemy.setVisivel(false);
				inGame = false;
			}
		}
	}
	
	private class TecladoAdpt extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}
}

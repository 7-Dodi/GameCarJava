package mygamecar.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PlayerCar {
	private int x, y;
	private int dx, dy;
	private int height, widht;
	private Image player;
	private boolean isVisivel;
	
	
	public PlayerCar() {
		this.x = 100;
		this.y = 100;
		this.isVisivel = true;
	}
	
	
	public void load() {
		ImageIcon image = new ImageIcon("Imagens//PlayerCarRed.png");
		player = image.getImage();
		
		height = player.getHeight(null);
		widht = player.getWidth(null);
		
		if(isVisivel == false) {
			ImageIcon image2 = new ImageIcon("Imagens//PlayerCarBlue.png");
			player = image2.getImage();
			
			height = player.getHeight(null);
			widht = player.getWidth(null);
		}
	}
	
	public void movimented () {
		x += dx;
		y += dy;
	}
	
	public void keyPressed (KeyEvent tecla) {
		int cody = tecla.getKeyCode();
		
		if(cody == KeyEvent.VK_UP) {
			dy = -5;
		}
		if(cody == KeyEvent.VK_DOWN) {
			dy = 5;
		}
		if(cody == KeyEvent.VK_LEFT) {
			dx = -5;
		}
		if(cody == KeyEvent.VK_RIGHT) {
			dx = 5;
		}
	}
	
	public void keyRelease (KeyEvent tecla) {
		int cody = tecla.getKeyCode();
		
		if(cody == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(cody == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(cody == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(cody == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, widht, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getPlayer() {
		return player;
	}

	public void setPlayer(Image player) {
		this.player = player;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	
}

package mygamecar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuGame extends JPanel{
	private Image background;
	
	public MenuGame() {
		ImageIcon image = new ImageIcon("Imagens//MenuGame.jpg");
		background = image.getImage();
	}
	
	public void paint (Graphics g) {
		Graphics2D grafic = (Graphics2D) g;
		grafic.drawImage(background, 0, 0, null);
		g.dispose();
	}
}

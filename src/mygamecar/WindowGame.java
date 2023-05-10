package mygamecar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import mygamecar.Modelo.FaseGame;
import mygamecar.Modelo.SomGame;

public class WindowGame extends JFrame{
	private static final int HEIGHT = 500;
	private static final int WIDHT = 500;
	private static final String NAME = "Street Race";
	SomGame music = new SomGame();
	
	public WindowGame() {
		add(new MenuGame());
		setTitle(NAME);
		setSize(HEIGHT, WIDHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
		addKeyListener(new TecladoAdapt());
		
		try {
			music.tocarAudio("MenuGame.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WindowGame(boolean value) {
		if(value == true) {
			add(new FaseGame());
			setTitle(NAME);
			setSize(HEIGHT, WIDHT);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			this.setResizable(false);
			setVisible(true);	
		}
	}
	
	private class TecladoAdapt extends KeyAdapter{
		@Override
		public void keyPressed (KeyEvent tecla){
			int cody = tecla.getKeyCode();
			if(cody == KeyEvent.VK_ENTER) {
				new WindowGame(true);
				music.pararAudio();
			}
		}
	}
	
	public static void main (String[] Args) {
		new WindowGame();
	}
}

package dynamic_beat_11;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x,y = 720-(1100/Main.SLEEP_TIME*Main.NOTE_SPEED)*Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x=260;
		}
		else if(noteType.equals("D")) {
			x=360;
		}
		else if(noteType.equals("F")) {
			x=460;
		}
		else if(noteType.equals("Space")) {
			x=560;
		}
		else if(noteType.equals("J")) {
			x=760;
		}
		else if(noteType.equals("K")) {
			x=860;
		}
		else if(noteType.equals("L")) {
			x=960;
		}
		this.noteType = noteType;
	}
	
	public void screenDarw(Graphics2D g) {
		if(!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		}
		else{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y>800) {
			System.out.println("Missed");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded){
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		if(y>= 760) {
			System.out.println("Bad");
			close();
			return "Bad";
		}
		else if(y>= 720) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y>= 710) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y>= 700) {
			System.out.println("Not Bad");
			close();
			return "Notbad";
		}
		else if(y>= 730) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y>= 800) {
			System.out.println("Missed");
			close();
			return "Missed";
		}
		return "None";
	}
	
	public int getY() {
		return y;
	}
}

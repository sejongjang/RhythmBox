package dynamic_beat_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.beans.Encoder;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLine = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		//gameMusic.start();
		//dropNotes(titleName);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 260, 30,  null);
		g.drawImage(noteRouteDImage, 360, 30,  null);
		g.drawImage(noteRouteFImage, 460, 30,  null);
		g.drawImage(noteRouteSpace1Image, 560, 30,  null);
		g.drawImage(noteRouteSpace2Image, 660, 30,  null);
		g.drawImage(noteRouteJImage, 760, 30,  null);
		g.drawImage(noteRouteKImage, 860, 30,  null);
		g.drawImage(noteRouteLImage, 960, 30,  null);
		g.drawImage(noteRouteLineImage, 258, 30,  null);
		g.drawImage(noteRouteLineImage, 358, 30,  null);
		g.drawImage(noteRouteLineImage, 458, 30,  null);
		g.drawImage(noteRouteLineImage, 558, 30,  null);
		g.drawImage(noteRouteLineImage, 758, 30,  null);
		g.drawImage(noteRouteLineImage, 858, 30,  null);
		g.drawImage(noteRouteLineImage, 958, 30,  null);
		g.drawImage(noteRouteLineImage, 1058, 30,  null);
		
		g.drawImage(gameInfoImage, 0, 800,  null);
		g.drawImage(judgementLine, 0, 720,  null);

		for(int i=0; i<noteList.size(); ++i) {
			Note note = noteList.get(i);
			if(note.getY() > 800) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMissed.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDarw(g);	
			}
		}
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 300, 750);
		g.drawString("D", 400, 750);
		g.drawString("F", 500, 750);
		g.drawString("Space", 620, 747);
		g.drawString("J", 800, 750);
		g.drawString("K", 900, 750);
		g.drawString("L", 1000, 750);
		g.drawString(titleName, 20, 840);
		g.drawString(difficulty, 1190, 840);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 840);
		//g.drawImage(blueFlareImage, 470, 480,  null);
		g.drawImage(judgeImage, 500, 430,  null);
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum01.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum02.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum04.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum03.mp3",false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum05.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum06.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drum07.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("prelude-thefatrat") && difficulty.equals("Easy")){
			int startTime = 4400 - Main.REACH_TIME*1000;
			int gap = 500;
			beats = new Beat[] {
					new Beat(startTime + gap * 1, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 4, "D"),
					new Beat(startTime + gap * 5, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 7, "F"),
					new Beat(startTime + gap * 8, "Space"),
					new Beat(startTime + gap * 9, "J"),
					new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 11, "L"),
					new Beat(startTime + gap * 12, "K"),
					new Beat(startTime + gap * 13, "Space"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 15, "F"),
					new Beat(startTime + gap * 16, "S"),
					new Beat(startTime + gap * 17, "D"),
					new Beat(startTime + gap * 18, "L"),
					new Beat(startTime + gap * 19, "L"),
					new Beat(startTime + gap * 20, "L"),
					new Beat(startTime + gap * 21, "L"),
					new Beat(startTime + gap * 22, "L"),
					new Beat(startTime + gap * 23, "L"),
					new Beat(startTime + gap * 24, "L"),
					new Beat(startTime + gap * 25, "L"),
					new Beat(startTime + gap * 26, "L"),
					new Beat(startTime + gap * 27, "L"),
					new Beat(startTime + gap * 28, "L"),
					new Beat(startTime + gap * 29, "L"),
					new Beat(startTime + gap * 30, "L"),
					new Beat(startTime + gap * 31, "L"),
					new Beat(startTime + gap * 32, "L"),
					new Beat(startTime + gap * 33, "L"),
					new Beat(startTime + gap * 34, "S"),
					new Beat(startTime + gap * 35, "D"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 37, "D"),
					new Beat(startTime + gap * 38, "S"),
					new Beat(startTime + gap * 39, "D"),
					new Beat(startTime + gap * 40, "F"),
					new Beat(startTime + gap * 41, "Space"),
					new Beat(startTime + gap * 42, "J"),
					new Beat(startTime + gap * 43, "K"),
					new Beat(startTime + gap * 44, "L"),
					new Beat(startTime + gap * 45, "K"),
					new Beat(startTime + gap * 46, "Space"),
					new Beat(startTime + gap * 47, "D"),
					new Beat(startTime + gap * 48, "F"),
					new Beat(startTime + gap * 49, "S"),
					new Beat(startTime + gap * 50, "D"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 52, "L"),
					new Beat(startTime + gap * 53, "L"),
					new Beat(startTime + gap * 54, "L"),
					new Beat(startTime + gap * 55, "L"),
					new Beat(startTime + gap * 56, "L"),
					new Beat(startTime + gap * 57, "L"),
					new Beat(startTime + gap * 58, "L"),
					new Beat(startTime + gap * 59, "L"),
					new Beat(startTime + gap * 60, "L"),
					new Beat(startTime + gap * 61, "L"),
					new Beat(startTime + gap * 62, "L"),
					new Beat(startTime + gap * 63, "L"),
					new Beat(startTime + gap * 64, "L"),
					new Beat(startTime + gap * 65, "L"),
					new Beat(startTime + gap * 66, "L"),
					
			};
		}
		else if(titleName.equals("prelude-thefatrat") && difficulty.equals("Hard")){
			int startTime = 4400 - Main.REACH_TIME*1000;
			int gap = 200;
			
			beats = new Beat[] {
					new Beat(startTime + gap * 1, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 4, "D"),
					new Beat(startTime + gap * 5, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 7, "F"),
			};
		}
		else if(titleName.equals("DANCING NAKED-THEFATRAT")&& difficulty.equals("Easy")) {
			int startTime = 4400 - Main.REACH_TIME*1000;
			int gap = 350;
			String[] input = new String[7];
			input[0] = "S";
			input[1] = "D";
			input[2] = "F";
			input[3] = "Space";
			input[4] = "J";
			input[5] = "K";
			input[6] = "L";
			
			beats = new Beat[] {
					
					new Beat(startTime + gap * 1, "S"),
					
				
			};
		}else if(titleName.equals("DANCING NAKED-THEFATRAT")&& difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
		}
		else if(titleName.equals("OBLIVION -THEFATRAT")&& difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
		}
		else if(titleName.equals("OBLIVION -THEFATRAT")&& difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
		}
		
		int i =0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped =false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i=0; i<noteList.size(); ++i) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Missed")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMissed.png")).getImage();
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		else if(judge.equals("Notbad")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeNotbad.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		else if(judge.equals("Bad")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeBad.png")).getImage();
		}
	}
}

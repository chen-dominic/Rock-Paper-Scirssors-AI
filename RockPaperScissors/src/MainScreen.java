import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainScreen implements ActionListener {
	JFrame frame;
	JPanel panel;
	
	JButton rock;
	JButton paper;
	JButton scissors;
	JButton reset;
	JButton exit;
	
	JLabel title;
	JLabel lost;
	JLabel won;
	
	public static int aiSelection;
	
	public MainScreen() {
		frame = new JFrame("RPS");
		frame.setSize(1920,1080);
		frame.setBounds(0,0,1920,1080);
		frame.setUndecorated(true);
		
		panel = new JPanel();
		panel.setSize(1920,1080);
		panel.setBounds(0,0,1920,1080);
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		frame.add(panel);
		
		rock = new JButton("Rock!");
		rock.setBounds(252,620,150,100);
		rock.setFocusable(false);
		rock.addActionListener(this);
		rock.setFont(new Font("Sans Serif", Font.BOLD, 20));
		panel.add(rock);
		
		paper = new JButton("Paper!");
		paper.setBounds(885,620,150,100);
		paper.setFocusable(false);
		paper.addActionListener(this);
		paper.setFont(new Font("Sans Serif", Font.BOLD, 20));
		panel.add(paper);
		
		scissors = new JButton("Scissors!");
		scissors.setBounds(1513,620,150,100);
		scissors.setFocusable(false);
		scissors.addActionListener(this);
		scissors.setFont(new Font("Sans Serif", Font.BOLD, 20));
		panel.add(scissors);
		
		reset = new JButton("Reset");
		reset.setBounds(1712,60,150,50);
		reset.setFocusable(false);
		reset.addActionListener(this);
		reset.setBackground(Color.RED);
		reset.setFont(new Font("Sans Serif", Font.BOLD, 20));
		panel.add(reset);
		
		exit = new JButton("Exit");
		exit.setBounds(67,60,150,50);
		exit.setFocusable(false);
		exit.addActionListener(this);
		exit.setBackground(Color.RED);
		exit.setFont(new Font("Sans Serif", Font.BOLD, 20));
		panel.add(exit);
		
		title = new JLabel("Rock Paper Scissors!");
		title.setBounds(760,110,615,60);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		aiSelection = aiSelect();
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private int aiSelect() {
		Random rand = new Random();
		int select = rand.nextInt(3);
		
		return select;
	}
	
	public void actionPerformed(ActionEvent e) {
		int user = 0;
		boolean win = false;
		boolean draw = false;
		String aiChoice = "";
		String[] choices = {"ROCK","PAPER","SCISSORS"};
		aiChoice = choices[aiSelection];
		
		if(e.getSource() == exit) {
			frame.dispose();
		}
		
		if(e.getSource() == rock) {
			user = 0;
			draw = user == aiSelection;
			if(aiSelection == 2) {
				win = true;
			}
		}
		
		if(e.getSource() == paper) {
			user = 1;
			draw = user == aiSelection;
			if(aiSelection == 0) {
				win = true;
			}
		}
		
		if(e.getSource() == scissors) {
			user = 2;
			draw = user == aiSelection;
			if(aiSelection == 1) {
				win = true;
			}
		}
		
		if(draw) {
			title.setText("AI CHOSE " + aiChoice + "! YOU DREW");
		}
		else if(win) {
			title.setText("AI CHOSE " + aiChoice + "! YOU WIN");
		}
		else {
			title.setText("AI CHOSE " + aiChoice + "! YOU LOST");
		}
		
		win = false;
		draw = false;
		aiSelection = aiSelect();
		
		if(e.getSource() == reset) {
			user = 0;
			title.setText("Rock Paper Scissors!");
		}
		
	}
}

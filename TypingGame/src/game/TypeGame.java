package game;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypeGame extends KeyAdapter {
	private static int INTERVAL = 1000;
	private static final int MAX = 10;
	private static int MAX_CHARACTER = 200;
	private static ArrayList<Character> charList;
	private static JLabel charLabel;
	private static JTextField typingArea;

	public TypeGame() {
		charList = new ArrayList<Character>();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		charLabel = new JLabel("Characters");
		typingArea = new JTextField(70);
		
		panel.add(charLabel);
		panel.add(typingArea);
		frame.add(panel, BorderLayout.CENTER);

		typingArea.addKeyListener(this);
		
		frame.setSize(300, 300);
		frame.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		char karakteri = e.getKeyChar();
		
		if (charList.contains(karakteri)) {
			charList.remove((Character) karakteri);
		}

		System.out.println(charList);
	}

	public static class TimerListener implements ActionListener {
		int counter = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			charList.add((char) ('a' + (int) (Math.random() * 26)));
			counter++;
			
			System.out.println(charList);
			
			charLabel.setText(charList.toString());
			
			if (charList.size() > MAX) {
				System.out.println("Game lost!");
				System.exit(0);
			}
			if (counter >= MAX_CHARACTER) {
				System.out.println("You won the game!");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new TypeGame();
		Timer timer = new Timer(INTERVAL, new TimerListener());
		timer.start();
	}

}

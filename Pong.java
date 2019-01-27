package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

@SuppressWarnings("serial")
public class Pong extends Applet implements Runnable, KeyListener {

	/**
	 * 
	 */
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	HumanPaddle2 p2;
	AIPaddle p3;
	Ball b1;

	public static int p1Score = 0;
	public static int p2Score = 0;

	public void init() {
		// instantiation of the ball from the ball class, the both paddles and a java
		// applet window and guess what? It works.
		this.resize(WIDTH, HEIGHT);

		this.addKeyListener(this);
		p1 = new HumanPaddle(1); // if HumanPaddle(1) --> Human player on the left side, f HumanPaddle(2) -->
		p2 = new HumanPaddle2(2); // Human player on the right side

		b1 = new Ball();

		thread = new Thread(this);
		thread.start();

	}

	public void paint(Graphics g) {

		g.setColor(Color.darkGray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		p1.draw(g);
		p2.draw(g);
		b1.draw(g);

		g.setColor(Color.white);
		g.drawString(String.valueOf(p1Score), 300, 30);
		g.drawString(String.valueOf(p2Score), 400, 30);
		// for corner score view use the code below:
//		 g.drawString(String.valueOf(p1Score), 25, 25);
//		 g.drawString(String.valueOf(p2Score), 125, 25);

	}

	public void update(Graphics g) {
		paint(g);

	}

	public void run() {

		while (true) {
			b1.CollisionChecker(p1, p2);
			p1.move();
			p2.move();
			b1.move();
			scorer();
			repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("static-access")
	public void scorer() {

		if (b1.x < 20) {

			b1.x = 350;
			b1.y = 250;
			b1.yVel = b1.reverse(b1.yVel);
			b1.xVel = b1.reverse(b1.xVel);
			++p2Score;

		}

		// p1 scores a point
		if (b1.x > 680) {

			b1.x = 350;
			b1.y = 250;
			b1.xVel = b1.reverse(b1.xVel);
			++p1Score;

		}
	}
	// }

	// The KeyListener..............................
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p2.setUpAccel(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p2.setDownAccel(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			p2.setUpAccel(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			p2.setDownAccel(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpAccel(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			p1.setDownAccel(true);

		}
	}

	// Still the KeyListener
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpAccel(false);
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			p1.setDownAccel(false);
		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			p2.setUpAccel(false);

		}

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			p2.setDownAccel(false);

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p2.setUpAccel(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p2.setDownAccel(false);
		}

	}

	public void keyTyped(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}

	}

}

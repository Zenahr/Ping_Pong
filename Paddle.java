package pong;

import java.awt.Graphics;

public interface Paddle {

	public void draw(Graphics g) throws InterruptedException;
	public void move();
	public float getY();
}



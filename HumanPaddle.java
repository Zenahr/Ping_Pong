package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class HumanPaddle implements Paddle {
	float y, yVel;
	boolean upAccel, downAccel;
	 int player, x;
	final double GRAVITY = 0.94;
	public int collisionCount = 0;
	 long timeStamp0, timeStamp1, timeElapsed;
	int blinkDuration = 2100;

	Color[] colors = { Color.red, Color.blue, Color.orange, Color.green };

	Thread thread;

	
	public HumanPaddle(int player) {
		upAccel = false;
		downAccel = false;
		y = 210;
		yVel = 0;
		if (player == 1) // first player
			x = 0;
		else if (player == 2)
			x = 680;
		
		
		
		
	}

	public void draw(Graphics g) {

		// Color ownPurple = new Color(100, 0, 200);
		// Color ownOrange = new Color(255, 165, 0);
		g.setColor(Color.white);
		g.fillRect(x, (int) y, 20, 90);
		
		if(Pong.p1Score == 10 || Pong.p1Score == 20 || Pong.p1Score % 10 == 0) {
			
			
			timeStamp0 = System.currentTimeMillis();
			System.out.println("TRUE");
		}

		
		if (Pong.p1Score == 10 && timeElapsed < blinkDuration || Pong.p1Score % 10 == 0 && timeElapsed < blinkDuration && Pong.p1Score != 0) {
			
			
			int myOwnIndex = (int) (Math.random() * 4);
			g.setColor(colors[myOwnIndex]);
			g.fillRect(x, (int) y, 20, 90);

			timeStamp1 = System.currentTimeMillis();
			timeElapsed = timeStamp1 - timeStamp0;
			System.out.println(timeElapsed);
			timeStamp0 = 0;
		}

	}

	public void move() {
		if (upAccel) {
			yVel -= 2;

		} else if (downAccel) {
			yVel += 2;
		} else if (!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		if (yVel >= 5) {
			yVel = 5;
		}

		else if (yVel <= -5)
			yVel = -5;

		y += yVel;

		if (y < 0)
			y = 0;

		if (y > 415)
			y = 415;

	}

	public void setUpAccel(boolean input) {
		upAccel = input;
	}

	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	public float getYP1() {
		return (int) y;

	}

	public int getXP1() {
		return (int) x;
	}

	@Override
	public float getY() {
		return y;
	}
}

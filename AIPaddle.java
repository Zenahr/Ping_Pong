package pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {
	float y;
	int yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.94;
	private Ball b1; //is needed by the methods of this class.

	public AIPaddle(int player, Ball ball) {
		b1 = ball;
		upAccel = false;
		downAccel = false;
		y = 210;
		yVel = 0;
		if (player == 1) // first player
			x = 20;
		else if (player == 2)
			x = 680;
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, (int) y, 20, 80);
	}

	public void move() {
		y =b1.getY()-40;
//		System.out.println(y);
		
		
		if (y < 5) {
			y = 5;
		}

		if (y > 415) {
			y = 415;
		}

	}

	@Override
	public float getY() {
		return 0;
	}
	
	

}

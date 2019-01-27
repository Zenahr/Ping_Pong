package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.security.acl.Owner;

public class Ball {

	double xVel, yVel;
	float x, y;
	double maximizer = 1.04;
	int limit = 7; // IST BIS CA 50 KALKULIERBAR
	

	public Ball() {



//		x = 320;
//		y = 250;
//		xVel = 20;
//		yVel = 10;
		
		x = 320;
		y = 250;
		xVel = 2;
		yVel = 3;
	}

	public static double reverse(double d) {

		return d = d * -1;

	}

	public void draw(Graphics g) {
		Color ownOrange = new Color(255, 165, 0);
		Color ownPurple = new Color(100, 0, 200);
		g.setColor(ownOrange);
		g.fillOval((int) x - 10, (int) y - 10, 20, 20);
		// g.fillRect((int) x - 10, (int) y - 10, 20, 20);
	}

	public void CollisionChecker(Paddle p1, Paddle p2) {

		if (x <= 30 && y >= p1.getY() && y <= p1.getY() + 80) {
			xVel = reverse(xVel);

			if (xVel < limit) {
				xVel *= maximizer;
			}

			else 
				xVel = limit;
			

		}

		if (x >= 670 && y >= p2.getY() && y <= p2.getY() + 80) { // wheras 80=lenght of the paddle
			xVel = reverse(xVel);

			if (xVel < limit) {
				xVel *= maximizer;

			}
		}
	}

	public void move() {
		x += xVel;
		y += yVel;
//		if (x < 19 || x > 700) {
//
//		}

		if (y < 10 || y > 490) {
			yVel = reverse(yVel);
		}

	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}

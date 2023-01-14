package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
    // 1. make a main method
	public static void main(String[] args) {
		
	
        // 2. create an array of 5 robots.
		Robot test = new Robot();
		test.setSpeed(50);
		test.moveTo(200, 275);
		Random ff = new Random();
		int fff = ff.nextInt(50);
		int turn = 0;
		//for(int i=0;i<500;i++) {
		test.move(fff);
		turn = turn + fff;
		if(turn > 25) {
			test.turn(10);
			turn = 0;
		//	}
		}
		
		Robot[] ZKK = new Robot[5];
        // 3. use a for loop to initialize the robots.
		int robx = 50;
		for(int i=0;i<5;i++) {
			ZKK[i] = new Robot();
			ZKK[i].setSpeed(50);
			ZKK[i].moveTo(200, 275);
			robx = robx + 100;
		}
        // 4. make each robot start at the bottom of the screen, side by side, facing up
		//KK
		// 5. use another for loop to iterate through the array and make each robot move
        // a random amount less than 50.
		Random rand = new Random();
		int[] turnn = new int[5];
		int one = 275;
		int win = 0;
		while(one < 280) {
		for(int i=0;i<5;i++) {
			turnn[i] = 0;
			int LKK = rand.nextInt(50);
			ZKK[i].move(LKK);
			turnn[i] = turnn[i] + LKK;
			if(turnn[i] > 25) {
				ZKK[i].turn(10);
				turnn[i] = 0;
				}
			int CKK = ZKK[i].getY();
			if(one > CKK) {
				one = CKK;
				win = i+1;
			}
		}
		}
        // 6. use a while loop to repeat step 5 until a robot has reached the top of the
        // screen.
		//AAAA
        // 7. declare that robot the winner and throw it a party!
		JOptionPane.showMessageDialog(null, "robot " + win + " is winner");
        // 8. try different races with different amounts of robots.
		
        // 9. make the robots race around a circular track.
		
	}
}

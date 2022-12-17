import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class platform2 extends JPanel implements ActionListener, KeyListener{
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 600;
	
	boolean lvl1 = true;
	boolean lvl2 = false;
	boolean lvl3 = false;
	boolean lvl4 = false;
	
	JFrame window;
	Timer timer;
	
	Player p1 = new Player(50, 50, 100, 100);
	
	ArrayList<Platform> platforms = new ArrayList<Platform>();
	ArrayList<button> buttons = new ArrayList<button>();
	
	public static void main(String[] args) {
		new platform2().lvl1();
	}
	
	public void lvl1(){
		window = new JFrame("1");
		window.addKeyListener(this);
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		timer = new Timer(1000 / 60, this);
		
		
		platforms.add(new Platform(300, 450, 200, 50));
		platforms.add(new Platform(500, 350, 200, 50));
		platforms.add(new Platform(300, 250, 200, 50));
		platforms.add(new Platform(100, 150, 200, 50));
		
		buttons.add(new button(180,130,40,20));
		
		timer.start();
		
	}
	
	public void lvl2(){
		window = new JFrame("2");
		window.addKeyListener(this);
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		timer = new Timer(1000 / 60, this);
		
		
		platforms.add(new Platform(30, 450, 200, 50));
		platforms.add(new Platform(50, 350, 200, 50));
		platforms.add(new Platform(30, 250, 200, 50));
		platforms.add(new Platform(10, 150, 200, 50));
		
		buttons.add(new button(280,130,40,20));
		
		timer.start();
		
	}
	
	public void lvl3(){
		window = new JFrame("3");
		window.addKeyListener(this);
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		timer = new Timer(1000 / 60, this);
		
		
		platforms.add(new Platform(300, 400, 200, 50));
		platforms.add(new Platform(500, 400, 200, 50));
		platforms.add(new Platform(300, 400, 200, 50));
		platforms.add(new Platform(100, 400, 200, 50));
		
		buttons.add(new button(180,130,40,20));
		
		timer.start();
		
	}
	
	public void lvl4(){
		window = new JFrame("4");
		window.addKeyListener(this);
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		timer = new Timer(1000 / 60, this);
		
		
		platforms.add(new Platform(300, 200, 200, 50));
		platforms.add(new Platform(500, 200, 200, 50));
		platforms.add(new Platform(300, 200, 200, 50));
		platforms.add(new Platform(100, 200, 200, 50));
		
		buttons.add(new button(180,130,40,20));
		
		timer.start();
		
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		p1.draw(g);
		
		for(Platform p : platforms){
			p.draw(g);
		}
		for(button p : buttons){
			p.draw(g);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		checkCollision();
		
		p1.update();
		
		for(Platform p : platforms){
			p.update();
		}
		for(button p : buttons){
			p.update();
		}
		
		repaint();
		
	}
	
	private boolean checkCollision(){
		for(Platform p: platforms){
			if(p1.getCBox().intersects(p.getCBox())){
				handleCollision(p);
				return true;
			}
		}
		for(button p: buttons){
			if(p1.getCBox().intersects(p.getCBox())){
				handleCollision2(p);
				return true;				
			}
		}
		
		p1.setYLimit(500);
		return false;
	}
	
	private void handleCollision(Platform p){
		if(p1.getYVelocity() >= 0 && p1.getY() + p1.getHeight() < p.getY() + 25){
			p1.setYLimit(p.getY() - p1.getHeight());
		}else{
			p1.setYLimit(500);
		}
	}
	
	private void handleCollision2(button p){
		if(p1.getYVelocity() >= 0 && p1.getY() + p1.getHeight() < p.getY() + 25){
			p1.setYLimit(p.getY() - p1.getHeight());
		}else{
			p1.setYLimit(500);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_E) {
		for(button p: buttons){
			if(p1.getCBox().intersects(p.getCBox())){
				//timer.stop();
								
				if(lvl1 == true) {
				new platform2().lvl2();
				lvl1 = false;
				lvl2 = true;
				}
				if(lvl2 == true) {
				new platform2().lvl3();
				lvl2 = false;
				lvl3 = true;
				}
				if(lvl3 == true) {
				new platform2().lvl4();
				lvl3 = false;
				lvl4 = true;
				}
				
			}
		}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A){
			p1.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			p1.right = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			p1.jump();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W){
			p1.tech();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_A){
			p1.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			p1.right = false;
		}
	}
}

class Platform{
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Rectangle cBox = new Rectangle();
	
	public Platform(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		cBox.setBounds(x, y, width, height);
	}
	
	public void update(){
		cBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getCBox(){
		return cBox;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}

class button{
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Rectangle cBox = new Rectangle();
	
	public button(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		cBox.setBounds(x, y, width, height);
	}
	
	public void update(){
		cBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getCBox(){
		return cBox;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}

class Player{
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Rectangle cBox = new Rectangle();
	
	public boolean left = false;
	public boolean right = false;
	
	private int xVelocity = 5;
	
	private int gravity = 1;
	private int yVelocity = 0;
	private int jumpPower = 20;
	
	private int yLimit = 500;

	boolean canJump = false;
	
	public Player(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		cBox.setBounds(x, y, width, height);
	}
	
	public void jump(){
		boolean jump2 = false;
		if(canJump){
			yVelocity -= jumpPower;
			jump2 = true;
			if(jump2 == true) {
			//dyVelocity -= jumpPower;
			canJump = false;
			}
		}
	}
	
	public void tech() {
		y = y - 100;
	}
	
	public void adios() {
		y = y - 1000;
	}
	
	public void update(){
		if(left){
			x -= xVelocity;
		}
		if(right){
			x += xVelocity;
		}
		
		yVelocity += gravity;
		y += yVelocity;
		
		if(y >= yLimit + 1){
			y = yLimit + 1;
			yVelocity = 0;
			canJump = true;
		}
		
		cBox.setBounds(x, y, width, height);
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
	}
	
	public Rectangle getCBox(){
		return cBox;
	}
	
	public void setYLimit(int l){
		yLimit = l;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getYVelocity(){
		return yVelocity;
	}
}
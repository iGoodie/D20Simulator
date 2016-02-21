package main;

import gamefeels.ScreenShake;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class DiceSimulation extends PApplet
{
	public void settings()
	{
		size(600, 600);
	}
	
	ScreenShake s;
	public void setup()
	{
		surface.setResizable(true);
		surface.setTitle("D20 Simulation");
		s=new ScreenShake(this);
		dice=new Dice(this);
		imageMode(CENTER);
		textAlign(CENTER, CENTER);
		textSize(25);
	}
	
	Dice dice;
	public void draw()
	{
		background(127);
		stroke(0, 127);
		s.shake();
		for(int i=-width; i<2*width; i+=5) line(i, -width, i, 2*height);
		for(int i=-height; i<2*height; i+=5) line(-height, i, 2*width, i);

		if(s.isShaking()) dice.setRandom();
		dice.setPosition();
		dice.drawDice();
		
	}
	
	public void keyPressed(KeyEvent event) 
	{
		if(key==' ') s.create((int)Math.sqrt(width*width+height*height)*0.008f, 50, 35, 20);
	}
	
	public static void main(String[] args) 
	{
		PApplet.main(new String[]{"main.DiceSimulation"});
	}
}

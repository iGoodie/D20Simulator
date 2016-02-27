package main;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import util.RenderingUtils;

public class Dice 
{
	PApplet p;
	
	PVector pos;
	
	int values[] = new int[10];
	PImage dice;
	
	public Dice(PApplet parent)
	{
		p=parent;
		pos=new PVector(p.width/2, p.height/2);
		dice=p.loadImage("res/dice1.png");
		dice.resize(150, 150);
		setRandom();
		
		color = p.color(r.nextInt(192-64)+64, r.nextInt(192-64)+64, r.nextInt(192-64)+64);
	}
	
	Random r = new Random();
	public void setRandom()
	{
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i=1; i<=20; i++) nums.add(i);
		for(int i=0; i<10; i++)
		{
			int rand = r.nextInt(nums.size());
			values[i] = nums.get(rand);
			nums.remove(rand);
		}
		setRandomColor();
	}
	
	public void setRandomColor()
	{
		color = p.color(r.nextInt(192-64)+64, r.nextInt(192-64)+64, r.nextInt(192-64)+64);
	}
	
	public void setPosition()
	{
		pos.set(p.width/2, p.height/2);
	}
	
	int color;
	public void drawDice()
	{		
		p.pushStyle();
		{
			p.tint(color);
			p.image(dice, pos.x, pos.y);
			RenderingUtils.textWithStroke(p, values[0]+"", (int)pos.x, (int)pos.y, p.color(60, 0, 0), 4);
			for(int i=0; i<3; i++)
			{
				p.textSize(22);
				p.pushMatrix();
				{
					p.translate(p.width/2, p.height/2);
					p.rotate(i*PApplet.TWO_PI/3f);
					p.scale(1, 0.9f);
					p.translate(-p.width/2, -p.height/2);
					RenderingUtils.textWithStroke(p, values[i+1]+"", (int)pos.x, (int)pos.y-48, p.color(60, 0, 0), 3);
				}
				p.popMatrix();
				p.textSize(11);
				p.pushMatrix();
				{
					p.translate(p.width/2, p.height/2);
					p.rotate(i*PApplet.TWO_PI/3f+PApplet.TWO_PI/9f);
					p.scale(1, 0.9f);
					//p.shearX(-0.1f);
					p.translate(-p.width/2, -p.height/2);
					RenderingUtils.textWithStroke(p, values[i+4]+"", (int)pos.x, (int)pos.y-64, p.color(60, 0, 0), 2);
				}
				p.popMatrix();
				p.pushMatrix();
				{
					p.translate(p.width/2, p.height/2);
					p.rotate(i*PApplet.TWO_PI/3f+2*PApplet.TWO_PI/9f);
					p.scale(1, 0.9f);
					//p.shearX(-0.1f);
					p.translate(-p.width/2, -p.height/2);
					RenderingUtils.textWithStroke(p, values[i+7]+"", (int)pos.x, (int)pos.y-64, p.color(60, 0, 0), 2);
				}
				p.popMatrix();
			}
		}
		p.popStyle();
	}
}

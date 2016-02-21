package util;

import processing.core.PApplet;

public class RenderingUtils 
{
	public static void textWithStroke(PApplet p, String s, int x, int y, int foreground, float rad)
	{
		p.pushStyle();
		{
			p.fill(0);
			for(int i=(int) -rad; i<=rad; i++) for(int j=(int) -rad; j<=rad; j++) if(i*i+j*j<=rad*rad)
				p.text(s, x+i, y+j);
			
			p.fill(255);
			p.text(s, x, y);
		}
		p.popStyle();
	}
	
	public static void textWithStroke(PApplet p, String s, int x, int y, int foreground)
	{
		p.pushStyle();
		{
			p.fill(0);
			float rad = 2;
			for(int i=(int) -rad; i<=rad; i++) for(int j=(int) -rad; j<=rad; j++) if(i*i+j*j<=rad*rad)
				p.text(s, x+i, y+j);
			
			p.fill(255);
			p.text(s, x, y);
		}
		p.popStyle();
	}
}

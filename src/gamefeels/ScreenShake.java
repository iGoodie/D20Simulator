package gamefeels;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScreenShake 
{
	PApplet p;
	ArrayList<ScreenShakeElement> element = new ArrayList<ScreenShakeElement>();;

	public ScreenShake(PApplet parent)
	{
		p = parent;
	}
	
	public void create(float intensity, int duration, int diff, int repeats) 
	{
		clean();
		int now=p.millis();
		for(int i=0; i<repeats; i++) element.add(new ScreenShakeElement(p, now+(i*diff), duration, intensity));
	}
	
	public void shake() 
	{
		clean();
		for (int i=0; i<element.size(); i++) if (element.get(i).isShaking()) 
		{
			int duration=element.get(i).duration;
			int spawn=element.get(i).spawn;
			float x=element.get(i).x;
			float y=element.get(i).y;

			float power=(duration/2-PApplet.abs((p.millis()-spawn)-duration/2))/(float)(duration)*2;
			p.translate(x*power, y*power);
		}
	}
	
	public void clean() 
	{
		for (int i=element.size()-1; i>=0; i--) if (element.get(i).isDead()) element.remove(i);
	}
	
	public boolean isShaking()
	{
		clean();
		return element.size()!=0;
	}
}

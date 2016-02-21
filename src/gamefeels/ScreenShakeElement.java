package gamefeels;

import processing.core.PApplet;
import processing.core.PVector;

class ScreenShakeElement 
{
	PApplet p;
	int spawn, duration;
	float x, y;

	public ScreenShakeElement(PApplet parent, int spawn, int duration, float intensity) 
	{
		p=parent;
		this.spawn=spawn;
		this.duration=duration;
		PVector vec=PVector.random2D().setMag(intensity);
		this.x=vec.x;
		this.y=vec.y;
	}
	
	public boolean isDead() 
	{
		return (spawn+duration<=p.millis());
	}
	
	public boolean isShaking() 
	{
		return (spawn<=p.millis() && p.millis()<=spawn+duration);
	}
}
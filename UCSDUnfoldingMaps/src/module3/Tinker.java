package module3;

import processing.core.PApplet;
import processing.core.PImage;

public class Tinker extends PApplet {
	private PImage backgroundImage;
	private String backgroundPath;

	public void setup() {
//		size of the window
		size(1200, 1200);
		
//		set up bacground image
		backgroundImage = loadImage("res/Images/TaipeiStreet.gif", "gif");

	}

	public void draw() {
		backgroundImage.resize(0, height);
		image(backgroundImage, 0, 0);

	}

}

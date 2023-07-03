package module3;

import processing.core.PApplet;
import processing.core.PImage;

public class Tinker extends PApplet {
	private PImage backgroundImage;
	private String backgroundPath;

	public void setup() {

		size(600, 600);
//		backgroundPath = "D:\\School Stuff\\Computer Science\\Object-oriented-programming-java\\UCSDUnfoldingMaps\\src\\module3\\TaipeiStreet.gif";
//		backgroundPath2 = "res/Images/TaipeiStreet2.jpg";
		backgroundPath = "res/Images/TaipeiStreet.gif";
		backgroundImage = loadImage(backgroundPath, "gif");

	}

	public void draw() {
		backgroundImage.resize(0, height);
		image(backgroundImage, 0, 0);

	}

}

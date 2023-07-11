package createMarker;

import de.fhpotsdam.unfolding.marker.AbstractMarker;
import de.fhpotsdam.unfolding.geo.Location;
import processing.core.PGraphics;
import processing.core.PImage;

public class ImageMarker extends AbstractMarker{
	private PImage sourceImage;
	
	public ImageMarker(Location location, PImage sourceImage){
		super(location);
		this.sourceImage = sourceImage;
	}

@Override
	public void draw(PGraphics pg, float x , float y) {
//		x and y are calculated internally by the unfoldingmap library based on
//		the location provided. 
		pg.pushStyle();
//      Move the upper left corner so that the marker's bottom middle is placed at the exact coordinate
		pg.image(sourceImage, x - sourceImage.width / 2 , y - sourceImage.height);
		pg.popStyle();
		
	}

@Override
	protected boolean isInside(float checkX, float checkY, float x, float y) {
		return checkX > x && checkX < x + sourceImage.width && checkY > y && checkY < y + sourceImage.height;
	}

}

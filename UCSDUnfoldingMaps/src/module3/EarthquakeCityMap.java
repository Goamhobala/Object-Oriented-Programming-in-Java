package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Customised marker library
import createMarker.ImageMarker;

//Parsing library
import parsing.ParseFeed;


/**
 * EarthquakeCityMap An application with an interactive map displaying
 * earthquake data. Author: UC San Diego Intermediate Software Development MOOC
 * team
 * 
 * @author Your name here Date: July 17, 2015
 */
public class EarthquakeCityMap extends PApplet {

	// You can ignore this. It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = true;

	// Less than this threshold is a light earthquake
	public static final double THRESHOLD_MODERATE = 5.5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/**
	 * This is where to find the local tiles, for working without an Internet
	 * connection
	 */
	public static String mbTilesString = "blankLight-1-3.mbtiles";

	// The map
	private UnfoldingMap map;

	// feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";
	private PImage backgroundImg;
	private PImage markerImgLight = loadImage("res/images/earthquakeMarkerLightSmall.png");
	private PImage markerImgModerate = loadImage("res/images/earthquakeMarkerModerateSmall.png");
	private PImage markerImgStrong = loadImage("res/images/earthquakeMarkerStrongSmall.png");
	private PImage markerImgLightKey = loadImage("res/images/earthquakeMarkerLightKey.png");
	private PImage markerImgModerateKey = loadImage("res/images/earthquakeMarkerModerateKey.png");
	private PImage markerImgStrongKey = loadImage("res/images/earthquakeMarkerStrongKey.png");
	private PFont pixelFont;
	
	public void setup() {
		size(950, 600, OPENGL);
		
		// Load images and fonts
		pixelFont = createFont("res/fonts/Pixeltype.ttf", 32);
		textFont(pixelFont);
		
		
		if (offline) {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
			earthquakesURL = "2.5_week.atom"; // Same feed, saved Aug 7, 2015, for working offline
		} else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			// earthquakesURL = "2.5_week.atom";
		}
	

		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);

		// The List you will populate with new SimplePointMarkers
		List<Marker> markers = new ArrayList<Marker>();

		// Use provided parser to collect properties for each earthquake
		// PointFeatures have a getLocation method
		List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
		
		// TODO (Step 3): Add a loop here that calls createMarker (see below)
		// to create a new SimplePointMarker for each PointFeature in
		// earthquakes. Then add each new SimplePointMarker to the
		// List markers (so that it will be added to the map in the line below)
		for (PointFeature earthquake : earthquakes) {
			markers.add((Marker) createImgMarker(earthquake));
		}
		
		// background
		backgroundImg = loadImage("res/Images/TaipeiStreet.gif", "gif");
		backgroundImg.resize(width, 0);
		
		


		// Add the markers to the map so that they are displayed
		map.addMarkers(markers);
	}

	/*
	 * createMarker: A suggested helper method that takes in an earthquake feature
	 * and returns a SimplePointMarker for that earthquake
	 * 
	 * In step 3 You can use this method as-is. Call it from a loop in the setp
	 * method.
	 * 
	 * TODO (Step 4): Add code to this method so that it adds the proper styling to
	 * each marker based on the magnitude of the earthquake.
	 */
	private ImageMarker createImgMarker(PointFeature feature) {
		// To create an ImageMarker object with the image based on the magnitude of the earthquake
		Object magObj = feature.getProperty("magnitude");
		float mag = Float.parseFloat(magObj.toString());
		String magnitudeClass = magnitudeClassifier(mag);
		Location earthquakeLocation = feature.getLocation();
		
		if (magnitudeClass.equals("light")) {
			return new ImageMarker(earthquakeLocation, markerImgLight);
		}else if (magnitudeClass.equals("moderate")){
			return new ImageMarker(earthquakeLocation, markerImgModerate);
		}else {
			return new ImageMarker(earthquakeLocation, markerImgStrong);
		}
		
	}
	
	private String magnitudeClassifier(float magnitude) {
		// Classify earthquakes into three categories based on their magnitudes
		if (magnitude <= THRESHOLD_LIGHT) {
			return "light";
		}else if (magnitude <= THRESHOLD_MODERATE) {
			return "moderate";
		}else {
			return "strong";
		}
		
	}

// This is the template method provided by UCSD
	private SimplePointMarker createMarker(PointFeature feature) {
		// To print all of the features in a PointFeature (so you can see what they are)
		// uncomment the line below. Note this will only print if you call createMarker
		// from setup
		// System.out.println(feature.getProperties());

		// Create a new SimplePointMarker at the location given by the PointFeature
		SimplePointMarker marker = new SimplePointMarker(feature.getLocation());

		Object magObj = feature.getProperty("magnitude");
		float mag = Float.parseFloat(magObj.toString());

		// Here is an example of how to use Processing's color method to generate
		// an int that represents the color yellow.
		int yellow = color(255, 255, 0);

		// TODO (Step 4): Add code below to style the marker's size and color
		// according to the magnitude of the earthquake.
		// Don't forget about the constants THRESHOLD_MODERATE and
		// THRESHOLD_LIGHT, which are declared above.
		// Rather than comparing the magnitude to a number directly, compare
		// the magnitude to these variables (and change their value in the code
		// above if you want to change what you mean by "moderate" and "light")

		// Finally return the marker
		return marker;
	}

	public void draw() {
		image(backgroundImg, 0, 0);
		map.draw();
		addKey();
	}

	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() {
		// Remember you can use Processing's graphics methods here
		fill(color(235, 64, 52));
		rect(50, 50, 100, 500);
		fill(255);
		image(markerImgLightKey, 67, 100);
		text("Light", 77, 200);
		image(markerImgModerateKey, 67, 265);
		text("Moderate", 55, 365);
		image(markerImgStrongKey, 67, 416);
		text("Strong", 68, 516);
		
		

	}
}

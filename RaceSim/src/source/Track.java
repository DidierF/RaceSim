package source;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Track{
	public String location;
	private BufferedImage image;

	public Track(String trackLocation){
		try {
			image = ImageIO.read(new File(trackLocation));
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public int getHeight(){
		return image.getHeight();
	}

	public int getWidth(){
		return image.getWidth();
	}
	
	public BufferedImage getTrack(){
		return image;
	}

}
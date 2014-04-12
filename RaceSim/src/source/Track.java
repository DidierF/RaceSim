package source;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

class Track{
	/**Picture of the track.	 */
	private BufferedImage image;
	/**Outer bound of racing area.	*/
	private Rectangle outBound;
	/**Inner bound of racing area.	*/
	private Rectangle inBound;
	
	private ArrayList<Point> startPos = new ArrayList<Point>();
	
	public Track(String trackLocation, Dimension outSize, Dimension inSize){
		try {
			image = ImageIO.read(new File(trackLocation));
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		outBound = new Rectangle(new Point((image.getWidth() - outSize.width)/2, (image.getHeight() - outSize.height)/2), outSize);
		inBound = new Rectangle(new Point((image.getWidth() - inSize.width)/2, (image.getHeight() - inSize.height)/2), inSize);
	}
	
	public void setStartingPos(int carsNumber, Dimension carDim, int initX){
		int remainder = (int)(inBound.getMinY() - outBound.getMinY() - 2*carDim.getHeight() )/3;
		int[] posY = {(int)(outBound.getMinY() + remainder), (int)(outBound.getMinY() + 2*remainder + carDim.getHeight())};
		int xSpace = 10;
		
		for(int i = 0; i < carsNumber; i++){
			startPos.add(new Point((initX + ((i/2) * (int)(xSpace + carDim.getWidth()))), posY[i%2]));
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

	/**
	 * @return the outBound
	 */
	public Rectangle getOutBound() {
		return outBound;
	}

	/**
	 * @return the inBound
	 */
	public Rectangle getInBound() {
		return inBound;
	}
	
	public Point getStartingPos(int x){
		return startPos.get(x);
	}

}
package source;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


class Race {

	public static void main(String args[]){

		String firstTrack = "src/source/Pictures/PistaRecta.jpg";
		String secondTrack = "src/source/Pictures/PistaRectangular_2.jpg";
		String carLocation = "src/source/Pictures/carro1.gif";

		
		Window window = new Window();
		window.setSize(500,500);
		Track track1 = new Track(firstTrack);
		window.showTrack(track1);

//		Driver drv1 = new Driver(new Car(carLocation, 250, 1500));
//		track1.addDriver(drv1);
//		track1.run();
//		window.setVisible(true);
		ImageIcon img = new ImageIcon(carLocation);
		
		JLabel som = new JLabel(img);
		track1.add(som);

		Car txt = new Car(carLocation, 50, 50);
		
		track1.add(txt);
		
	}
}
package source;

import javax.swing.JFrame;


class Window extends JFrame{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window(){
		super("Car Race Simulator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
//		setLayout(new FlowLayout());
		setVisible(true);
		
	}

	public void showTrack(Track newTrack){
		getContentPane().add(newTrack);
		setSize(newTrack.getWidth(),newTrack.getHeight());
		setVisible(true);
	}

	public void addDriver(Driver newDriver){
		getContentPane().add(newDriver.getCar());
		// newDriver.getCar().setLocation(50,50);
		setVisible(true);
	}

}
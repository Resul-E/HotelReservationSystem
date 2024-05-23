package hrs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;

public class SystemGUI extends JFrame{
	
	Menu menu;
	JTextArea textArea;
	
	public SystemGUI(Menu menu) {
		this.menu = menu;
		
		//Set up Frame
		JFrame gui = new JFrame();
		setTitle("Hotel Reservation System");
		setSize(600, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		//Set up Menu Bar
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu newMenu = new JMenu("New");
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		JMenuItem reservationItem = new JMenuItem("Reservation");
		JMenuItem serviceItem = new JMenuItem("Services");
		newMenu.add(reservationItem);
		newMenu.add(serviceItem);
		
		JMenuItem contentsItem = new JMenuItem("Contents");
		JMenuItem aboutItem = new JMenuItem("About");
		helpMenu.add(contentsItem);
		helpMenu.add(aboutItem);

		menuBar.add(fileMenu);
		menuBar.add(newMenu);
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar);
		
		//Initialize ActionListeners for Menu Items
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				System.exit(0);
			
			}
			
		});
		
		reservationItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				newReservation();
			}
			
		});
		
		serviceItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				newService();
			}
			
		});
		
		contentsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				displayUserManual();
			}
			
		});
		
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				aboutDev();
			}
			
		});
		
		//Create Buttons
		JButton displayReservationsButton = new JButton("Display Reservations");
		JButton displayServicesButton = new JButton("Display Extra Services");
		JButton displayCityReservationsButton = new JButton("Disp. Res. For City");
		
		//Initialize ActionListeners for Buttons
		displayReservationsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayReservation();
			}
		
		});
		
		displayServicesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayServices();
			}
		
		});
		
		displayCityReservationsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayReservationCity();
			}
	
		});
		
		//Create Panel for Buttons on Top
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
        topPanel.add(displayReservationsButton);
        topPanel.add(displayServicesButton);
        
        //Create Panel for Button on Bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
        bottomPanel.add(displayCityReservationsButton);
        
        //Merge Top and Bottom Panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1,0,0));
        buttonPanel.add(topPanel, BorderLayout.NORTH);
        buttonPanel.add(bottomPanel, BorderLayout.CENTER);
        
        //Add Merged Panel to Frame
        add(buttonPanel, BorderLayout.NORTH);
        

        //Create Panel for Output Terminal
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        
        //Put Padding Between Panel and Frame
        textPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        
        //Create Output Terminal
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        //Add Output Terminal to Panel
        textPanel.add(scrollPane, BorderLayout.CENTER);
        
        //Add Output Terminal Panel to Frame
        add(textPanel, BorderLayout.CENTER);
        
        
		setVisible(true);
	
	}

	private void newReservation() {
		
		Reservation.counter++;
		
		String city = JOptionPane.showInputDialog(this, "Enter city:");
		String hotelName = JOptionPane.showInputDialog(this, "Enter hotel name:");
		String month = JOptionPane.showInputDialog(this, "Enter month:");
		String start = JOptionPane.showInputDialog(this, "Enter start date:");
		String end = JOptionPane.showInputDialog(this, "Enter end date:");
	
		int startInt = Integer.parseInt(start);
		int endInt = Integer.parseInt(end);
		
		ArrayList<Services> tempLs = menu.getIncomeLs();
		
		tempLs.add(new Reservation(city, hotelName, month, startInt, endInt));
		
		menu.setIncomeLs(tempLs);
		
		
	}

	private void newService() {

		ArrayList<Services> tempLs = menu.getIncomeLs();

		String input = JOptionPane.showInputDialog(this, "Please select one of the extra services from below:\n1. Laundry Service\n2. Spa Service");
		int inputInt = Integer.parseInt(input);
		
		String customerID = JOptionPane.showInputDialog(this, "Type the reservation ID to credit this service:");
		
		int customerIDInt = Integer.parseInt(customerID);
		int piecesInt;
		int daysInt;
		
		switch (inputInt) {
		case 1:
			String pieces = JOptionPane.showInputDialog(this, "How many pieces?");
			piecesInt = Integer.parseInt(pieces);
			Laundry laundry = new Laundry();
			laundry.setCustomerID(customerIDInt);
			laundry.setClothingPieces(piecesInt);
			
			tempLs.add(laundry);
			
			menu.setIncomeLs(tempLs);
			
			break;
		case 2:
			String days = JOptionPane.showInputDialog(this, "How many days?");
			daysInt = Integer.parseInt(days);
			
			Spa spa = new Spa();
			spa.setCustomerID(customerIDInt);
			spa.setDays(daysInt);
			
			tempLs.add(spa);
			
			menu.setIncomeLs(tempLs);
			break;
		default:
			break;
		}
		
		
	}
	
	private void displayUserManual() {
		
		JOptionPane.showMessageDialog(this, "This application provides a GUI for Hotel Reservation System.\nIt allows user to create reservations and extra services.\nAnd display current reservations and extra services.", "User Manual", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private void aboutDev() {

		JOptionPane.showMessageDialog(this, "Resul Eryurt\n20220702108", "About Developer", JOptionPane.INFORMATION_MESSAGE);
		
	}




	private void displayReservation() {
		
		boolean flag = false;
		
		textArea.setText("");
		
		for(Services r : menu.getIncomeLs()) {
			if(r instanceof Reservation) {
				textArea.append(r.getServiceDetail() + "\n");
				flag = true;
			}
		}
		
		if(!flag) {
			textArea.append("No Reservations to Display!");
		}
		
	}

	private void displayServices() {

		boolean flag = false;
		
		textArea.setText("");
		
		for(Services r : menu.getIncomeLs()) {
			if(!(r instanceof Reservation)) {
				textArea.append(r.getServiceDetail() + "\n");
				flag = true;
			}
		}
		
		if(!flag) {
			textArea.append("No Services to Display!");
		}
		
	}

	private void displayReservationCity() {

		String wantedCity = JOptionPane.showInputDialog(this, "Type a city name:");
		
		boolean flag = false;
		
		textArea.setText("");
		textArea.append("Reservations for " + AdditionalMethods.formatInput(wantedCity) + "\n");
		
		for(Services r : menu.getIncomeLs()) {
			if(r instanceof Reservation) {
				if( ((Reservation)r).getCity().equalsIgnoreCase(wantedCity) ) {
					
					textArea.append(r.getServiceDetail() + "\n");
					flag = true;
				}
			}
		}
		
		if(!flag) {
			textArea.append("No Reservations to Display!");
		}
		
		
	}
	
	
	
	
}

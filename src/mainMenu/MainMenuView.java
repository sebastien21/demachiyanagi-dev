package mainMenu;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * main menu view
 * @author acmil
 *
 */
public class MainMenuView {
	
	//constructor
	public MainMenuView() {
		//nothing to complete here
	}
	
	//show Time
	public void showTime() {
		this.showCurrentDateAndTime();
	}
	
	//system date and time
	private void showCurrentDateAndTime() {
		Date currentDate = new Date();
		SimpleDateFormat currentCalendarFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String showCalendar = currentCalendarFormat.format(currentDate);
		System.out.println(showCalendar);
	}
	
	//front manager menu
	public void showManagerMenu() {
		System.out.println("1.Work flow / 2.Exit");
	}
	
	//front trader menu
	public void showTraderMenu() {
		System.out.println("1.Trades / 2.Exit");
	}
	
	//back menu
	public void showBackMenu() {
		System.out.println("1.Work flow / 2.Exit");
	}
	
}

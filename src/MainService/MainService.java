package MainService;

import java.io.IOException;

import framework.LoginFrame;

public class MainService {

	public static void main(String[] args) throws IOException {
		
		LoginFrame loginUi = new LoginFrame();
		loginUi.createUi();
		
//		LoginController loginController = new LoginController();
//		boolean isLogined = loginController.isLoginSuccessful();
//		
//		while(isLogined){
//			Account loginAccount = loginController.getLoginAccount();
//			MainMenuController mainMenuController = new MainMenuController();
//			mainMenuController.process(loginAccount);
//		}
	}
}

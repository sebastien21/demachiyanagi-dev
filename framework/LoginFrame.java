package framework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

import login.LoginController;

public class LoginFrame extends JFrame{

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 1L;
	
	//fields
	private JTextField user;
	private JPasswordField password;
	private JButton login;
	private JButton exit;
	private Container loginContainer;
	
	//constructor
	public LoginFrame(){
		this.user = new JTextField();
		this.password = new JPasswordField();
		this.login = new JButton("Login");
		this.exit = new JButton("Exit");
		this.loginContainer = getContentPane();
	}
	
	//create login user interface
	public void createUi() throws IOException{
		
		//set bounds
		setBounds(500, 250, 300, 150);
		
		setTitle("Login");
		
		//container add
		loginContainer.setLayout(new GridLayout(3,2,10,10));
		loginContainer.add(new JLabel("User"));
		loginContainer.add(user);
		loginContainer.add(new JLabel("Password"));
		loginContainer.add(password);
		loginContainer.add(login);
		loginContainer.add(exit);
		setVisible(true);
		
		//exit listener
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitEvent) {
				System.exit(0);
			}
		});
		
		//login listener
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent loginEvent) {
				LoginController loginController = new LoginController();
				
				//get id and password
				String idText = user.getText();
				String pwText = String.valueOf(password.getPassword());
				
				//check login
				try {
					boolean result = loginController.isLoginSuccessful(idText, pwText);
					messageBox(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	//login result message box
	private void messageBox(boolean result) {
		JFrame box = new JFrame();
		JButton confirm = new JButton("ok");
		confirm.setBounds(50, 80, 25, 20);
		JTextArea msg = new JTextArea();
		msg.setEditable(false);
		
		if(result) {
			box.setVisible(true);
			box.setBounds(550, 275, 200, 100);
			msg.append("Login Succeeded");
			box.add(BorderLayout.NORTH, msg);
			box.add(BorderLayout.SOUTH, confirm);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent okConfirm) {
					box.dispose();
				}
			});
		} else {
			box.setVisible(true);
			box.setBounds(550, 275, 200, 100);
			msg.append("Login Failed");
			box.add(BorderLayout.NORTH, msg);
			box.add(BorderLayout.SOUTH, confirm);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent okConfirm) {
					box.dispose();
				}
			});
			
		}
		
	}
}

package restaurant;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class Gui extends JFrame {

  private CardLayout layout;
  private static String panStatus = "BrowseFiles";
  private static Gui gui;
  private String[] tIdSelections = {"T001", "T002", "T003", "T004", "T005", "T006", "T007", "T008", "T009", "T010"};
  private String[] fIdSelections = {"F001", "F002", "F003", "F004", "F005", "F006", "F007", "F008", "F009", "F010"};
  private String[] iIdSelections = {"I001", "I002", "I003", "I004", "I005", "I006", "I007", "I008", "I009", "I010"};
  private String[] sIdSelections = {"S001", "S002", "S003", "S004", "S005", "S006", "S007", "S008", "S009", "S010", "M001", "M002", "M003", "M004", "M005"};
  
  public static void main(String[] args) {
		gui = new Gui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(900,600);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setLocationRelativeTo(null);
		panStatus();
  }
  
  public static void panStatus() {
	  gui.displayTab(panStatus);
  }
  
  public static void setPanStatus(String panStatus) {
	  Gui.panStatus = panStatus;
  }

  public Gui() {
    JPanel tab;
    Container pane = getContentPane();
    layout = new CardLayout();
    pane.setLayout(layout);
    
//BrowseFiles panel
    tab = new JPanel();
    tab.setLayout(null);
    tab.setBackground(new Color(37, 182, 149));
    
	JLabel inputFile = new JLabel("Please input the file pathname:");
	tab.add(inputFile);
	inputFile.setBounds(145, 240, 400, 30);
	inputFile.setFont(new Font("Garamond",Font.BOLD, 20));
	inputFile.setForeground(new Color(255, 255, 255));
    
	final JTextField filePath = new JTextField();
	tab.add(filePath);
	filePath.setBounds(145, 280, 380, 30);    
	filePath.setColumns(10);
	filePath.setFont(new Font("Garamond",Font.BOLD, 17));
	filePath.setForeground(new Color(128, 128, 128));
	filePath.setBorder(new EmptyBorder(0, 5, 0, 5));
     
	JButton browseButton = new JButton("Browse");
	browseButton.setBounds(535, 280, 100, 30);
	tab.add(browseButton);
	browseButton.setFocusPainted(false);
	browseButton.setFont(new Font("Garamond",Font.BOLD, 17));
	browseButton.setBackground(new Color(30, 140, 149));
	browseButton.setForeground(new Color(255, 255, 255));
	browseButton.setBorder(new EmptyBorder(0, 0, 0, 0));
	
	final JButton confirmButton = new JButton("Confirm");
	confirmButton.setBounds(645, 280, 100, 30);
	tab.add(confirmButton);
	confirmButton.setFocusPainted(false);
	confirmButton.setFont(new Font("Garamond",Font.BOLD, 17));
	confirmButton.setBackground(new Color(30, 140, 149));
	confirmButton.setForeground(new Color(255, 255, 255));
	confirmButton.setBorder(new EmptyBorder(0, 0, 0, 0));
     
	browseButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			final JFileChooser fileChooser = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			int rVal = fileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				filePath.setText(fileChooser.getSelectedFile().toString());
				
				confirmButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String file = fileChooser.getSelectedFile().getPath();
						String[] str = new String[] {file};
						try {
							Main.main(str);
							setPanStatus("Login");
		                  	panStatus();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (NullPointerException e1) {
							e1.printStackTrace();
						}
					}
				});
				
			}
		}
	});
	
    pane.add(tab, "BrowseFiles");   
    
//Login panel
    tab = new JPanel();
    tab.setLayout(null);
    tab.setBackground(new Color(37, 182, 149));
        
	JLabel staffID = new JLabel("Staff ID:");
	tab.add(staffID);
	staffID.setBounds(255, 195, 100, 30);
	staffID.setHorizontalAlignment(JLabel.RIGHT);
	staffID.setFont(new Font("Garamond",Font.BOLD, 20));
	staffID.setForeground(new Color(255, 255, 255));
	
	JLabel staffPW = new JLabel("Password:");
	tab.add(staffPW);
	staffPW.setBounds(255, 260, 100, 30);
	staffPW.setHorizontalAlignment(JLabel.RIGHT);
	staffPW.setFont(new Font("Garamond",Font.BOLD, 20));
	staffPW.setForeground(new Color(255, 255, 255));
	
	final JTextField inputStaffID = new JTextField();
	tab.add(inputStaffID);
	inputStaffID.setBounds(370, 195, 250, 30);
	inputStaffID.setFont(new Font("Garamond",Font.BOLD, 20));
	inputStaffID.setForeground(new Color(128, 128, 128));
	inputStaffID.setBorder(new EmptyBorder(0, 5, 0, 5));
	
	final JLabel invalidID = new JLabel("Invalid staff ID!");
	tab.add(invalidID);
	invalidID.setBounds(370, 225, 250, 30);
	invalidID.setFont(new Font("Garamond",Font.BOLD, 20));
	invalidID.setForeground(new Color(255, 255, 128));
	invalidID.setVisible(false);
	
	final JPasswordField inputStaffPW = new JPasswordField();
	tab.add(inputStaffPW);
	inputStaffPW.setBounds(370, 260, 250, 30);
	inputStaffPW.setEchoChar('*');
	inputStaffPW.setFont(new Font("Garamond",Font.BOLD, 20));
	inputStaffPW.setForeground(new Color(128, 128, 128));
	inputStaffPW.setBorder(new EmptyBorder(0, 5, 0, 5));
	
	final JLabel invalidPW = new JLabel("Invalid password!");
	tab.add(invalidPW);
	invalidPW.setBounds(370, 290, 250, 30);
	invalidPW.setFont(new Font("Garamond",Font.BOLD, 20));
	invalidPW.setForeground(new Color(255, 255, 128));
	invalidPW.setVisible(false);
	
	JButton login = new JButton("Login");
	tab.add(login);
	login.setFocusPainted(false);	
	login.setBounds(370, 325, 250, 30);
	login.setFont(new Font("Garamond",Font.BOLD, 20));
	login.setBackground(new Color(30, 140, 149));
	login.setForeground(new Color(255, 255, 255));
	login.setBorder(new EmptyBorder(0, 0, 0, 0));
	
	login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			final String id = inputStaffID.getText();
			char[] charPw = inputStaffPW.getPassword();
			String pw = new String(charPw);	
			if (Authentication.getInstance().validation(id,pw).equals("Login successfully!")) {
				if (UserIdentification.userIdentification(id)) {
					setPanStatus("mOptions");
				}
				else {
					setPanStatus("Options");
				}
				Gui.panStatus();
			}
			else if (Authentication.getInstance().validation(id,pw).equals("Invalid password!")){
				invalidPW.setVisible(true);
				invalidID.setVisible(false);
			}
			else {
				invalidID.setVisible(true);
				invalidPW.setVisible(false);
			}
		}
	});
    
    pane.add(tab, "Login");
    
//Options panel for managers
    tab = new JPanel();
    tab.setLayout(null);
    tab.setBackground(new Color(37, 182, 149));
    
    JLabel mOptions = new JLabel("Options");
	tab.add(mOptions);
	mOptions.setBounds(200, 20, 110, 30);
	mOptions.setHorizontalAlignment(JLabel.RIGHT);
	mOptions.setFont(new Font("Garamond",Font.BOLD, 25));
	mOptions.setForeground(new Color(255, 255, 255));
	
	JLabel mDetailsLabel = new JLabel("Details");
	tab.add(mDetailsLabel);
	mDetailsLabel.setBounds(665, 20, 110, 30);
	mDetailsLabel.setHorizontalAlignment(JLabel.LEFT);
	mDetailsLabel.setFont(new Font("Garamond",Font.BOLD, 25));
	mDetailsLabel.setForeground(new Color(27, 129, 105));
//Details
	final JLabel mID = new JLabel("ID:");
	tab.add(mID);
	mID.setBounds(570, 75, 75, 25);
	mID.setHorizontalAlignment(JLabel.RIGHT);
	mID.setFont(new Font("Garamond",Font.BOLD, 20));
	mID.setForeground(new Color(255, 255, 255));
	mID.setVisible(false);
		
	final JComboBox<String> mInputID = new JComboBox<String>();
	tab.add(mInputID);
	mInputID.setBounds(655, 75, 170, 25);
	mInputID.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputID.setBackground(new Color(255, 255, 255));
	mInputID.setForeground(new Color(128, 128, 128));
	mInputID.setVisible(false);
		
	final JLabel mNewID = new JLabel("New ID:");
	tab.add(mNewID);
	mNewID.setBounds(570, 110, 75, 25);
	mNewID.setHorizontalAlignment(JLabel.RIGHT);
	mNewID.setFont(new Font("Garamond",Font.BOLD, 17));
	mNewID.setForeground(new Color(255, 255, 255));
	mNewID.setVisible(false);
		
	final JComboBox<String> mInputNewID = new JComboBox<String>();
	tab.add(mInputNewID);
	mInputNewID.setBounds(655, 110, 170, 25);
	mInputNewID.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputNewID.setBackground(new Color(255, 255, 255));
	mInputNewID.setForeground(new Color(128, 128, 128));
	mInputNewID.setVisible(false);
	
	final JLabel mName = new JLabel("Name:");
	tab.add(mName);
	mName.setBounds(570, 110, 75, 25);
	mName.setHorizontalAlignment(JLabel.RIGHT);
	mName.setFont(new Font("Garamond",Font.BOLD, 20));
	mName.setForeground(new Color(255, 255, 255));
	mName.setVisible(false);
	
	final JTextField mInputName = new JTextField();
	tab.add(mInputName);
	mInputName.setBounds(655, 110, 170, 25);
	mInputName.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputName.setForeground(new Color(128, 128, 128));
	mInputName.setBorder(new EmptyBorder(0, 0, 0, 0));
	mInputName.setVisible(false);

	final JLabel mFoodID = new JLabel("Food:");
	tab.add(mFoodID);
	mFoodID.setBounds(570, 110, 75, 25);
	mFoodID.setHorizontalAlignment(JLabel.RIGHT);
	mFoodID.setFont(new Font("Garamond",Font.BOLD, 20));
	mFoodID.setForeground(new Color(255, 255, 255));
	mFoodID.setVisible(false);
		
	final JTextArea mInputFoodID = new JTextArea();
	tab.add(mInputFoodID);
	mInputFoodID.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputFoodID.setLineWrap(true);
	mInputFoodID.setForeground(new Color(128, 128, 128));
	
	final JScrollPane mFoodIDScrollPane = new JScrollPane(mInputFoodID);
	tab.add(mFoodIDScrollPane);
	mFoodIDScrollPane.setBounds(655, 110, 170, 50);
	mFoodIDScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	mFoodIDScrollPane.setVisible(false);
	
	final JLabel mPrice = new JLabel("Price:");
	tab.add(mPrice);
	mPrice.setBounds(570, 145, 75, 25);
	mPrice.setHorizontalAlignment(JLabel.RIGHT);
	mPrice.setFont(new Font("Garamond",Font.BOLD, 20));
	mPrice.setForeground(new Color(255, 255, 255));
	mPrice.setVisible(false);
		
	final JTextField mInputPrice = new JTextField();
	tab.add(mInputPrice);
	mInputPrice.setBounds(655, 145, 170, 25);
	mInputPrice.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputPrice.setForeground(new Color(128, 128, 128));
	mInputPrice.setBorder(new EmptyBorder(0, 0, 0, 0));
	mInputPrice.setVisible(false);

	final JLabel mQuantity = new JLabel("Quantity:");
	tab.add(mQuantity);
	mQuantity.setBounds(570, 180, 75, 25);
	mQuantity.setHorizontalAlignment(JLabel.RIGHT);
	mQuantity.setFont(new Font("Garamond",Font.BOLD, 17));
	mQuantity.setForeground(new Color(255, 255, 255));
	mQuantity.setVisible(false);
		
	final JTextField mInputQuantity = new JTextField();
	tab.add(mInputQuantity);
	mInputQuantity.setBounds(655, 180, 170, 25);
	mInputQuantity.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputQuantity.setForeground(new Color(128, 128, 128));
	mInputQuantity.setBorder(new EmptyBorder(0, 0, 0, 0));
	mInputQuantity.setVisible(false);	
	
	final JLabel mPosition = new JLabel("Position:");
	tab.add(mPosition);
	mPosition.setBounds(570, 145, 75, 25);
	mPosition.setHorizontalAlignment(JLabel.RIGHT);
	mPosition.setFont(new Font("Garamond",Font.BOLD, 17));
	mPosition.setForeground(new Color(255, 255, 255));
	mPosition.setVisible(false);
	
	final JTextField mInputPosition = new JTextField();
	tab.add(mInputPosition);
	mInputPosition.setBounds(655, 145, 170, 25);
	mInputPosition.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputPosition.setForeground(new Color(128, 128, 128));
	mInputPosition.setBorder(new EmptyBorder(0, 0, 0, 0));
	mInputPosition.setVisible(false);
	
	final JLabel mSalary = new JLabel("Salary:");
	tab.add(mSalary);
	mSalary.setBounds(570, 180, 75, 25);
	mSalary.setHorizontalAlignment(JLabel.RIGHT);
	mSalary.setFont(new Font("Garamond",Font.BOLD, 20));
	mSalary.setForeground(new Color(255, 255, 255));
	mSalary.setVisible(false);
	
	final JTextField mInputSalary = new JTextField();
	tab.add(mInputSalary);
	mInputSalary.setBounds(655, 180, 170, 25);
	mInputSalary.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputSalary.setForeground(new Color(128, 128, 128));
	mInputSalary.setBorder(new EmptyBorder(0, 0, 0, 0));
	mInputSalary.setVisible(false);
	
	final JLabel mPassword = new JLabel("Password:");
	tab.add(mPassword);
	mPassword.setBounds(570, 215, 75, 25);
	mPassword.setHorizontalAlignment(JLabel.RIGHT);
	mPassword.setFont(new Font("Garamond",Font.BOLD, 17));
	mPassword.setForeground(new Color(255, 255, 255));
	mPassword.setVisible(false);
	
	final JPasswordField mInputPassword = new JPasswordField();
	tab.add(mInputPassword);
	mInputPassword.setBounds(655, 215, 170, 25);
	mInputPassword.setEchoChar('*');
	mInputPassword.setFont(new Font("Garamond",Font.BOLD, 20));
	mInputPassword.setBorder(new EmptyBorder(0, 0, 0, 0));
	mInputPassword.setForeground(new Color(128, 128, 128));
	mInputPassword.setVisible(false);	
	//Submit	
	final JButton mSubmit = new JButton("Submit");
	tab.add(mSubmit);
	mSubmit.setFocusPainted(false);	
	mSubmit.setBounds(745, 250, 80, 25);
	mSubmit.setFont(new Font("Garamond",Font.BOLD, 15));
	mSubmit.setBackground(new Color(30, 140, 149));
	mSubmit.setForeground(new Color(255, 255, 255));
	mSubmit.setBorder(new EmptyBorder(0, 0, 0, 0));
	mSubmit.setVisible(false);
	//Result
    final JLabel mResult = new JLabel();
	tab.add(mResult);
	mResult.setBounds(570, 280, 265, 30);
	mResult.setHorizontalAlignment(JLabel.CENTER);
	mResult.setFont(new Font("Garamond",Font.BOLD, 20));
	mResult.setForeground(new Color(236, 62, 136));
	
	final JTextArea mList = new JTextArea("");
	tab.add(mList);
	mList.setFont(new Font("Consolas",Font.PLAIN, 15));
	mList.setForeground(new Color(255, 255, 255));
	mList.setBackground(new Color(30, 140, 149));
	
	//Profit	
	JButton mProfit = new JButton("Profit");
	tab.add(mProfit);
	mProfit.setFocusPainted(false);	
	mProfit.setBounds(565, 320, 92, 40);
	mProfit.setFont(new Font("Garamond",Font.BOLD, 20));
	mProfit.setBackground(new Color(253, 210, 147));
	mProfit.setBorder(new EmptyBorder(0, 0, 0, 0));
	mProfit.setForeground(new Color(27, 129, 105));
	
	mProfit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"profit"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	//Revenue	
	JButton mRevenue = new JButton("Revenue");
	tab.add(mRevenue);
	mRevenue.setFocusPainted(false);	
	mRevenue.setBounds(657, 320, 92, 40);
	mRevenue.setFont(new Font("Garamond",Font.BOLD, 20));
	mRevenue.setBackground(new Color(254, 221, 171));
	mRevenue.setBorder(new EmptyBorder(0, 0, 0, 0));
	mRevenue.setForeground(new Color(27, 129, 105));
	
	mRevenue.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"revenue"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	//Cost	
	JButton mCost = new JButton("Cost");
	tab.add(mCost);
	mCost.setFocusPainted(false);	
	mCost.setBounds(749, 320, 91, 40);
	mCost.setFont(new Font("Garamond",Font.BOLD, 20));
	mCost.setBackground(new Color(254, 227, 188));
	mCost.setBorder(new EmptyBorder(0, 0, 0, 0));
	mCost.setForeground(new Color(27, 129, 105));
	
	mCost.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"cost"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	final JViewport mShowDetails = new JViewport();
	tab.add(mShowDetails);
	mShowDetails.setBounds(565, 0, 275, 360);
	mShowDetails.setBackground(new Color(252, 185, 112));	
	
	JScrollPane mListScrollPane = new JScrollPane(mList);
	tab.add(mListScrollPane);
	mListScrollPane.setBounds(505, 380, 390, 165);
	mListScrollPane.setBackground(new Color(30, 140, 149));
	mListScrollPane.setBorder(new EmptyBorder(10, 30, 0, 0));
	
	//Submit ActionListener
	mSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "addOrder") {
				String orderStr = "addOrder " + mInputID.getSelectedItem() + " " + mInputFoodID.getText();
				String[] orderStrArr = orderStr.split(" ");				
				mResult.setText(ExecuteCmd.executeCmd(orderStrArr));
			}	
			if (e.getActionCommand() == "editOrder") {
				String orderStr = "editOrder " + mInputID.getSelectedItem() + " " + mInputFoodID.getText();
				String[] orderStrArr = orderStr.split(" ");				
				mResult.setText(ExecuteCmd.executeCmd(orderStrArr));
			}
			if (e.getActionCommand() == "deleteOrder") {
				String[] orderStrArr = {"deleteOrder", (String) mInputID.getSelectedItem()};				
				mResult.setText(ExecuteCmd.executeCmd(orderStrArr));
			}
			if (e.getActionCommand() == "addFood") {
				String[] foodStrArr = {"addFood", (String) mInputID.getSelectedItem(), mInputName.getText(), mInputPrice.getText()};				
				mResult.setText(ExecuteCmd.executeCmd(foodStrArr));
			}
			if (e.getActionCommand() == "editFood") {
				String[] foodStrArr = {"editFood", (String) mInputID.getSelectedItem(), mInputName.getText(), mInputPrice.getText()};				
				mResult.setText(ExecuteCmd.executeCmd(foodStrArr));
			}
			if (e.getActionCommand() == "deleteFood") {
				String[] foodStrArr = {"deleteFood", (String) mInputID.getSelectedItem()};				
				mResult.setText(ExecuteCmd.executeCmd(foodStrArr));
			}
			if (e.getActionCommand() == "addIng") {
				String[] ingStrArr = {"addIng", (String) mInputID.getSelectedItem(), mInputName.getText(), mInputQuantity.getText(), mInputPrice.getText()};			
				mResult.setText(ExecuteCmd.executeCmd(ingStrArr));
			}
			if (e.getActionCommand() == "editIng") {
				String[] ingStrArr = {"editIng", (String) mInputID.getSelectedItem(), mInputName.getText(), mInputQuantity.getText(), mInputPrice.getText()};			
				mResult.setText(ExecuteCmd.executeCmd(ingStrArr));
			}
			if (e.getActionCommand() == "deleteIng") {
				String[] ingStrArr = {"deleteIng", (String) mInputID.getSelectedItem()};			
				mResult.setText(ExecuteCmd.executeCmd(ingStrArr));
			}
			if (e.getActionCommand() == "rTable") {
				String[] rTableStrArr = {"rTable", (String) mInputID.getSelectedItem()};			
				mResult.setText(ExecuteCmd.executeCmd(rTableStrArr));
			}
			if (e.getActionCommand() == "editRTable") {
				String[] rTableStrArr = {"editRTable", (String) mInputID.getSelectedItem(), (String) mInputNewID.getSelectedItem()};			
				mResult.setText(ExecuteCmd.executeCmd(rTableStrArr));
			}
			if (e.getActionCommand() == "deleteRTable") {
				String[] rTableStrArr = {"deleteRTable", (String) mInputID.getSelectedItem()};			
				mResult.setText(ExecuteCmd.executeCmd(rTableStrArr));
			}
			if (e.getActionCommand() == "addStaff") {
				String[] staffStrArr = {"addStaff", (String) mInputID.getSelectedItem(), mInputName.getText(), mInputPosition.getText(), mInputSalary.getText(), new String(mInputPassword.getPassword())};			
				mResult.setText(ExecuteCmd.executeCmd(staffStrArr));
			}
			if (e.getActionCommand() == "editStaff") {
				String[] staffStrArr = {"editStaff", (String) mInputID.getSelectedItem(), mInputName.getText(), mInputPosition.getText(), mInputSalary.getText(), new String(mInputPassword.getPassword())};			
				mResult.setText(ExecuteCmd.executeCmd(staffStrArr));
			}
			if (e.getActionCommand() == "deleteStaff") {
				String[] staffStrArr = {"deleteStaff", (String) mInputID.getSelectedItem()};			
				mResult.setText(ExecuteCmd.executeCmd(staffStrArr));
			}
		}
	});	
	
//Order
	JButton mAddOrder = new JButton("<html><center>Add<br>Order</center></html>");
	tab.add(mAddOrder);
	mAddOrder.setFocusPainted(false);	
	mAddOrder.setBounds(30, 75, 115, 90);
	mAddOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	mAddOrder.setBackground(new Color(180, 250, 225));
	mAddOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	mAddOrder.setForeground(new Color(27, 129, 105));
		
	mAddOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(true);
			mFoodIDScrollPane.setVisible(true);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mInputFoodID.setText("");
			mSubmit.setActionCommand("addOrder");			
		}
	});
	
	JButton mListOrder = new JButton("<html><center>List<br>Orders</center></html>");
	tab.add(mListOrder);
	mListOrder.setFocusPainted(false);	
	mListOrder.setBounds(150, 75, 115, 90);
	mListOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	mListOrder.setBackground(new Color(180, 250, 225));
	mListOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	mListOrder.setForeground(new Color(27, 129, 105));
	
	mListOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listOrder"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton mEditOrder = new JButton("<html><center>Edit<br>Order</center></html>");
	tab.add(mEditOrder);
	mEditOrder.setFocusPainted(false);	
	mEditOrder.setBounds(270, 75, 115, 90);
	mEditOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	mEditOrder.setBackground(new Color(180, 250, 225));
	mEditOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	mEditOrder.setForeground(new Color(27, 129, 105));
	
	mEditOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(true);
			mFoodIDScrollPane.setVisible(true);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mInputFoodID.setText("");
			mSubmit.setActionCommand("editOrder");
		}
	});
	
	JButton mDeleteOrder = new JButton("<html><center>Delete<br>Order</center></html>");
	tab.add(mDeleteOrder);
	mDeleteOrder.setFocusPainted(false);	
	mDeleteOrder.setBounds(390, 75, 115, 90);
	mDeleteOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	mDeleteOrder.setBackground(new Color(180, 250, 225));
	mDeleteOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	mDeleteOrder.setForeground(new Color(27, 129, 105));
	
	mDeleteOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mSubmit.setActionCommand("deleteOrder");
		}
	});
	
//Food
	JButton mAddFood = new JButton("<html><center>Add<br>Food</center></html>");
	tab.add(mAddFood);
	mAddFood.setFocusPainted(false);	
	mAddFood.setBounds(30, 170, 115, 90);
	mAddFood.setFont(new Font("Garamond",Font.BOLD, 20));
	mAddFood.setBackground(new Color(185, 231, 255));
	mAddFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	mAddFood.setForeground(new Color(27, 129, 105));
	
	mAddFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(true);
			mInputName.setVisible(true);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(true);
			mInputPrice.setVisible(true);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(fIdSelections));
			mInputName.setText("");
			mInputPrice.setText("");
			mSubmit.setActionCommand("addFood");
		}
	});
	
	JButton mListFood = new JButton("<html><center>Menu</center></html>");
	tab.add(mListFood);
	mListFood.setFocusPainted(false);	
	mListFood.setBounds(150, 170, 115, 90);
	mListFood.setFont(new Font("Garamond",Font.BOLD, 20));
	mListFood.setBackground(new Color(185, 231, 255));	
	mListFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	mListFood.setForeground(new Color(27, 129, 105));
	
	mListFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listFood"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton mEditFood = new JButton("<html><center>Edit<br>Food</center></html>");
	tab.add(mEditFood);
	mEditFood.setFocusPainted(false);	
	mEditFood.setBounds(270, 170, 115, 90);
	mEditFood.setFont(new Font("Garamond",Font.BOLD, 20));
	mEditFood.setBackground(new Color(185, 231, 255));
	mEditFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	mEditFood.setForeground(new Color(27, 129, 105));
	
	mEditFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(true);
			mInputName.setVisible(true);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(true);
			mInputPrice.setVisible(true);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(fIdSelections));
			mInputName.setText("");
			mInputPrice.setText("");
			mSubmit.setActionCommand("editFood");
		}
	});
	
	JButton mDeleteFood = new JButton("<html><center>Delete<br>Food</center></html>");
	tab.add(mDeleteFood);
	mDeleteFood.setFocusPainted(false);	
	mDeleteFood.setBounds(390, 170, 115, 90);
	mDeleteFood.setFont(new Font("Garamond",Font.BOLD, 20));
	mDeleteFood.setBackground(new Color(185, 231, 255));
	mDeleteFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	mDeleteFood.setForeground(new Color(27, 129, 105));
	
	mDeleteFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(fIdSelections));
			mSubmit.setActionCommand("deleteFood");
		}
	});
//Ingredient
	JButton mAddIng = new JButton("<html><center>Add<br>Ingredient</center></html>");
	tab.add(mAddIng);
	mAddIng.setFocusPainted(false);	
	mAddIng.setBounds(30, 265, 115, 90);
	mAddIng.setFont(new Font("Garamond",Font.BOLD, 20));
	mAddIng.setBackground(new Color(234, 210, 255));
	mAddIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	mAddIng.setForeground(new Color(27, 129, 105));
	
	mAddIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(true);
			mInputName.setVisible(true);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(true);
			mInputPrice.setVisible(true);
			mQuantity.setVisible(true);
			mInputQuantity.setVisible(true);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(iIdSelections));
			mInputName.setText("");
			mInputPrice.setText("");
			mInputQuantity.setText("");
			mSubmit.setActionCommand("addIng");
		}
	});	
	
	JButton mListIng = new JButton("<html><center>List<br>Ingredients</center></html>");
	tab.add(mListIng);
	mListIng.setFocusPainted(false);	
	mListIng.setBounds(150, 265, 115, 90);
	mListIng.setFont(new Font("Garamond",Font.BOLD, 20));
	mListIng.setBackground(new Color(234, 210, 255));
	mListIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	mListIng.setForeground(new Color(27, 129, 105));
	
	mListIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listIng"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton mEditIng = new JButton("<html><center>Edit<br>Ingredient</center></html>");
	tab.add(mEditIng);
	mEditIng.setFocusPainted(false);	
	mEditIng.setBounds(270, 265, 115, 90);
	mEditIng.setFont(new Font("Garamond",Font.BOLD, 20));
	mEditIng.setBackground(new Color(234, 210, 255));	
	mEditIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	mEditIng.setForeground(new Color(27, 129, 105));
	
	mEditIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(true);
			mInputName.setVisible(true);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(true);
			mInputPrice.setVisible(true);
			mQuantity.setVisible(true);
			mInputQuantity.setVisible(true);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(iIdSelections));
			mInputName.setText("");
			mInputPrice.setText("");
			mInputQuantity.setText("");
			mSubmit.setActionCommand("editIng");
		}
	});
	
	JButton mDeleteIng = new JButton("<html><center>Delete<br>Ingredient</center></html>");
	tab.add(mDeleteIng);
	mDeleteIng.setFocusPainted(false);	
	mDeleteIng.setBounds(390, 265, 115, 90);
	mDeleteIng.setFont(new Font("Garamond",Font.BOLD, 20));
	mDeleteIng.setBackground(new Color(234, 210, 255));
	mDeleteIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	mDeleteIng.setForeground(new Color(27, 129, 105));
	
	mDeleteIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(iIdSelections));
			mSubmit.setActionCommand("deleteIng");
		}
	});
//Reserve Table
	JButton mRTable= new JButton("<html><center>Reserve<br>Table</center></html>");
	tab.add(mRTable);
	mRTable.setFocusPainted(false);	
	mRTable.setBounds(30, 360, 115, 90);
	mRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	mRTable.setBackground(new Color(255, 213, 230));
	mRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	mRTable.setForeground(new Color(27, 129, 105));
	
	mRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mSubmit.setActionCommand("rTable");
		}
	});
	
	JButton mListRTable = new JButton("<html><center>List<br>Reserved<br>Tables</center></html>");
	tab.add(mListRTable);
	mListRTable.setFocusPainted(false);	
	mListRTable.setBounds(150, 360, 115, 90);
	mListRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	mListRTable.setBackground(new Color(255, 213, 230));
	mListRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	mListRTable.setForeground(new Color(27, 129, 105));
	
	mListRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listRTable"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton mEditRTable = new JButton("<html><center>Edit<br>Reserved<br>Table</center></html>");
	tab.add(mEditRTable);
	mEditRTable.setFocusPainted(false);	
	mEditRTable.setBounds(270, 360, 115, 90);
	mEditRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	mEditRTable.setBackground(new Color(255, 213, 230));
	mEditRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	mEditRTable.setForeground(new Color(27, 129, 105));
	
	mEditRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(true);
			mInputNewID.setVisible(true);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mInputNewID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mSubmit.setActionCommand("editRTable");
		}
	});
	
	JButton mDeleteRTable = new JButton("<html><center>Delete<br>Reserved<br>Table</center></html>");
	tab.add(mDeleteRTable);
	mDeleteRTable.setFocusPainted(false);	
	mDeleteRTable.setBounds(390, 360, 115, 90);
	mDeleteRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	mDeleteRTable.setBackground(new Color(255, 213, 230));
	mDeleteRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	mDeleteRTable.setForeground(new Color(27, 129, 105));
	
	mDeleteRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			mSubmit.setActionCommand("deleteRTable");
		}
	});
//Staff	
	JButton mAddStaff= new JButton("<html><center>Add<br>Satff</center></html>");
	tab.add(mAddStaff);
	mAddStaff.setFocusPainted(false);	
	mAddStaff.setBounds(30, 455, 115, 90);
	mAddStaff.setFont(new Font("Garamond",Font.BOLD, 20));
	mAddStaff.setBackground(new Color(255, 231, 193));
	mAddStaff.setBorder(new EmptyBorder(0, 0, 0, 0));
	mAddStaff.setForeground(new Color(27, 129, 105));
	
	mAddStaff.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(true);
			mInputName.setVisible(true);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(true);
			mInputPosition.setVisible(true);
			mSalary.setVisible(true);
			mInputSalary.setVisible(true);
			mPassword.setVisible(true);
			mInputPassword.setVisible(true);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(sIdSelections));
			mInputName.setText("");
			mInputPosition.setText("");
			mInputSalary.setText("");
			mInputPassword.setText("");
			mSubmit.setActionCommand("addStaff");
		}
	});
		
	JButton mListStaff = new JButton("<html><center>List<br>Staffs</center></html>");
	tab.add(mListStaff);
	mListStaff.setFocusPainted(false);	
	mListStaff.setBounds(150, 455, 115, 90);
	mListStaff.setFont(new Font("Garamond",Font.BOLD, 20));
	mListStaff.setBackground(new Color(255, 231, 193));
	mListStaff.setBorder(new EmptyBorder(0, 0, 0, 0));
	mListStaff.setForeground(new Color(27, 129, 105));
	
	mListStaff.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listStaff"};
			mList.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
		
	JButton mEditStaff = new JButton("<html><center>Edit<br>Staff</center></html>");
	tab.add(mEditStaff);
	mEditStaff.setFocusPainted(false);	
	mEditStaff.setBounds(270, 455, 115, 90);
	mEditStaff.setFont(new Font("Garamond",Font.BOLD, 20));
	mEditStaff.setBackground(new Color(255, 231, 193));
	mEditStaff.setBorder(new EmptyBorder(0, 0, 0, 0));
	mEditStaff.setForeground(new Color(27, 129, 105));
	
	mEditStaff.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(true);
			mInputName.setVisible(true);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(true);
			mInputPosition.setVisible(true);
			mSalary.setVisible(true);
			mInputSalary.setVisible(true);
			mPassword.setVisible(true);
			mInputPassword.setVisible(true);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(sIdSelections));
			mInputName.setText("");
			mInputPosition.setText("");
			mInputSalary.setText("");
			mInputPassword.setText("");
			mSubmit.setActionCommand("editStaff");
		}
	});
		
	JButton mDeleteStaff = new JButton("<html><center>Delete<br>Staff</center></html>");
	tab.add(mDeleteStaff);
	mDeleteStaff.setFocusPainted(false);	
	mDeleteStaff.setBounds(390, 455, 115, 90);
	mDeleteStaff.setFont(new Font("Garamond",Font.BOLD, 20));
	mDeleteStaff.setBackground(new Color(255, 231, 193));
	mDeleteStaff.setBorder(new EmptyBorder(0, 0, 0, 0));
	mDeleteStaff.setForeground(new Color(27, 129, 105));
	
	mDeleteStaff.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mID.setVisible(true);
			mInputID.setVisible(true);
			mNewID.setVisible(false);
			mInputNewID.setVisible(false);
			mName.setVisible(false);
			mInputName.setVisible(false);
			mFoodID.setVisible(false);
			mFoodIDScrollPane.setVisible(false);
			mPrice.setVisible(false);
			mInputPrice.setVisible(false);
			mQuantity.setVisible(false);
			mInputQuantity.setVisible(false);
			mPosition.setVisible(false);
			mInputPosition.setVisible(false);
			mSalary.setVisible(false);
			mInputSalary.setVisible(false);
			mPassword.setVisible(false);
			mInputPassword.setVisible(false);
			mSubmit.setVisible(true);
			
			mInputID.setModel(new DefaultComboBoxModel<String>(sIdSelections));
			mSubmit.setActionCommand("deleteStaff");
		}
	});
	
	JViewport mRect= new JViewport();
	tab.add(mRect);
	mRect.setBounds(0, 380, 505, 165);
	mRect.setBackground(new Color(30, 140, 149));
   	
    pane.add(tab, "mOptions"); 
    
//Options panel for staff
    tab = new JPanel();
    tab.setLayout(null);
    tab.setBackground(new Color(37, 182, 149));
    
    JLabel Options = new JLabel("Options");
	tab.add(Options);
	Options.setBounds(200, 20, 110, 30);
	Options.setHorizontalAlignment(JLabel.RIGHT);
	Options.setFont(new Font("Garamond",Font.BOLD, 25));
	Options.setForeground(new Color(255, 255, 255));
	
	JLabel DetailsLabel = new JLabel("Details");
	tab.add(DetailsLabel);
	DetailsLabel.setBounds(665, 20, 110, 30);
	DetailsLabel.setHorizontalAlignment(JLabel.LEFT);
	DetailsLabel.setFont(new Font("Garamond",Font.BOLD, 25));
	DetailsLabel.setForeground(new Color(27, 129, 105));
//Details
	final JLabel ID = new JLabel("ID:");
	tab.add(ID);
	ID.setBounds(570, 75, 75, 25);
	ID.setHorizontalAlignment(JLabel.RIGHT);
	ID.setFont(new Font("Garamond",Font.BOLD, 20));
	ID.setForeground(new Color(255, 255, 255));
	ID.setVisible(false);
		
	final JComboBox<String> InputID = new JComboBox<String>();
	tab.add(InputID);
	InputID.setBounds(655, 75, 170, 25);
	InputID.setFont(new Font("Garamond",Font.BOLD, 20));
	InputID.setBackground(new Color(255, 255, 255));
	InputID.setForeground(new Color(128, 128, 128));
	InputID.setVisible(false);
		
	final JLabel NewID = new JLabel("New ID:");
	tab.add(NewID);
	NewID.setBounds(570, 110, 75, 25);
	NewID.setHorizontalAlignment(JLabel.RIGHT);
	NewID.setFont(new Font("Garamond",Font.BOLD, 17));
	NewID.setForeground(new Color(255, 255, 255));
	NewID.setVisible(false);
		
	final JComboBox<String> InputNewID = new JComboBox<String>();
	tab.add(InputNewID);
	InputNewID.setBounds(655, 110, 170, 25);
	InputNewID.setFont(new Font("Garamond",Font.BOLD, 20));
	InputNewID.setBackground(new Color(255, 255, 255));
	InputNewID.setForeground(new Color(128, 128, 128));
	InputNewID.setVisible(false);
	
	final JLabel Name = new JLabel("Name:");
	tab.add(Name);
	Name.setBounds(570, 110, 75, 25);
	Name.setHorizontalAlignment(JLabel.RIGHT);
	Name.setFont(new Font("Garamond",Font.BOLD, 20));
	Name.setForeground(new Color(255, 255, 255));
	Name.setVisible(false);
	
	final JTextField InputName = new JTextField();
	tab.add(InputName);
	InputName.setBounds(655, 110, 170, 25);
	InputName.setFont(new Font("Garamond",Font.BOLD, 20));
	InputName.setForeground(new Color(128, 128, 128));
	InputName.setBorder(new EmptyBorder(0, 0, 0, 0));
	InputName.setVisible(false);

	final JLabel FoodID = new JLabel("Food:");
	tab.add(FoodID);
	FoodID.setBounds(570, 110, 75, 25);
	FoodID.setHorizontalAlignment(JLabel.RIGHT);
	FoodID.setFont(new Font("Garamond",Font.BOLD, 20));
	FoodID.setForeground(new Color(255, 255, 255));
	FoodID.setVisible(false);
		
	final JTextArea InputFoodID = new JTextArea();
	tab.add(InputFoodID);
	InputFoodID.setFont(new Font("Garamond",Font.BOLD, 20));
	InputFoodID.setLineWrap(true);
	InputFoodID.setForeground(new Color(128, 128, 128));
	
	final JScrollPane FoodIDScrollPane = new JScrollPane(InputFoodID);
	tab.add(FoodIDScrollPane);
	FoodIDScrollPane.setBounds(655, 110, 170, 50);
	FoodIDScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	FoodIDScrollPane.setVisible(false);
	
	final JLabel Price = new JLabel("Price:");
	tab.add(Price);
	Price.setBounds(570, 145, 75, 25);
	Price.setHorizontalAlignment(JLabel.RIGHT);
	Price.setFont(new Font("Garamond",Font.BOLD, 20));
	Price.setForeground(new Color(255, 255, 255));
	Price.setVisible(false);
		
	final JTextField InputPrice = new JTextField();
	tab.add(InputPrice);
	InputPrice.setBounds(655, 145, 170, 25);
	InputPrice.setFont(new Font("Garamond",Font.BOLD, 20));
	InputPrice.setForeground(new Color(128, 128, 128));
	InputPrice.setBorder(new EmptyBorder(0, 0, 0, 0));
	InputPrice.setVisible(false);

	final JLabel Quantity = new JLabel("Quantity:");
	tab.add(Quantity);
	Quantity.setBounds(570, 180, 75, 25);
	Quantity.setHorizontalAlignment(JLabel.RIGHT);
	Quantity.setFont(new Font("Garamond",Font.BOLD, 17));
	Quantity.setForeground(new Color(255, 255, 255));
	Quantity.setVisible(false);
		
	final JTextField InputQuantity = new JTextField();
	tab.add(InputQuantity);
	InputQuantity.setBounds(655, 180, 170, 25);
	InputQuantity.setFont(new Font("Garamond",Font.BOLD, 20));
	InputQuantity.setForeground(new Color(128, 128, 128));
	InputQuantity.setBorder(new EmptyBorder(0, 0, 0, 0));
	InputQuantity.setVisible(false);	
	//Submit	
	final JButton Submit = new JButton("Submit");
	tab.add(Submit);
	Submit.setFocusPainted(false);	
	Submit.setBounds(745, 250, 80, 25);
	Submit.setFont(new Font("Garamond",Font.BOLD, 15));
	Submit.setBackground(new Color(30, 140, 149));
	Submit.setForeground(new Color(255, 255, 255));
	Submit.setBorder(new EmptyBorder(0, 0, 0, 0));
	Submit.setVisible(false);
	//Result
    final JLabel Result = new JLabel();
	tab.add(Result);
	Result.setBounds(570, 280, 265, 30);
	Result.setHorizontalAlignment(JLabel.CENTER);
	Result.setFont(new Font("Garamond",Font.BOLD, 20));
	Result.setForeground(new Color(236, 62, 136));
	
	final JTextArea List = new JTextArea("");
	tab.add(List);
	List.setFont(new Font("Consolas",Font.PLAIN, 15));
	List.setForeground(new Color(255, 255, 255));
	List.setBackground(new Color(30, 140, 149));
	
	final JViewport ShowDetails = new JViewport();
	tab.add(ShowDetails);
	ShowDetails.setBounds(565, 0, 275, 360);
	ShowDetails.setBackground(new Color(252, 185, 112));	
	
	JScrollPane ListScrollPane = new JScrollPane(List);
	tab.add(ListScrollPane);
	ListScrollPane.setBounds(505, 380, 390, 165);
	ListScrollPane.setBackground(new Color(30, 140, 149));
	ListScrollPane.setBorder(new EmptyBorder(10, 30, 0, 0));
	
	//Submit ActionListener
	Submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "addOrder") {
				String orderStr = "addOrder " + InputID.getSelectedItem() + " " + InputFoodID.getText();
				String[] orderStrArr = orderStr.split(" ");				
				Result.setText(ExecuteCmd.executeCmd(orderStrArr));
			}	
			if (e.getActionCommand() == "editOrder") {
				String orderStr = "editOrder " + InputID.getSelectedItem() + " " + InputFoodID.getText();
				String[] orderStrArr = orderStr.split(" ");				
				Result.setText(ExecuteCmd.executeCmd(orderStrArr));
			}
			if (e.getActionCommand() == "deleteOrder") {
				String[] orderStrArr = {"deleteOrder", (String) InputID.getSelectedItem()};				
				Result.setText(ExecuteCmd.executeCmd(orderStrArr));
			}
			if (e.getActionCommand() == "addFood") {
				String[] foodStrArr = {"addFood", (String) InputID.getSelectedItem(), InputName.getText(), InputPrice.getText()};				
				Result.setText(ExecuteCmd.executeCmd(foodStrArr));
			}
			if (e.getActionCommand() == "editFood") {
				String[] foodStrArr = {"editFood", (String) InputID.getSelectedItem(), InputName.getText(), InputPrice.getText()};				
				Result.setText(ExecuteCmd.executeCmd(foodStrArr));
			}
			if (e.getActionCommand() == "deleteFood") {
				String[] foodStrArr = {"deleteFood", (String) InputID.getSelectedItem()};				
				Result.setText(ExecuteCmd.executeCmd(foodStrArr));
			}
			if (e.getActionCommand() == "addIng") {
				String[] ingStrArr = {"addIng", (String) InputID.getSelectedItem(), InputName.getText(), InputQuantity.getText(), InputPrice.getText()};			
				Result.setText(ExecuteCmd.executeCmd(ingStrArr));
			}
			if (e.getActionCommand() == "editIng") {
				String[] ingStrArr = {"editIng", (String) InputID.getSelectedItem(), InputName.getText(), InputQuantity.getText(), InputPrice.getText()};			
				Result.setText(ExecuteCmd.executeCmd(ingStrArr));
			}
			if (e.getActionCommand() == "deleteIng") {
				String[] ingStrArr = {"deleteIng", (String) InputID.getSelectedItem()};			
				Result.setText(ExecuteCmd.executeCmd(ingStrArr));
			}
			if (e.getActionCommand() == "rTable") {
				String[] rTableStrArr = {"rTable", (String) InputID.getSelectedItem()};			
				Result.setText(ExecuteCmd.executeCmd(rTableStrArr));
			}
			if (e.getActionCommand() == "editRTable") {
				String[] rTableStrArr = {"editRTable", (String) InputID.getSelectedItem(), (String) InputNewID.getSelectedItem()};			
				Result.setText(ExecuteCmd.executeCmd(rTableStrArr));
			}
			if (e.getActionCommand() == "deleteRTable") {
				String[] rTableStrArr = {"deleteRTable", (String) InputID.getSelectedItem()};			
				Result.setText(ExecuteCmd.executeCmd(rTableStrArr));
			}
		}
	});	
	
//Order
	JButton AddOrder = new JButton("<html><center>Add<br>Order</center></html>");
	tab.add(AddOrder);
	AddOrder.setFocusPainted(false);	
	AddOrder.setBounds(30, 75, 115, 90);
	AddOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	AddOrder.setBackground(new Color(180, 250, 225));
	AddOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	AddOrder.setForeground(new Color(27, 129, 105));
		
	AddOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(true);
			FoodIDScrollPane.setVisible(true);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			InputFoodID.setText("");
			Submit.setActionCommand("addOrder");			
		}
	});
	
	JButton ListOrder = new JButton("<html><center>List<br>Orders</center></html>");
	tab.add(ListOrder);
	ListOrder.setFocusPainted(false);	
	ListOrder.setBounds(150, 75, 115, 90);
	ListOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	ListOrder.setBackground(new Color(180, 250, 225));
	ListOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	ListOrder.setForeground(new Color(27, 129, 105));
	
	ListOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listOrder"};
			List.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton EditOrder = new JButton("<html><center>Edit<br>Order</center></html>");
	tab.add(EditOrder);
	EditOrder.setFocusPainted(false);	
	EditOrder.setBounds(270, 75, 115, 90);
	EditOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	EditOrder.setBackground(new Color(180, 250, 225));
	EditOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	EditOrder.setForeground(new Color(27, 129, 105));
	
	EditOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(true);
			FoodIDScrollPane.setVisible(true);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			InputFoodID.setText("");
			Submit.setActionCommand("editOrder");
		}
	});
	
	JButton DeleteOrder = new JButton("<html><center>Delete<br>Order</center></html>");
	tab.add(DeleteOrder);
	DeleteOrder.setFocusPainted(false);	
	DeleteOrder.setBounds(390, 75, 115, 90);
	DeleteOrder.setFont(new Font("Garamond",Font.BOLD, 20));
	DeleteOrder.setBackground(new Color(180, 250, 225));
	DeleteOrder.setBorder(new EmptyBorder(0, 0, 0, 0));
	DeleteOrder.setForeground(new Color(27, 129, 105));
	
	DeleteOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			Submit.setActionCommand("deleteOrder");
		}
	});
	
//Food
	JButton AddFood = new JButton("<html><center>Add<br>Food</center></html>");
	tab.add(AddFood);
	AddFood.setFocusPainted(false);	
	AddFood.setBounds(30, 201, 115, 90);
	AddFood.setFont(new Font("Garamond",Font.BOLD, 20));
	AddFood.setBackground(new Color(185, 231, 255));
	AddFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	AddFood.setForeground(new Color(27, 129, 105));
	
	AddFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(true);
			InputName.setVisible(true);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(true);
			InputPrice.setVisible(true);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(fIdSelections));
			InputName.setText("");
			InputPrice.setText("");
			Submit.setActionCommand("addFood");
		}
	});
	
	JButton ListFood = new JButton("<html><center>Menu</center></html>");
	tab.add(ListFood);
	ListFood.setFocusPainted(false);	
	ListFood.setBounds(150, 201, 115, 90);
	ListFood.setFont(new Font("Garamond",Font.BOLD, 20));
	ListFood.setBackground(new Color(185, 231, 255));	
	ListFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	ListFood.setForeground(new Color(27, 129, 105));
	
	ListFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listFood"};
			List.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton EditFood = new JButton("<html><center>Edit<br>Food</center></html>");
	tab.add(EditFood);
	EditFood.setFocusPainted(false);	
	EditFood.setBounds(270, 201, 115, 90);
	EditFood.setFont(new Font("Garamond",Font.BOLD, 20));
	EditFood.setBackground(new Color(185, 231, 255));
	EditFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	EditFood.setForeground(new Color(27, 129, 105));
	
	EditFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(true);
			InputName.setVisible(true);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(true);
			InputPrice.setVisible(true);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(fIdSelections));
			InputName.setText("");
			InputPrice.setText("");
			Submit.setActionCommand("editFood");
		}
	});
	
	JButton DeleteFood = new JButton("<html><center>Delete<br>Food</center></html>");
	tab.add(DeleteFood);
	DeleteFood.setFocusPainted(false);	
	DeleteFood.setBounds(390, 201, 115, 90);
	DeleteFood.setFont(new Font("Garamond",Font.BOLD, 20));
	DeleteFood.setBackground(new Color(185, 231, 255));
	DeleteFood.setBorder(new EmptyBorder(0, 0, 0, 0));
	DeleteFood.setForeground(new Color(27, 129, 105));
	
	DeleteFood.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(fIdSelections));
			Submit.setActionCommand("deleteFood");
		}
	});
//Ingredient
	JButton AddIng = new JButton("<html><center>Add<br>Ingredient</center></html>");
	tab.add(AddIng);
	AddIng.setFocusPainted(false);	
	AddIng.setBounds(30, 328, 115, 90);
	AddIng.setFont(new Font("Garamond",Font.BOLD, 20));
	AddIng.setBackground(new Color(234, 210, 255));
	AddIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	AddIng.setForeground(new Color(27, 129, 105));
	
	AddIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(true);
			InputName.setVisible(true);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(true);
			InputPrice.setVisible(true);
			Quantity.setVisible(true);
			InputQuantity.setVisible(true);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(iIdSelections));
			InputName.setText("");
			InputPrice.setText("");
			InputQuantity.setText("");
			Submit.setActionCommand("addIng");
		}
	});	
	
	JButton ListIng = new JButton("<html><center>List<br>Ingredients</center></html>");
	tab.add(ListIng);
	ListIng.setFocusPainted(false);	
	ListIng.setBounds(150, 328, 115, 90);
	ListIng.setFont(new Font("Garamond",Font.BOLD, 20));
	ListIng.setBackground(new Color(234, 210, 255));
	ListIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	ListIng.setForeground(new Color(27, 129, 105));
	
	ListIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listIng"};
			List.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton EditIng = new JButton("<html><center>Edit<br>Ingredient</center></html>");
	tab.add(EditIng);
	EditIng.setFocusPainted(false);	
	EditIng.setBounds(270, 328, 115, 90);
	EditIng.setFont(new Font("Garamond",Font.BOLD, 20));
	EditIng.setBackground(new Color(234, 210, 255));	
	EditIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	EditIng.setForeground(new Color(27, 129, 105));
	
	EditIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(true);
			InputName.setVisible(true);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(true);
			InputPrice.setVisible(true);
			Quantity.setVisible(true);
			InputQuantity.setVisible(true);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(iIdSelections));
			InputName.setText("");
			InputPrice.setText("");
			InputQuantity.setText("");
			Submit.setActionCommand("editIng");
		}
	});
	
	JButton DeleteIng = new JButton("<html><center>Delete<br>Ingredient</center></html>");
	tab.add(DeleteIng);
	DeleteIng.setFocusPainted(false);	
	DeleteIng.setBounds(390, 328, 115, 90);
	DeleteIng.setFont(new Font("Garamond",Font.BOLD, 20));
	DeleteIng.setBackground(new Color(234, 210, 255));
	DeleteIng.setBorder(new EmptyBorder(0, 0, 0, 0));
	DeleteIng.setForeground(new Color(27, 129, 105));
	
	DeleteIng.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(iIdSelections));
			Submit.setActionCommand("deleteIng");
		}
	});
//Reserve Table
	JButton RTable= new JButton("<html><center>Reserve<br>Table</center></html>");
	tab.add(RTable);
	RTable.setFocusPainted(false);	
	RTable.setBounds(30, 455, 115, 90);
	RTable.setFont(new Font("Garamond",Font.BOLD, 20));
	RTable.setBackground(new Color(255, 213, 230));
	RTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	RTable.setForeground(new Color(27, 129, 105));
	
	RTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			Submit.setActionCommand("rTable");
		}
	});
	
	JButton ListRTable = new JButton("<html><center>List<br>Reserved<br>Tables</center></html>");
	tab.add(ListRTable);
	ListRTable.setFocusPainted(false);	
	ListRTable.setBounds(150, 455, 115, 90);
	ListRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	ListRTable.setBackground(new Color(255, 213, 230));
	ListRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	ListRTable.setForeground(new Color(27, 129, 105));
	
	ListRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String[] strArr = {"listRTable"};
			List.setText((ExecuteCmd.executeCmd(strArr)));
		}
	});
	
	JButton EditRTable = new JButton("<html><center>Edit<br>Reserved<br>Table</center></html>");
	tab.add(EditRTable);
	EditRTable.setFocusPainted(false);	
	EditRTable.setBounds(270, 455, 115, 90);
	EditRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	EditRTable.setBackground(new Color(255, 213, 230));
	EditRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	EditRTable.setForeground(new Color(27, 129, 105));
	
	EditRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(true);
			InputNewID.setVisible(true);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			InputNewID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			Submit.setActionCommand("editRTable");
		}
	});
	
	JButton DeleteRTable = new JButton("<html><center>Delete<br>Reserved<br>Table</center></html>");
	tab.add(DeleteRTable);
	DeleteRTable.setFocusPainted(false);	
	DeleteRTable.setBounds(390, 455, 115, 90);
	DeleteRTable.setFont(new Font("Garamond",Font.BOLD, 20));
	DeleteRTable.setBackground(new Color(255, 213, 230));
	DeleteRTable.setBorder(new EmptyBorder(0, 0, 0, 0));
	DeleteRTable.setForeground(new Color(27, 129, 105));
	
	DeleteRTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ID.setVisible(true);
			InputID.setVisible(true);
			NewID.setVisible(false);
			InputNewID.setVisible(false);
			Name.setVisible(false);
			InputName.setVisible(false);
			FoodID.setVisible(false);
			FoodIDScrollPane.setVisible(false);
			Price.setVisible(false);
			InputPrice.setVisible(false);
			Quantity.setVisible(false);
			InputQuantity.setVisible(false);
			Submit.setVisible(true);
			
			InputID.setModel(new DefaultComboBoxModel<String>(tIdSelections));
			Submit.setActionCommand("deleteRTable");
		}
	});
   	
	JViewport Rect= new JViewport();
	tab.add(Rect);
	Rect.setBounds(0, 380, 505, 165);
	Rect.setBackground(new Color(30, 140, 149));
	
    pane.add(tab, "Options"); 
    
  }

  public void displayTab(String name) {
    layout.show(this.getContentPane(), name);
  }

}
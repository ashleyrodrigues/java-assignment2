import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Foo extends JFrame {
	ArrayList<Product> productList = new ArrayList();
	private static String FILEPATH = "./product.txt";
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu, productMenu;
	private JMenuItem exitMenuItem, addUpdateMenuItem, findDisplayMenuItem;
	private JPanel mainPanel, addUpdatePanel, findDisplayPanel, topicPanel;
	private JPanel productIdPanel, namePanel, descriptionPanel, quantityPanel, firstRowPanel, secondRowPanel, twoButtonPanel, fourButtonPanel,  errorPanel;
	private JLabel mainLabel;
	private JLabel productIdLabel, nameLabel, descriptionLabel, quantityLabel, priceLabel, errorLabel;
	private JTextField productIdField, nameField, quantityField, priceField;
	private JTextArea descriptionField;
	private JButton addButton, updateButton, firstButton, prevButton, nextButton, lastButton;
	private JRadioButton priceRange, keyword, all;
	private ButtonGroup filterBy;
	private JTextField toField, fromField, keywordField;
	private JButton findDisplayButton;
	private JTextArea resultField;
	private JPanel radioButtonPanel, toFromPanel, keywordPanel, findDisplayButtonPanel, topPanel, resultPanel, filtersPanel;
	private ActionListener exitApp, addUpdateMenuEvent, findDisplayMenuEvent;
	private ActionListener addProduct, updateProduct, firstProduct, lastProduct, prevProduct, nextProduct, findDisplayAction;
	private int index = 0;

	public Foo() throws FileNotFoundException, IOException, ClassNotFoundException {
		productList = readFromFile(FILEPATH);
		class ExitMenuistener implements ActionListener {
			public void actionPerformed(ActionEvent event)

			{
				System.exit(0);
			}
		}
		class AddUpdateMenuListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				showAddUpdateMenu();
			}
		}
		class FindDisplayMenuListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				showFindDisplayMenu();
			}
		}
		class addProductListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					addButton();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		class updateProductListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					updateButton();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		class firstProductListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					firstButton();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		class lastProductListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					lastButton();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		class prevProductListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					prevButton();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		class nextProductListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					nextButton();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		class findDisplayListener implements ActionListener {
			public void actionPerformed(ActionEvent event)
			{
				findDisplayButton();
			}
		}
		exitApp = new ExitMenuistener();
		addUpdateMenuEvent = new AddUpdateMenuListener();
		findDisplayMenuEvent = new FindDisplayMenuListener();
		addProduct = new addProductListener();
		updateProduct = new updateProductListener();
		firstProduct = new firstProductListener();
		lastProduct = new lastProductListener();
		prevProduct = new prevProductListener();
		nextProduct = new nextProductListener();
		findDisplayAction = new findDisplayListener();
		createUI();
	}

	public void createUI() {
		setSize(670, 370);
		mainPanel = new JPanel();
		fileMenu = new JMenu("File");
		productMenu = new JMenu("Product");
		addUpdateMenuItem = new JMenuItem("Add/Update");
		addUpdateMenuItem.addActionListener(addUpdateMenuEvent);
		findDisplayMenuItem = new JMenuItem("Find/Display");
		findDisplayMenuItem.addActionListener(findDisplayMenuEvent);
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(exitApp);
		fileMenu.add(exitMenuItem);
		productMenu.add(addUpdateMenuItem);
		productMenu.add(findDisplayMenuItem);
		menuBar.add(fileMenu);
		menuBar.add(productMenu);
		setJMenuBar(menuBar);

		topicPanel = new JPanel();
		topicPanel.setLayout(new BorderLayout());
		mainLabel = new JLabel("Product Management System");
		mainLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 32));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topicPanel.add(mainLabel, BorderLayout.CENTER);
		mainPanel.add(topicPanel);
		topicPanel.setVisible(true);
		
		//add update screen
		addUpdatePanel = new JPanel();
		addUpdatePanel.setLayout(new GridLayout(0,1));
		firstRowPanel = new JPanel();
		firstRowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		productIdPanel = new JPanel();
		productIdLabel = new JLabel("Product ID");
		productIdField = new JTextField(15);
		productIdPanel.add(productIdLabel);
		productIdPanel.add(productIdField);
		firstRowPanel.add(productIdPanel);
//		// name
		namePanel = new JPanel();
		nameLabel = new JLabel("Name");
		nameField = new JTextField(20);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		firstRowPanel.add(namePanel);
		addUpdatePanel.add(firstRowPanel);
//		// description
		secondRowPanel = new JPanel();
		secondRowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 0));
		descriptionPanel = new JPanel();
		descriptionLabel = new JLabel("Description");
		descriptionField = new JTextArea(3, 15);
		descriptionPanel.add(descriptionLabel);
		descriptionPanel.add(descriptionField);
		secondRowPanel.add(descriptionPanel);
//		// quantity
		quantityPanel = new JPanel();
		quantityPanel.setLayout(new GridLayout(2,1, 5, 10));
		quantityLabel = new JLabel("Quantity in hand");
		quantityField = new JTextField(7);
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityField);
		// price
		priceLabel = new JLabel("Unit Price");
		priceField = new JTextField(7);
		quantityPanel.add(priceLabel);
		quantityPanel.add(priceField);
		secondRowPanel.add(quantityPanel);
		addUpdatePanel.add(secondRowPanel);
//		// buttons
		addButton = new JButton("Add");
		addButton.addActionListener(addProduct);
		updateButton = new JButton("Update");
		updateButton.addActionListener(updateProduct);
		firstButton = new JButton("First");
		firstButton.addActionListener(firstProduct);
		prevButton = new JButton("Previous");
		prevButton.addActionListener(prevProduct);
		nextButton = new JButton("Next");
		nextButton.addActionListener(nextProduct);
		lastButton = new JButton("Last");
		lastButton.addActionListener(lastProduct);
		twoButtonPanel = new JPanel();
		twoButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		fourButtonPanel = new JPanel();
		fourButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		twoButtonPanel.add(addButton);
		twoButtonPanel.add(updateButton);
		fourButtonPanel.add(firstButton);
		fourButtonPanel.add(prevButton);
		fourButtonPanel.add(nextButton);
		fourButtonPanel.add(lastButton);
		addUpdatePanel.add(twoButtonPanel);
		addUpdatePanel.add(fourButtonPanel);
		addUpdatePanel.setVisible(false);
		mainPanel.add(addUpdatePanel);
		//error label
		errorPanel = new JPanel();
		errorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		errorLabel = new JLabel("");
		errorPanel.add(errorLabel);
		addUpdatePanel.add(errorPanel);
		
//		find and display screen
		findDisplayPanel = new JPanel();
		findDisplayPanel.setLayout(new GridLayout(2,1));
		topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//		//filter radio buttons
		filterBy = new ButtonGroup();
		priceRange = new JRadioButton("Price Range");
		keyword = new JRadioButton("Keyword");
		all = new JRadioButton("All");
		filterBy.add(priceRange);
		filterBy.add(keyword);
		filterBy.add(all);
		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(3, 1));
		radioButtonPanel.add(priceRange);
		radioButtonPanel.add(keyword);
		radioButtonPanel.add(all);
		topPanel.add(radioButtonPanel);
		//to from
		filtersPanel = new JPanel(new GridLayout(2,1,30,10));
		toField = new JTextField(10);
		toField.setText("min.");
		fromField = new JTextField(10);
		fromField.setText("max.");
		filtersPanel.add(toField);
		filtersPanel.add(fromField);
		// keyword
		keywordField = new JTextField(10);
		keywordField.setText("keyword");
		filtersPanel.add(keywordField);
		topPanel.add(filtersPanel);
		//findDisplay Button
		findDisplayButton = new JButton("Find/Display");
		findDisplayButton.addActionListener(findDisplayAction);
		findDisplayButtonPanel = new JPanel();
		findDisplayButtonPanel.add(findDisplayButton);
		topPanel.add(findDisplayButtonPanel);
		//result
		resultField = new JTextArea(8,55);
		resultPanel = new JPanel();
		resultPanel.add(resultField);
		findDisplayPanel.add(topPanel);
		findDisplayPanel.add(resultPanel);
		findDisplayPanel.setVisible(false);
		mainPanel.add(findDisplayPanel);
		add(mainPanel);
	}

	public void showAddUpdateMenu() {
		topicPanel.setVisible(false);
		addUpdatePanel.setVisible(true);
		findDisplayPanel.setVisible(false);
	}

	public void showFindDisplayMenu() {
		topicPanel.setVisible(false);
		addUpdatePanel.setVisible(false);
		findDisplayPanel.setVisible(true);
	}

	public void addButton() throws FileNotFoundException, IOException {
		if(checkFields()) {
			errorLabel = new JLabel("");
			Product pr = new Product(productIdField.getText(), 
					nameField.getText(), 
					descriptionField.getText(),
					Integer.parseInt(quantityField.getText()), 
					Integer.parseInt(priceField.getText()));
			productList.add(pr);
			writeToFile(FILEPATH);
			productIdField.setText("");
			nameField.setText("");
			descriptionField.setText("");
			quantityField.setText("");
			priceField.setText("");
		}
	}

	public void updateButton() throws FileNotFoundException, ClassNotFoundException, IOException {
		if(checkFields(index)) {
			errorLabel = new JLabel("");
			productList.get(index).setProductId(productIdField.getText());
			productList.get(index).setName(nameField.getText());
			productList.get(index).setDescription(descriptionField.getText());
			productList.get(index).setQuantityInHand(Integer.parseInt(quantityField.getText()));
			productList.get(index).setUnitPrice(Integer.parseInt(priceField.getText()));
			writeToFile(FILEPATH);
			productIdField.setText("");
			nameField.setText("");
			descriptionField.setText("");
			quantityField.setText("");
			priceField.setText("");
		}
	}

	public void firstButton() throws FileNotFoundException, ClassNotFoundException, IOException {
		index = 0;
		Product product = productList.get(index);
		fillFields(product);
	}

	public void lastButton() throws FileNotFoundException, ClassNotFoundException, IOException {
		index = productList.size() - 1;
		Product product = productList.get(index);
		fillFields(product);
	}

	public void prevButton() throws FileNotFoundException, ClassNotFoundException, IOException {
		if (index > 0) {
			index--;
			ArrayList<Product> productList = readFromFile(FILEPATH);
			Product product = productList.get(index);
			fillFields(product);
		}
	}

	public void nextButton() throws FileNotFoundException, ClassNotFoundException, IOException {
		if (index < productList.size() - 1) {
			index++;
			Product product = productList.get(index);
			fillFields(product);
		}
	}

	public void writeToFile(String filepath) throws FileNotFoundException, IOException {
		try (ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File(filepath))))) {
			output.writeObject(productList);
		}
	}

	public ArrayList<Product> readFromFile(String filepath)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream input = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(new File(filepath))))) {
			ArrayList<Product> pr = (ArrayList<Product>) input.readObject();
			return pr;
		}
	}

	public boolean checkFields(int idx) {
		boolean chk = true;
		for(int i=0;i<productList.size();i++) {
			if(idx!=i && productList.get(i).getProductId().equals(productIdField.getText())){
				errorLabel.setText("Product ID Already Exisits");
				chk = false;
			}
		}	
		if(!isNumeric(quantityField.getText()) && Double.parseDouble(quantityField.getText()) < 0) {
			chk = false;
			errorLabel.setText("Quantity Should be Numeric and Greater than 0");
		}
		else if(!isNumeric(priceField.getText()) && Double.parseDouble(priceField.getText()) < 0) {
			chk = false;
			errorLabel.setText("Price Should be Numeric and Greater than 0");
		}
		else if(nameField.getText().isEmpty()) {
			chk = false;
			errorLabel.setText("Name Cannot Be Null");
		}
		return chk;
	}

	public boolean checkFields() {
		boolean check = true;
		for(int i=0;i<productList.size();i++) {
			if(productList.get(i).getProductId().equals(productIdField.getText())){
				errorLabel.setText("Product ID Already Exisits");
				check = false;
			}
		}	
		if(!isNumeric(quantityField.getText()) && Double.parseDouble(quantityField.getText()) < 0) {
			check = false;
			errorLabel.setText("Quantity Should be Numeric and Greater than 0");
		}
		else if(!isNumeric(priceField.getText()) && Double.parseDouble(priceField.getText()) < 0) {
			check = false;
			errorLabel.setText("Price Should be Numeric and Greater than 0");
		}
		else if(nameField.getText().isEmpty()) {
			check = false;
			errorLabel.setText("Name Cannot Be Null");
		}
		return check;
	}

	public void fillFields(Product product) {
		productIdField.setText(product.getProductId());
		nameField.setText(product.getName());
		descriptionField.setText(product.getDescription());
		quantityField.setText(String.valueOf(product.getQuantityInHand()));
		priceField.setText(String.valueOf(product.getUnitPrice()));
	}

	public void findDisplayButton() {
		String productDetails = "";
		if(priceRange.isSelected()) {
			for(int i=0;i<productList.size();i++) {
				if(productList.get(i).getUnitPrice() >= Integer.parseInt(toField.getText())  && 
						productList.get(i).getUnitPrice() <= Integer.parseInt(fromField.getText()))
					productDetails += productList.get(i).toString() + "\n";
			}
		} else if(keyword.isSelected()) {
			for(int i=0;i<productList.size();i++) {
				if(productList.get(i).getName().contains(keywordField.getText()))
					productDetails += productList.get(i).toString() + "\n";
			}
		}  else if(all.isSelected()) {
			for(int i=0;i<productList.size();i++) {
				productDetails += productList.get(i).toString() + "\n";
			}
		}
		resultField.setText(productDetails);
	}

	public static boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
			return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}
}

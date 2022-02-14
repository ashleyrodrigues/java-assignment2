import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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

public class ProductUI extends JFrame {
	ArrayList<Product> productList = new ArrayList();
	private static String FILEPATH = "./product.txt";
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu, productMenu;
	private JMenuItem exitMenuItem, addUpdateMenuItem, findDisplayMenuItem;
	private JPanel mainPanel, addUpdatePanel, findDisplayPanel;
	private JPanel productIdPanel, namePanel, descriptionPanel, quantityPanel, pricePanel, twoButtonPanel,
	fourButtonPanel;
	private JLabel mainLabel;
	private JLabel productIdLabel, nameLabel, descriptionLabel, quantityLabel, priceLabel;
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

	public ProductUI() throws FileNotFoundException, IOException, ClassNotFoundException {
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
		setSize(670, 320);
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
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

		mainLabel = new JLabel("Product Management System", SwingConstants.CENTER);
		mainLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		mainLabel.setBounds(150, 70, 350, 100);
		mainPanel.add(mainLabel);

		addUpdatePanel = new JPanel();
		addUpdatePanel.setBounds(0, 0, 650, 300);
		//product id
		productIdPanel = new JPanel();
		productIdLabel = new JLabel("Product ID");
		productIdField = new JTextField(10);
		productIdPanel.add(productIdLabel);
		productIdPanel.add(productIdField);
		addUpdatePanel.add(productIdPanel);
		// name
		namePanel = new JPanel();
		nameLabel = new JLabel("Name");
		nameField = new JTextField(15);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		addUpdatePanel.add(namePanel);
		// description
		descriptionPanel = new JPanel();
		descriptionLabel = new JLabel("Description");
		descriptionField = new JTextArea(3, 10);
		descriptionPanel.add(descriptionLabel);
		descriptionPanel.add(descriptionField);
		addUpdatePanel.add(descriptionPanel);
		// quantity
		quantityPanel = new JPanel();
		quantityLabel = new JLabel("Quantity in hand");
		quantityField = new JTextField(7);
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityField);
		addUpdatePanel.add(quantityPanel);
		// price
		pricePanel = new JPanel();
		priceLabel = new JLabel("Unit Price");
		priceField = new JTextField(7);
		pricePanel.add(priceLabel);
		pricePanel.add(priceField);
		addUpdatePanel.add(pricePanel);
		// buttons
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
		fourButtonPanel = new JPanel();
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


		topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		findDisplayPanel = new JPanel();
		findDisplayPanel.setBounds(0,0,650,300);
		//filter radio buttons
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
		toField = new JTextField(10);
		toField.setText("to");
		fromField = new JTextField(10);
		fromField.setText("from");
		toFromPanel = new JPanel();
		toFromPanel.add(toField);
		toFromPanel.add(fromField);
		// keyword
		keywordField = new JTextField(10);
		keywordField.setText("keyword");
		keywordPanel = new JPanel();
		keywordPanel.add(keywordField);
		topPanel.add(keywordPanel);
		filtersPanel = new JPanel(new GridLayout(2,1));
		filtersPanel.add(toFromPanel);
		filtersPanel.add(keywordPanel);
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
		mainLabel.setVisible(false);
		addUpdatePanel.setVisible(true);
		findDisplayPanel.setVisible(false);
	}

	public void showFindDisplayMenu() {
		mainLabel.setVisible(false);
		addUpdatePanel.setVisible(false);
		findDisplayPanel.setVisible(true);
	}

	public void addButton() throws FileNotFoundException, IOException {
		
		if(checkFields()) {
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
		for(int i=0;i<productList.size();i++) {
			if(productList.get(i).productId.equals(productIdField.getText())){
				System.out.println("Ohhh HELL NO");
				//chk = false;
			}
		}	
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

	public boolean checkFields() {
		boolean chk = true;
		for(int i=0;i<productList.size();i++) {
			if(productList.get(i).getProductId().equals(productIdField.getText())){
				System.out.println("Ohhh HELL NO");
				chk = false;
			}
			}
		return chk;
	}
	
	public void fillFields(Product product) {
		productIdField.setText(product.getProductId());
		nameField.setText(product.getName());
		descriptionField.setText(product.getDescription());
		quantityField.setText(String.valueOf(product.getQuantityInHand()));
		priceField.setText(String.valueOf(product.getUnitPrice()));
	}

	public void findDisplayButton() {
		if(priceRange.isSelected()) {
			
		} else if(keyword.isSelected()) {
			
		} else if(all.isSelected()) {
			System.out.println(productList);
			String productDetails = "";
			for(int i=0;i<productList.size();i++) {
				System.out.println(productList);
				productDetails = productList.toString();
			}
			resultField.setText(productDetails);
		}
	}
}

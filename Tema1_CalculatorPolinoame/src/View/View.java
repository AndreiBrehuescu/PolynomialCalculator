package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Monom;
import Model.Polinom;


public class View extends JFrame{
	private JPanel pane = new JPanel();
	private GridBagLayout gbl = new GridBagLayout();
	public GridBagConstraints c = new GridBagConstraints();
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton intButton = new JButton("|");
	private JButton derButton = new JButton("`");
	private JButton clearButton = new JButton("clear");
	private JTextField text1 = new JTextField();
	private JTextField text2 = new JTextField();
	private JLabel result = new JLabel("result");
	private JLabel rest = new JLabel("rest");

	Controller controller = new Controller(this);
	
	public View(String name) {
		setBounds(100,100,800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setBackground(new Color(0, 128, 128));
		setContentPane(pane);
		pane.setLayout(gbl);
		gbl.rowHeights = new int[]{0, 0, 0, 45, 45, 45, 45, 45, 45, 45, 45, 45, 0, 0, 0};

		JLabel cal = new JLabel("Calculator de polinoame");
		cal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c.gridy = 0;
		c.gridx = 7;
		c.gridheight = 2;
		c.gridwidth = 1;
		c.insets = new Insets(0,0,5,5);
		pane.add(cal,c);
		
		
		c.gridx = 20;
		c.gridy = 3;
		pane.add(addButton,c);
		addButton.addActionListener(controller);
		
		c.gridy = 4;
		pane.add(subButton,c);
		subButton.addActionListener(controller);
		
		c.gridy = 5;
		pane.add(mulButton,c);
		mulButton.addActionListener(controller);
		
		c.gridy = 6;
		pane.add(divButton,c);
		divButton.addActionListener(controller);
		
		c.gridy = 7;
		pane.add(intButton,c);
		intButton.addActionListener(controller);
		
		c.gridy = 8;
		pane.add(derButton,c);
		derButton.addActionListener(controller);
		
		c.gridx = 6;
		c.gridy = 4;
		c.insets = new Insets(0,0,5,50);
		pane.add(new Label("Polinom 1 : "),c);
		
		c.gridx = 7;
		c.gridy = 4;
		c.insets = new Insets(0,0,5,50);
		pane.add(text1,c);
		text1.setColumns(20);
		
		c.gridx = 6;
		c.gridy = 5;
		c.insets = new Insets(0,0,5,50);
		pane.add(new Label("Polinom 2 : "),c);
		
		c.gridx = 7;
		c.gridy = 5;
		c.insets = new Insets(0,0,5,50);
		pane.add(text2,c);
		text2.setColumns(20);
		
		c.gridx = 6;
		c.gridy = 7;
		c.insets = new Insets(0,0,5,50);
		pane.add(new Label("Rezultat : "),c);
		
		c.gridx = 7;
		c.gridy = 7;
		c.insets = new Insets(0,0,5,50);
		pane.add(result,c);
		
		c.gridx = 6;
		c.gridy = 8;
		c.insets = new Insets(0,0,5,50);
		pane.add(new Label("Rest : "),c);
		
		c.gridx = 7;
		c.gridy = 8;
		c.insets = new Insets(0,0,5,50);
		pane.add(rest,c);
		
		c.gridx = 7;
		c.gridy = 6;
		pane.add(clearButton,c);
		clearButton.addActionListener(controller);
		
		
		c.gridx = 0;
		c.gridy = 20;
		c.gridwidth = 10;
		c.gridheight = 10;
		c.insets = new Insets(0,0,5,90);
		c.anchor = GridBagConstraints.SOUTHWEST;
		pane.add(new Label("Brehuescu Andrei 30224"),c);
	

	}
	
	//getter & setter 
	

	public JTextField getText1() {
		return text1;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getSubButton() {
		return subButton;
	}

	public JButton getMulButton() {
		return mulButton;
	}

	public JButton getDivButton() {
		return divButton;
	}

	public JButton getIntButton() {
		return intButton;
	}

	public JButton getDerButton() {
		return derButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JTextField getText2() {
		return text2;
	}

	public JLabel getResult() {
		return result;
	}

	public JLabel getRest() {
		return rest;
	}
}

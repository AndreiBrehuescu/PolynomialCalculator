package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Operatii;
import Model.Polinom;
import Model.RezDiv;
import Model.WrongInputException;
import View.View;

public class Controller implements ActionListener{

	private View view;
	private Operatii op = new Operatii();
	
	public Controller(View view) {
		// TODO Auto-generated constructor stub
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//Adunare
		view.getRest().setText("");
		view.getResult().setText("");
		if( source == view.getAddButton() ) { 
			try {
				buttonPressed('+');
			}catch( WrongInputException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Wrong Input", JOptionPane.ERROR_MESSAGE);
			}
		}//Scadere
		else if( source == view.getSubButton() ){
			try {
				buttonPressed('-');
			}catch( WrongInputException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Wrong Input", JOptionPane.ERROR_MESSAGE);
			}
		}//Inmultire
		else if( source == view.getMulButton() ) {
			try {
				buttonPressed('*');
			}catch( WrongInputException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Wrong Input", JOptionPane.ERROR_MESSAGE);
			}
		}//Impartire
		else if( source == view.getDivButton() ) {
			try {
				buttonPressed('/');
			}catch( WrongInputException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Wrong Input", JOptionPane.ERROR_MESSAGE);
			}
		}//Integrare
		else if( source == view.getIntButton() ) {
			try {
				view.getText2().setText("");
				buttonPressed('|');
			}catch( WrongInputException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Wrong Input", JOptionPane.ERROR_MESSAGE);
			}
		}//Derivare
		else if( source == view.getDerButton() ) {
			try {
				buttonPressed('`');
			}catch( WrongInputException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Wrong Input", JOptionPane.ERROR_MESSAGE);
			}
		}else if( source == view.getClearButton() ) {
				view.getText1().setText("");
				view.getText2().setText("");
		}
		
	}
	
	
	public void buttonPressed(char b) throws WrongInputException {
		Polinom p1,p2,result = null;
		RezDiv rez = null;
		String s ="";
		if( view.getText1().getText().equals("") == false && view.getText2().getText().equals("") == false ) {
			p1 = new Polinom(view.getText1().getText());
			p2 = new Polinom(view.getText2().getText());
			switch(b) {
				case '+':
					result = op.addPolinoms(p1, p2);
					break; 
				case '-':
					result = op.subPolinoms(p1, p2);
					break;
				case '*':
					result = op.mulPolinoms(p1, p2);
					break;
				case '/':
					rez = op.divPolinoms(p1, p2);
					break;
				default :
					JOptionPane.showMessageDialog(null, "Wrong Input for the selected action", "Input Error",JOptionPane.ERROR_MESSAGE);
					return ;
			}
			if( b != '/') {
		
				if( checkResult(result) == false ) {
					view.getResult().setText("0");
				}else
					view.getResult().setText(result.toString());
			}else {
				if( b == '/' )
					view.getRest().setText(rez.getRest().toString());
				view.getResult().setText(rez.getRezultat().toString()); 
			}
		}else if( view.getText1().getText().equals("") == false && (b == '`' || b == '|') ) {
			p1 = new Polinom(view.getText1().getText());
			if( b == '`') {
				result = op.derPolinom(p1);
			}else if( b == '|'){
				result = op.intPolinom(p1);
			}
			if( checkResult(result) == false ) {
				view.getResult().setText("0");
			}else
				view.getResult().setText(result.toString()); 
		}
		else {
			JOptionPane.showMessageDialog(null, "Empty field", "Input Error",JOptionPane.ERROR_MESSAGE);
			return ;
		}
	}
	
	public boolean checkResult(Polinom p) {
		if( p.getList().size() == 0 ) {
			return false;
		}else {
			return true;
		}
	}

}

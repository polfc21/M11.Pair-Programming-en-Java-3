package com.nivel3.view;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ShowInfoWindow {

	public static void showInfo(String message){
		JOptionPane.showMessageDialog(null, message);
	}

	public static void showInfo(List<String> list) {
		StringBuilder listString = new StringBuilder();

		for (String s : list) {
			listString.append(s.toString() + "\n");
		}
		JTextArea msg = new JTextArea(listString.toString());
		msg.setLineWrap(true);
		msg.setWrapStyleWord(true);
		msg.setRows(list.size()+2);
		msg.setSize(900, 300);

		JScrollPane scrollPane = new JScrollPane(msg);

		JOptionPane.showMessageDialog(null, scrollPane);

	}

	public static void showInfoStocks(String msg, List<String> list, double totalValue) {
		StringBuilder listString = new StringBuilder("Stock de " + msg + ":\n");
		for(String s : list) {
			listString.append(s.toString() +"\n");
		}
		listString.append("\nCANTIDAD TOTAL "+ msg +" = " + list.size());
		listString.append("\nVALOR TOTAL STOCK "+ msg +" = " + totalValue + "€");
		JTextArea string = new JTextArea(listString.toString());
		string.setLineWrap(true);
		string.setWrapStyleWord(true);
		string.setRows(list.size()+5);
		string.setSize(900, 300);

		JScrollPane scrollPane = new JScrollPane(string);

		JOptionPane.showMessageDialog(null, scrollPane);

	}

}

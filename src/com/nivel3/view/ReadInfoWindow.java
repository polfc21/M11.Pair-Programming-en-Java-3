package com.nivel3.view;


import java.util.List;

import javax.swing.JOptionPane;

public class ReadInfoWindow {

	public static String readString(MessageView messageView) {
		boolean end = false;
		String input = "";
		do{
			input =
					JOptionPane.showInputDialog(null, messageView.getMessage(),
							messageView.getTitle(), JOptionPane.QUESTION_MESSAGE);
			if (input == null){
				end = true;
			} else if (!input.equals("")){
				end = true;
			}else{
				ShowInfoWindow.showInfo("CAMPO OBLIGATORIO.");
			}
		}while (!end);
		return input;
	}

	public static int readId(MessageView messageView, int superiorLimit) {
		int input = 0;
		boolean end = false;
		String inputString = "";
		do{
			inputString = readString(messageView);
			if (inputString == null){
				end = true;
			} else{
				try {
					input = Integer.parseInt(inputString);
					if (0 >= input || input > superiorLimit){
						ShowInfoWindow.showInfo("ERROR. ID INEXISTENTE.");
						input = 0;
					} else {
						end = true;
					}
				} catch (Exception e) {
					ShowInfoWindow.showInfo("ERROR. INTRODUCE UN VALOR NUMERICO.");
				}
			}
		} while (!end);

		return input;
	}
	
	public static int readIdProduct(MessageView messageView, List<Integer> list) {
		int input = 0;
		boolean end = false;
		String inputString = "";
		do {
			inputString = readString(messageView);
			if(inputString == null) {
				end = true;
			}else {
				try {
				input = Integer.parseInt(inputString);
				if(!list.contains(input)) {
					ShowInfoWindow.showInfo("ERROR. ID INEXISTENTE EN ESTE STOCK.");
					input = 0;
					} else {
						end = true;
					}
				}catch (Exception e) {
					ShowInfoWindow.showInfo("ERROR. INTRODUCE UN VALOR NUMERICO.");
				}
			}
		}while(!end);
		return input;
	}

	public static double readDouble(MessageView messageView) {
		double input = 0;
		boolean end = false;
		String inputString = "";
		do{
			inputString = readString(messageView);
			if (inputString == null){
				end = true;
			}else{
				try {
					input = Double.parseDouble(inputString);
					if (input <= 0) {
						ShowInfoWindow.showInfo("ERROR. VALOR INCORRECTO.");
					}else {
						end = true;
					}
				} catch (Exception e) {
					ShowInfoWindow.showInfo("ERROR. INTRODUCE UN VALOR NUMERICO.");
				}
			}
		} while (!end);
		return input;
	}
}

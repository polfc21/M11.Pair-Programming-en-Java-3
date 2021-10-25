package com.nivel3.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.nivel3.view.utils.Command;

public class Menu {
	
	private List<Command> commands;
	
	public Menu(Set<Command> commandSet) {
		this.commands = new ArrayList<Command>(commandSet);
	}
	
	public Command execute() {
		List<Command> activeCommands =
				commands.stream().filter(s -> s.getIsActive()==true).collect(Collectors.toList());
		return activeCommands.get(this.getOption(activeCommands));
	}
	
	private int getOption(List<Command> activeCommands) {
		Object[] buttons =
				activeCommands.stream().map(s -> s.getTitle()).collect(Collectors.toList()).toArray();
		int option =
				JOptionPane.showOptionDialog(null, "Elige una opción", "MENU",
						JOptionPane.YES_NO_OPTION, 3, null, buttons, buttons[0]);
		return option;
	}
	
}

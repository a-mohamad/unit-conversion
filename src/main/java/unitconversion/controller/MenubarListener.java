package unitconversion.controller;

import unitconversion.model.command.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public record MenubarListener(HashMap<String, Command> commands) implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SAVE" -> {
                System.err.println("SAVED");
                commands.get("SAVE").execute();
            }
            case "ENABLE" -> {
                System.err.println("ENABLED");
                commands.get("ENABLE").execute();
            }
            default -> throw new RuntimeException("Invalid action command " + e.getActionCommand());
        }
    }
}

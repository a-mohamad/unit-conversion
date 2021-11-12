package unitconversion.controller;

import unitconversion.model.command.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * The type Menubar listener which is used to listen to action commands pressed in the menubar.
 * The precondition is that the Menubar exists and is clickable, and the post condition is that
 * given a valid numeric is entered inside of centimeters panel then either selecting SAVE or
 * if ENABLE was selected beforehand the feet and meters panel will update automatically.
 */
public record MenubarListener(HashMap<String, Command> commands) implements ActionListener {
    /**
     * Provided an action that was performed in the menu bar that is selecting SAVE or
     * ENABLE the appropriate commands will then be executed. Precondition is that all ActionEvents
     * in the menu bar are captured, and post condition is that SAVE and ENABLE commands are processed
     * provided they are inputted.
     *
     * @param e is the ActionEvent that was entered by the user.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SAVE" -> commands.get("SAVE").execute();
            case "ENABLE" -> commands.get("ENABLE").execute();
            default -> throw new RuntimeException("Invalid action command " + e.getActionCommand());
        }
    }
}

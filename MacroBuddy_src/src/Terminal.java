
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Terminal {

    JTextArea terminalWindow;

    public Terminal() {

        terminalWindow = new JTextArea();
        terminalWindow.setColumns(20);
        terminalWindow.setForeground(Color.white);
        terminalWindow.setBackground(Color.black);

    }

}

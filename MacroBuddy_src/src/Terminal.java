
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Terminal{

    JTextArea terminalWindow;
    ArrayList<String> current_commands = new ArrayList<String>();
    String current_command;

    public Terminal() {

        terminalWindow = new JTextArea();
        terminalWindow.setColumns(20);
        terminalWindow.setForeground(Color.white);
        terminalWindow.setBackground(Color.black);
        terminalWindow.setCaretColor(Color.WHITE);

        terminalWindow.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e){

                int row = 0;
                try {
                    row = terminalWindow.getLineOfOffset(terminalWindow.getCaretPosition());
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
                if (row + 1 < terminalWindow.getLineCount()) {
                    terminalWindow.setCaretPosition(terminalWindow.getDocument().getLength());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public void capture_commands(){
        for (String line : terminalWindow.getText().split("\\n")) {
            current_commands.add(line);
            System.out.println("HERE's A LINE: " + current_command);
        }
    }



}


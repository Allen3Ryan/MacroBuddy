import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {

    int count = 0;
    JLabel label;
    public GUI () {
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Record recordButton = new Record();
        Execute executeButton = new Execute();
        Terminal terminal = new Terminal();
        MacroGrid macroGrid = new MacroGrid(executeButton);

        JPanel panel = new JPanel();
        macroGrid.panel = panel;
        panel.setLayout(null);

        executeButton.button.setBounds((screenSize.width/2+20), (screenSize.height-150),(screenSize.width/2-60),(50)); // formerly 460, 462, 430, 100
        panel.add(executeButton.button);

        recordButton.button.setBounds((screenSize.width/2+20), (screenSize.height-225),(screenSize.width/2-60),(50)); // formerly 460, 312, 430, 100
        panel.add(recordButton.button);

        macroGrid.populateMacroGrid(panel);

        terminal.terminalWindow.setBounds(10,10,(screenSize.width/2)-20,screenSize.height-100); // formerly 10,10,430,550
        terminal.terminalWindow.setAlignmentY(0);
        JScrollPane scrollPane = new JScrollPane(terminal.terminalWindow, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10,10,(screenSize.width/2)-20,screenSize.height-100); // formerly 10,10,430,550
        panel.add(scrollPane);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Macro Buddy");
        frame.pack();
        frame.setSize(screenSize.width,screenSize.height); // formerly 900, 600
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }


}

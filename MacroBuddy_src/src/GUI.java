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
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Terminal terminal = new Terminal();
        Execute executeButton = new Execute(terminal);
        MacroGrid macroGrid = new MacroGrid(executeButton, terminal);
        Record recordButton = new Record(terminal.terminalWindow, frame);

        JPanel panel = new JPanel();
        macroGrid.panel = panel;
        panel.setLayout(null);

        executeButton.button.setBounds(460,462,410,50); // formerly 460, 462, 430, 100
        panel.add(executeButton.button);

        recordButton.button.setBounds(460,392,410,50); // formerly 460, 312, 430, 100
        panel.add(recordButton.button);

        macroGrid.populateMacroGrid(panel);

        terminal.terminalWindow.setBounds(10,10,430,550);
        terminal.terminalWindow.setAlignmentY(0);
        JScrollPane scrollPane = new JScrollPane(terminal.terminalWindow, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10,10,430,550);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Macro Buddy");
        frame.pack();
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }


}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {

    int count = 0;
    JLabel label;
    public GUI () {
        JFrame frame = new JFrame();

        Record recordButton = new Record();
        Execute executeButton = new Execute();
        Terminal terminal = new Terminal();
        MacroGrid macroGrid = new MacroGrid();


        JPanel panel = new JPanel();
        macroGrid.panel = panel;
        panel.setLayout(null);
        recordButton.button.setBounds(460,462,430,100);
        panel.add(recordButton.button);

        executeButton.button.setBounds(460,312,430,100);
        panel.add(executeButton.button);

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
        frame.setSize(900,600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }


}

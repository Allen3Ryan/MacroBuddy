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


        JPanel panel = new JPanel();
        panel.setLayout(null);
        recordButton.button.setBounds(460,462,430,100);
        panel.add(recordButton.button);

        executeButton.button.setBounds(460,312,430,100);
        panel.add(executeButton.button);


        Integer gridX = 460;
        Integer gridY = 50;
        for(int i = 0; i < 9; i++) {
            MacroButton macroButton = new MacroButton();
            macroButton.button.setText("Macro "+String.valueOf(i+1));
            macroButton.button.setBounds(gridX,gridY, 123, 60);
            panel.add(macroButton.button);

            gridX += 150;
            if(i == 2 || i == 5) gridY += 80;
            if(i == 2 || i == 5) gridX = 460;

        }

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

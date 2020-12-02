
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Execute {

    JButton button;
    File input;
    String bName = "No Macro Loaded";
    BufferedReader reader;
    boolean canExecute = false;
    public Execute(Terminal terminal) {

        button = new JButton(bName); //Formerly "Execute"
        button.setPreferredSize(new Dimension(200,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    if (canExecute == true){
                        executeMacro(terminal);
                        }
                    }
                }
        );
    }

    public void mLoaded(String mName, BufferedReader n_reader) {
        String txt = ".txt";
        String blank = "";
        mName = mName.replaceFirst(txt, blank);
        bName = mName + " ready to execute";
        this.button.setText(bName);
        reader = n_reader;
        canExecute = true;
    }

    public void executeMacro(Terminal terminal) {
        try {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                terminal.print_line(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
            canExecute = false;
            bName = "No Macro Loaded";
            this.button.setText(bName);
        } catch (IOException h) {
            h.printStackTrace();
        }
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Execute {

    JButton button;
    File input;
    String bName = "No Macro Loaded";
    BufferedReader reader;
    boolean canExecute = false;
    Terminal terminal;

    public Execute(Terminal _terminal) {
        terminal = _terminal;
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
        bName = "Execute " + mName;
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
                //run process
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c " + line); // windows version
					//Process process = Runtime.getRuntime().exec(line); mac version
                    printResults(process, terminal);
                }
                catch (IOException e) {
                    terminal.terminalWindow.setText(e.toString());
                }
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

    public static void printResults(Process process, Terminal terminal) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        String lines = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            lines += line;
        }
        terminal.terminalWindow.setText(lines);
    }
}



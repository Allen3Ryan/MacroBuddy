import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MacroButton {

    JButton button;
    int bNum = 0;
    String location = "no_file_loc";
    String name;
    String dateCreated;
    String lName;
    Execute executeButton;
    BufferedReader reader;

    public MacroButton(Terminal terminal, Execute _executeButton) {
        button = new JButton(name);
        executeButton = _executeButton;
        button.setPreferredSize(new Dimension(50,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fetchMacro(location, terminal);
                        executeButton.mLoaded(name, reader);
                    }
                }
        );
    }

    public void Init_name(String mName) {
    name = mName;
    }

    public void setNum (int _bNum)
    {
        bNum = _bNum;
        int i = 0;
        try{
            RandomAccessFile file = new RandomAccessFile("manifest/manifest.txt", "r");
            String line;
            while(i != bNum && (line = file.readLine()) != null) {
                i++;
                if(i == bNum)
                {
                    location = line;
                }
                else
                    location = "no_file_loc";
            }
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void fetchMacro(String location, Terminal terminal) {
    if(location != "no_file_loc") {
        name = location;
        lName = ("macros/" + location + ".txt");
        try {
            reader = new BufferedReader(new FileReader(lName));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                terminal.print_line(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
            File file = new File(lName);
            reader = new BufferedReader(new FileReader(file));
            } catch (IOException h){
            h.printStackTrace();
            }

        }
    }
}

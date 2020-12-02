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

    public MacroButton(Terminal terminal) {
        button = new JButton(name);
        button.setPreferredSize(new Dimension(50,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fetchMacro(location, terminal);
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
    lName = ("macros/" + location + ".txt");
        BufferedReader reader;
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
            } catch (IOException h){
            h.printStackTrace();
            }

        }
    }
}

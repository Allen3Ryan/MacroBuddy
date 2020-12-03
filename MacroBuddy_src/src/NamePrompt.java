import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class NamePrompt {

    JTextField nameField;
    JLabel label;
    JButton submitButton;
    String name = "";
    String text = "";
    MacroGrid macroGrid;
    JPanel mainPanel;

    public NamePrompt(String fileContents, MacroGrid _macroGrid, JPanel _mainPanel) {

        nameField = new JTextField();
        label = new JLabel();
        submitButton = new JButton();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        macroGrid = _macroGrid;
        mainPanel = _mainPanel;


        label.setText("Choose a name for your macro");
        label.setBounds(50, 20, 200, 50);
        nameField.setBounds(50,100,200, 20);
        submitButton.setText("Save");
        submitButton.setBounds(50, 150, 200, 25);

        panel.add(label);
        panel.add(nameField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Specify Macro Name");
        frame.pack();
        frame.setSize(300, 250);
        frame.setResizable(false);
        frame.setVisible(true);

        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (nameField.getText() != "") {
                            name = nameField.getText();
                            storeInput(fileContents, name);
                            populateManifestFile();
                            macroGrid.populateMacroGrid(mainPanel);
                            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                }
        );

    }

    public void populateManifestFile() {
        File theDir = new File("manifest");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        /*File file = new File("manifest/manifest.txt");
        boolean exists = file.exists();
        if (exists == false) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }

        try (PrintWriter out = new PrintWriter("manifest/manifest.txt")) {
            //out.println(name + " - " + System.currentTimeMillis());
            out.println(name + "\n");
        }
        catch (FileNotFoundException e1) {
            System.out.println(e1);
        }*/
        File file = new File("manifest/manifest.txt");
        try {
            FileWriter fr = new FileWriter(file, true);
            fr.write(name + "\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void storeInput(String text, String name) {
        //store that input

        File theDir = new File("macros");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        File file = new File("macros/" + name + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }

        try (PrintWriter out = new PrintWriter("macros/" + name + ".txt")) {
            out.println(text);
        }
        catch (FileNotFoundException e1) {
            System.out.println(e1);
        }

    }

}

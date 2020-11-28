import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class fileChoose {
    JButton openButton;
    JFileChooser chooser;

    public fileChoose() {

        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        openButton = new JButton("Open a File");
        openButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rVal = chooser.showOpenDialog(null);
                        if (rVal == JFileChooser.APPROVE_OPTION){
                        //if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                            File file = chooser.getSelectedFile();
                            //open/load the file here
                        }
                    }
                }
        );
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        //add(buttonPanel, BorderLayout.PAGE_START);
    }
}
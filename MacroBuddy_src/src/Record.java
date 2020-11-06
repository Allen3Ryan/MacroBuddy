import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Record {

    JButton button;
    Boolean isRecording;
    File input;

    public Record() {

        button = new JButton("Record");
        button.setPreferredSize(new Dimension(200,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startRecording();
                    }
                }
        );
    }

    public void startRecording() {
        isRecording = true;
    }

    public void finishRecording() {
       getInput();
       storeInput();
       processInput();
    }

    private void getInput() {
        // GET THAT INPUT
    }

    private void storeInput() {
        //store that input
    }

    private void processInput() {
        //process that input
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Record {

    JButton button;
    Boolean isRecording = false;
    File input;
    String bName = "Start Recording";

    public Record() {

        button = new JButton(bName);
        button.setPreferredSize(new Dimension(200,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(isRecording == false){
                            button.setText("Stop Recording");
                            startRecording();
                        }
                        else {
                            button.setText("Start Recording");
                            finishRecording();
                        }
                    }
                }
        );
    }

    public void startRecording() {
        isRecording = true;
    }

    public void finishRecording() {
        isRecording = false;
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

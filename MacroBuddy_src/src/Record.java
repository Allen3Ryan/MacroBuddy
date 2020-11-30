import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Record {

    JButton button;
    Boolean isRecording = false;
    File input;
    String bName = "Start Recording";
    String fileContents = "";
    JTextArea textArea;
    JFrame jframe;

    public Record(JTextArea _textArea, JFrame _jframe) {

        jframe = _jframe;
        textArea = _textArea;
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

                            finishRecording(textArea);
                        }
                    }
                }
        );
    }

    public void startRecording() {
        isRecording = true;
    }

    public void finishRecording(JTextArea textArea) {
        isRecording = false;
        getInput(textArea);
        NamePrompt namePrompt = new NamePrompt(fileContents);
        processInput();
    }

    private void getInput(JTextArea textArea) {
        // GET THAT INPUT
        fileContents = textArea.getText();
    }

    private void processInput() {
        //process that input
    }

}

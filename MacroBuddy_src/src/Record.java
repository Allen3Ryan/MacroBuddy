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
    String areaSaver = "";
    String blank = "";
    JTextArea textArea;
    JFrame jframe;
    MacroGrid macroGrid;

    public Record(JTextArea _textArea, JFrame _jframe, MacroGrid _macroGrid) {

        macroGrid = _macroGrid;
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
        textArea.append("\n");
        areaSaver = textArea.getText();
    }

    public void finishRecording(JTextArea textArea) {
        isRecording = false;
        getInput(textArea);
        NamePrompt namePrompt = new NamePrompt(fileContents, macroGrid, macroGrid.panel);
        processInput();
    }

    private void getInput(JTextArea textArea) {
        // GET THAT INPUT
        fileContents = textArea.getText();
        fileContents = fileContents.replaceFirst(areaSaver, blank);
    }

    private void processInput() {
        //process that input
    }

}

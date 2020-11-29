import javax.crypto.Mac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MacroGrid {
    MacroButton[] macroButtons;
    Integer pageNumber;
    JButton leftPageButton;
    JButton loadMacroButton;
    JButton rightPageButton;
    JPanel panel;
    String lName = "";

    MacroGrid(Execute executeButton) {
        macroButtons = new MacroButton[9];
        pageNumber = 0;
        //fileChoose fDirect = new fileChoose();

        for (int i = 0; i < 9; i++) {
            macroButtons[i] = new MacroButton();
        }

        leftPageButton = new JButton("<");
        leftPageButton.setPreferredSize(new Dimension(50, 50));
        leftPageButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pageNumber > 0) {
                            pageNumber--;
                        }
                        populateMacroGrid(panel);
                    }
                }
        );

        loadMacroButton = new JButton("Load Macro");
        loadMacroButton.setPreferredSize(new Dimension(50, 50));
        loadMacroButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //JFrame fileFrame = new JFrame("File Directory");
                        //fileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        //fileFrame.add(fDirect.chooser);
                        //fileFrame.pack();
                        //fileFrame.setVisible(true);
                        JFileChooser chooser = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents", "txt");
                        chooser.setFileFilter(filter);
                        int returnVal = chooser.showOpenDialog(null);
                        if (returnVal == JFileChooser.APPROVE_OPTION) {
                            System.out.println("You opened: " + chooser.getSelectedFile().getName());
                            lName = chooser.getSelectedFile().getName();
                            executeButton.mLoaded(lName);
                        }
                    }
                }
        );


        rightPageButton = new JButton(">");
        rightPageButton.setPreferredSize(new Dimension(50, 50));
        rightPageButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pageNumber < 8) {
                            pageNumber++;
                        }
                        populateMacroGrid(panel);
                    }
                }
        );
    }

    public void setPanel(JPanel _panel) {
        panel = _panel;
    }

    public void populateMacroGrid(JPanel panel) {
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Integer gridX = 460;
        Integer gridY = 50;

        for (int i = 0; i <= 12; i++) {
            if (i < 9) {
                macroButtons[i].button.setText("Slot " + String.valueOf(9 * pageNumber + i + 1));
                macroButtons[i].button.setBounds(gridX, gridY, 120, 60);
                panel.add(macroButtons[i].button);
            }

            if (i == 9) {
                leftPageButton.setText("<");
                leftPageButton.setBounds(gridX, gridY, 120, 60);
                panel.add(leftPageButton);
            }

            if (i == 10) {
                loadMacroButton.setText("Load Macro");
                loadMacroButton.setBounds(gridX, gridY, 120, 60);
                panel.add(loadMacroButton);
            }

            if (i == 11) {
                rightPageButton.setText(">");
                rightPageButton.setBounds(gridX, gridY, 120, 60);
                panel.add(rightPageButton);
            }

            gridX += 150;
            if (i == 2 || i == 5 || i == 8) {
                gridY += 80;
                gridX = 460;
            }
        }
    }
}


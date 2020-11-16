import javax.crypto.Mac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MacroGrid {
    MacroButton[] macroButtons;
    Integer pageNumber;
    JButton leftPageButton;
    JButton rightPageButton;
    JPanel panel;

    MacroGrid() {
        macroButtons = new MacroButton[6];
        pageNumber = 0;

        for(int i = 0; i < 6; i++) {
            macroButtons[i] = new MacroButton();
        }

        leftPageButton = new JButton("<");
        leftPageButton.setPreferredSize(new Dimension(50,50));
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

        rightPageButton = new JButton(">");
        rightPageButton.setPreferredSize(new Dimension(50,50));
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
        Integer gridX = 460;
        Integer gridY = 50;

        for(int i = 0; i <= 9; i++) {
            if (i < 6) {
                macroButtons[i].button.setText("Macro "+String.valueOf(6 * pageNumber + i + 1));
                macroButtons[i].button.setBounds(gridX,gridY, 123, 60);
                panel.add(macroButtons[i].button);
            }

            if (i == 6) {
                leftPageButton.setText("<");
                leftPageButton.setBounds(gridX, gridY, 123, 60);
                panel.add(leftPageButton);
            }

            if (i == 8) {
                rightPageButton.setText(">");
                rightPageButton.setBounds(gridX, gridY, 123, 60);
                panel.add(rightPageButton);
            }

            gridX += 150;
            if(i == 2 || i == 5) {
                gridY += 80;
                gridX = 460;
            }
        }
    }
}

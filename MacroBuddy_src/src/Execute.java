
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Execute {

    JButton button;
    File input;
    String bName = "No Macro Loaded";
    public Execute() {

        button = new JButton(bName); //Formerly "Execute"
        button.setPreferredSize(new Dimension(200,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
    }
    public void mLoaded(String mName) {
    bName = mName + " ready to execute";
    this.button.setText(bName);
    }

}

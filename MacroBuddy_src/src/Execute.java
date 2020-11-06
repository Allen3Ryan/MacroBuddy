
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Execute {

    JButton button;
    File input;

    public Execute() {

        button = new JButton("Execute");
        button.setPreferredSize(new Dimension(200,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
    }

}

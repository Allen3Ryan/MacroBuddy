import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MacroButton {

    JButton button;
    String location;
    String name;
    String dateCreated;

    public MacroButton() {
        
        button = new JButton(name);
        button.setPreferredSize(new Dimension(50,50));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fetchMacro(location);
                    }
                }
        );
    }

    private void fetchMacro(String location) {

    }
}

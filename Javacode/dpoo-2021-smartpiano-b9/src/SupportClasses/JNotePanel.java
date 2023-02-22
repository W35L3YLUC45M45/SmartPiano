package SupportClasses;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type J note panel.
 */
public class JNotePanel {
    private KeyMap km;

    private JPanel notePanel;
    private JLabel note;
    private JButton noteButton;

    private String ActionCommand;

    /**
     * Instantiates a new J note panel.
     *
     * @param km            the km
     * @param text          the text
     * @param background    the background
     * @param foreground    the foreground
     * @param ActionCommand the action command
     */
    public JNotePanel(KeyMap km, String text, Color background, Color foreground, String ActionCommand){
        this.km = km;
        this.ActionCommand = ActionCommand;

        notePanel = new JPanel();
        notePanel.setLayout(new FlowLayout());
        note = new JLabel(text);
        note.setFont(new Font(note.getName(), Font.PLAIN, 20));
        noteButton = new JButton(km.getValue(ActionCommand));
        noteButton.setFont(new Font(note.getName(), Font.PLAIN, 20));
        noteButton.setPreferredSize(new Dimension(30, 30));
        noteButton.setBackground(background);
        noteButton.setForeground(foreground);
        noteButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        noteButton.setActionCommand(ActionCommand);
        notePanel.add(note);
        notePanel.add(noteButton);
        notePanel.setBackground(Color.WHITE);
    }

    /**
     * Set text.
     */
    public void setText (){
        noteButton.setText(km.getValue(this.ActionCommand));
    }

    /**
     * Set border.
     *
     * @param border the border
     */
    public void setBorder (Border border){
        notePanel.setBorder(border);
    }

    /**
     * Register controller.
     *
     * @param controller the controller
     */
    public void registerController(ActionListener controller){
        noteButton.addActionListener(controller);
    }

    /**
     * Get panel j panel.
     *
     * @return the j panel
     */
    public JPanel getPanel(){
        return notePanel;
    }
}

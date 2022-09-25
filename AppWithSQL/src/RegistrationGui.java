import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RegistrationGui extends JFrame {
    private JTextField loginField;
    private JTextField passwordField;
    private JLabel passwordLabel;
    private JLabel loginLabel;
    private JButton submitButton;
    private JButton returnButton;
    private JPanel mainPanel;
    ConnectDB db;


    public RegistrationGui(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

        db = new ConnectDB();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.insertData(loginField.getText(), passwordField.getText());
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGui loginGui = new LoginGui("Login");
            }
        });
    }
}

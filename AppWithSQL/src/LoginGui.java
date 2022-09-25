import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame{

    public checkData check;

    Main main;
    private JPanel mainPanel;
    private JTextField loginField;
    private JTextField passwordField;
    private JButton submitButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JButton registrationButton;

    public LoginGui(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = new checkData(loginField.getText(), passwordField.getText());
                main = Main.starter;
                main.dataCheck(check);
            }
        });

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistrationGui registrationGui = new RegistrationGui("Registration");
            }
        });
    }

    public LoginGui() {

    }

    public checkData getCheck() {
        return check;
    }
}

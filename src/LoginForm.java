import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JTextField textField1;

    public LoginForm(JFrame owner) {
        this.owner = owner;
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnLogin) {
                    System.out.println("Am apasat butonul de login");
                    try {
                        Application.getInstance().login(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
                        JOptionPane.showMessageDialog(null, "Login successfully!");
                        mainPanel.setVisible(false);
                        owner.setContentPane(new TeacherForm(owner).getPanel1());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }

        });

        btnbutonCreare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnbutonCreare) {
                    System.out.println("New account");
                    UserAccountType tip = UserAccountType.valueOf(textField1.getText());
                    try {
                        Application.getInstance().createNewUser(new User(txtUsername.getText(), new String(txtPassword.getPassword()), tip ));
                        JOptionPane.showMessageDialog(null, "Added successfully!");
                        mainPanel.setVisible(false);
                        owner.setContentPane(new TeacherForm(owner).getPanel1());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnbutonCreare;
    private JTextField textField2;
    private JTextField textField3;
    private JFrame owner;
}

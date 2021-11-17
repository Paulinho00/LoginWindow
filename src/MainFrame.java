import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame implements ActionListener {

    private Map<String, char[]> users = new HashMap<>();
    private JPanel panelLogin;
    private JButton buttonConfirm, buttonCancel;
    private JTextField textFieldLoginValue;
    private JPasswordField passwordField;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setSize(250,200);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public MainFrame(){
        createUsers();

        panelLogin = new JPanel();
        panelLogin.setSize(250,200);
        panelLogin.setLayout(null);
        add(panelLogin);

        JLabel labelLogin = new JLabel("User");
        labelLogin.setBounds(20,10,60,20);
        panelLogin.add(labelLogin);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(20, 40, 60, 20);
        panelLogin.add(labelPassword);

        textFieldLoginValue = new JTextField("");
        textFieldLoginValue.setBounds(90,10,100,20);
        panelLogin.add(textFieldLoginValue);

        passwordField = new JPasswordField("");
        passwordField.setBounds(90, 40, 100, 20);
        panelLogin.add(passwordField);

        buttonConfirm = new JButton("Confirm");
        buttonConfirm.setBounds(30,70,85,25);
        buttonConfirm.addActionListener(this);
        panelLogin.add(buttonConfirm);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(120,70,85,25);
        buttonCancel.addActionListener(this);
        panelLogin.add(buttonCancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == buttonConfirm){
            if(users.containsKey(textFieldLoginValue.getText())){
                char[] password = passwordField.getPassword();
                char[] correctPasword = users.get(textFieldLoginValue.getText());
                if(Arrays.equals(password, correctPasword)){
                    panelLogin.setBackground(Color.GREEN);
                }
                else{
                    panelLogin.setBackground(Color.RED);
                }
            }
            else{
                panelLogin.setBackground(Color.RED);
            }
        }
        if(source == buttonCancel){
            textFieldLoginValue.setText("");
            passwordField.setText("");
            panelLogin.setBackground(UIManager.getColor("Panel.background"));
        }
    }

    private void createUsers(){
        users.put("adam", new char[]{'m', 'o', 'c', 'n', 'e', '-', 'h', 'a', 's', 'l', 'o', '1', '2', '3'});
        users.put("azor23", new char[]{'k', 'a', 'r', 'u', 'z', 'e', 'l', 'a', '5', '9'});
        users.put("cwaniak123", new char[]{'t', '$', '2', '1', 's', 'a', 'f', '(', ')'});
        users.put("kolega25", new char[]{'u', 'l', 'i', 'c', 'a', 's', 'e', 'z', 'a', 'm', 'k', 'o', 'w', 'a'});
        users.put("damian30", new char[]{'z', 'g', 'o', 'r', 'z', 'e', 'l','e','c','2','3','5','!'});
    }
}

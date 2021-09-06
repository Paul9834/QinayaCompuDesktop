package ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login {
    private JButton button1;
    private JTextField ingreseContraseñaTextField;
    private JTextField ingreseCorreoTextField;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Qinaya Compu");


    }

    public Login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
    }


}

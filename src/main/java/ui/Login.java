package ui;
import api.RetrofitClient;
import entities.LoginResponse;
import entities.LoginUser;
import entities.UserMachines;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
public class Login extends JFrame {
    private JButton button1;
    private JTextField ingreseCorreoTextField;
    private JPanel mainPanel;
    private JPasswordField contraseña_field;
    private JLabel icon_qinaya;

    public static void main(String[] args) {
       Login login = new Login();
    }

    public Login() {




        setContentPane(mainPanel);
        setTitle("Qinaya Compu");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        this.setLocationRelativeTo(null);

        ImageIcon logo_qin = new ImageIcon("leanbackqinaya.png");
        icon_qinaya.setIcon(logo_qin);



     /*   new Main().setVisible(true);
        setVisible(false);*/
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupLogin();
                //  JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
    }
    private void setupLogin() {
        String email = ingreseCorreoTextField.getText();
        String password = String.valueOf(contraseña_field.getPassword());


        if (!(email.isEmpty() || password.isEmpty())) {
            authUserFromAPI(email, password);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la información correcta en los campos");
        }
    }
    private void authUserFromAPI(String email, String password) {
        // JOptionPane.showMessageDialog(null, "Code " + email + " " + password);
        Call<LoginResponse> call = RetrofitClient.getInstance().getEndpoints().authUser(new LoginUser(email, password));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                //   JOptionPane.showMessageDialog(null, "Code " + response.code());
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        System.out.println("SU ID USER ES " + loginResponse.toString());
                        new Main(loginResponse.getIdUser()).setVisible(true);
                        setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hay un problema al iniciar sesión, por favor verifica tus datos");
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                JOptionPane.showMessageDialog(null, "Hay un problema con el servidor " + throwable.getMessage());
            }
        });
    }


}

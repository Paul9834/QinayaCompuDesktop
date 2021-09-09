package ui;
import api.RetrofitClient;
import entities.UserMachines;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class Main extends JFrame {

    private JButton INICIARCOMPUButton;
    private JPanel panel1;

    public Main() {

        setContentPane(panel1);
        setTitle("Inciar Compu");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //setVisible(true);
    }

    public Main(String id_user) {

/*
        System.out.println("SU ID USER ES " + id_user);
*/

        setContentPane(panel1);
        setTitle("Inciar Compu");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        INICIARCOMPUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int result = JOptionPane.showConfirmDialog(null, "¿Quieres iniciar tu compu?");

                if (JOptionPane.YES_OPTION == result) {
                    startCallAPI(id_user);
                }

            }
        });

    }

    void startCallAPI(String id_user) {
        Call<UserMachines> call = RetrofitClient.getInstance().getEndpoints( ).getDesktop(id_user);
        call.enqueue(new Callback<UserMachines>() {
            @Override
            public void onResponse(Call<UserMachines> call, Response<UserMachines> response) {
                System.out.println(" " + response.code());
                if(response.isSuccessful()) {
                    UserMachines userMachines = response.body();
                    String uri = userMachines.getUserMachine().getUrl();



                    try {
                        Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + uri});
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            @Override
            public void onFailure(Call<UserMachines> call, Throwable throwable) {
                JOptionPane.showMessageDialog(null, "Hay un problema con el servidor " + throwable.getMessage());
            }
        });

    }

}

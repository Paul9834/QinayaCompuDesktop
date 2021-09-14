package ui;
import api.RetrofitClient;
import entities.UserMachine;
import entities.UserMachines;
import ping_impl.qinayaPing;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class Main extends JFrame {

    private JButton INICIARCOMPUButton;
    private JPanel panel1;
    private JLabel id_1;
    private JLabel id_2;
    private JLabel id_3;
    private JButton PROBARCONEXIÓNButton;
    String url_mirage;
    private UserMachine mainMachine;

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
        setResizable(false);

        this.setLocationRelativeTo(null);

        startCallAPI(id_user);


        PROBARCONEXIÓNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                panel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                qinayaPing ping = new qinayaPing();

                ping.ipAddress = "8.8.8.8";
                ping.pingTimes = 10;
                //ping.timeOut = 500;
                ping.ping();


                if (ping.results.avgTime > 100) {

                    JOptionPane.showMessageDialog(null,
                            "Usted usará la conexión Mirage",
                            "Conexión a Qinaya",
                            JOptionPane.WARNING_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Usted usará la conexión RDP",
                            "Conexión a Qinaya",
                            JOptionPane.WARNING_MESSAGE);
                }

                panel1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));



            }
        });

        INICIARCOMPUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                        Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + url_mirage});
                    } catch (IOException e_) {
                        e_.printStackTrace();
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
                    mainMachine = userMachines.getUserMachine();
                    String uri = userMachines.getUserMachine().getUrl();
                    System.out.println(userMachines.toString());
                    url_mirage = uri;
                    INICIARCOMPUButton.setEnabled(true);

                    id_1.setText(mainMachine.getSistemaOperativo());
                    id_2.setText(mainMachine.getTiempoDisponible());
                    id_3.setText(mainMachine.getRdpHost());

                  /*  try {
                        Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + uri});
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/

                }
            }
            @Override
            public void onFailure(Call<UserMachines> call, Throwable throwable) {
                JOptionPane.showMessageDialog(null, "Hay un problema con el servidor " + throwable.getMessage());
            }
        });

    }

}

package vista;

import modelo.Repartidor;
import modelo.ZonaDeCarga;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private ZonaDeCarga zonaDeCarga;

    public VentanaPrincipal(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;

        setTitle("SpeedFast - Gestión de Entregas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JLabel lblTitulo = new JLabel("Sistema de Gestión SpeedFast", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnAsignar);

        add(panelBotones, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> {
            VentanaRegistroPedido ventReg = new VentanaRegistroPedido(zonaDeCarga);
            ventReg.setVisible(true);
        });

        btnListar.addActionListener(e -> {
            VentanaListaPedidos ventList = new VentanaListaPedidos(zonaDeCarga);
            ventList.setVisible(true);
        });

        btnAsignar.addActionListener(e -> iniciarEntregas());
    }

    private void iniciarEntregas() {
        Thread r1 = new Thread(new Repartidor("Alvaro", zonaDeCarga));
        Thread r2 = new Thread(new Repartidor("Fabian", zonaDeCarga));
        Thread r3 = new Thread(new Repartidor("Tomas", zonaDeCarga));

        r1.start();
        r2.start();
        r3.start();

        JOptionPane.showMessageDialog(this, "Se han asignado repartidores y se iniciaron las entregas.", "Proceso Iniciado", JOptionPane.INFORMATION_MESSAGE);
    }
}
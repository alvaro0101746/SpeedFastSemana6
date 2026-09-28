package vista;

import modelo.EstadoPedido;
import modelo.Pedido;
import modelo.ZonaDeCarga;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private ZonaDeCarga zonaDeCarga;

    public VentanaRegistroPedido(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;

        setTitle("SpeedFast - Registrar Pedido");
        setSize(380, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(2, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panelForm.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelForm.add(txtDireccion);

        panelForm.add(new JLabel("Tipo:"));
        String[] tipos = {"comida", "encomienda", "express"};
        cbTipo = new JComboBox<>(tipos);
        panelForm.add(cbTipo);

        add(panelForm, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Guardar Pedido");
        btnGuardar.addActionListener(e -> guardarPedido());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnGuardar);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void guardarPedido() {
        String direccion = txtDireccion.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo dirección es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pedido nuevo = new Pedido(0, direccion, tipo, EstadoPedido.PENDIENTE);
        zonaDeCarga.agregarPedido(nuevo);

        JOptionPane.showMessageDialog(this, "Pedido registrado con éxito en la Base de Datos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        txtDireccion.setText("");
        cbTipo.setSelectedIndex(0);
    }
}
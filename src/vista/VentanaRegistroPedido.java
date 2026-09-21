package vista;

import modelo.EstadoPedido;
import modelo.Pedido;
import modelo.ZonaDeCarga;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private ZonaDeCarga zonaDeCarga;

    public VentanaRegistroPedido (ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;

        setTitle("SpeedFast - Registrar Pedido");
        setSize(380, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panelForm.add(new JLabel("ID Pedido:"));
        txtId = new JTextField();
        panelForm.add(txtId);

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
        String idText = txtId.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();

        if (idText.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pedido nuevo = new Pedido(id, direccion, tipo, EstadoPedido.PENDIENTE);
        zonaDeCarga.agregarPedido(nuevo);

        JOptionPane.showMessageDialog(this, "Pedido #" + id + " registrado con éxito.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        txtId.setText("");
        txtDireccion.setText("");
        cbTipo.setSelectedIndex(0);
    }
}

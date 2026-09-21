package vista;

import modelo.Pedido;
import modelo.ZonaDeCarga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private ZonaDeCarga zonaDeCarga;
    private JTable tablaPedidos;
    private DefaultTableModel modeloTabla;

    public VentanaListaPedidos(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;

        setTitle("SpeedFast - Listado de Pedidos");
        setSize(550, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        String[] columnas = {"ID", "Dirección", "Tipo", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPedidos = new JTable(modeloTabla);

        add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);

        JButton btnRefrescar = new JButton("Refrescar Tabla");
        btnRefrescar.addActionListener(e -> cargarDatos());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnRefrescar);
        add(panelBoton, BorderLayout.SOUTH);

        cargarDatos();
    }

    public void cargarDatos() {
        modeloTabla.setRowCount(0);
        List<Pedido> lista = zonaDeCarga.getTodosLosPedidos();
        for (Pedido p : lista) {
            Object[] fila = {p.getId(), p.getDireccionEntrega(), p.getTipoPedido(), p.getEstado()};
            modeloTabla.addRow(fila);
        }
    }
}

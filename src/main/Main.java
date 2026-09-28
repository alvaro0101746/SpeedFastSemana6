package main;

import modelo.ZonaDeCarga;
import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
            VentanaPrincipal ventana = new VentanaPrincipal(zonaDeCarga);
            ventana.setVisible(true);
        });
    }
}
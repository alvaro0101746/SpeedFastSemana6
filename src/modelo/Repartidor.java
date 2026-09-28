package modelo;

import dao.EntregaDAO;
import dao.PedidoDAO;
import java.sql.Date;
import java.sql.Time;

public class Repartidor implements Runnable {
    private int idRepartidor;
    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private EntregaDAO entregaDAO = new EntregaDAO();

    public Repartidor(int idRepartidor, String nombre, ZonaDeCarga zonaDeCarga) {
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            try {
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                pedidoDAO.actualizarEstado(pedido.getId(), EstadoPedido.EN_REPARTO);

                Thread.sleep(1500);

                pedido.setEstado(EstadoPedido.ENTREGADO);
                pedidoDAO.actualizarEstado(pedido.getId(), EstadoPedido.ENTREGADO);

                long ahora = System.currentTimeMillis();
                Entrega entrega = new Entrega(
                        pedido.getId(),
                        idRepartidor,
                        new Date(ahora),
                        new Time(ahora)
                );
                entregaDAO.guardar(entrega);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
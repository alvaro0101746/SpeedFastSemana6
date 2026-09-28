package modelo;

import dao.PedidoDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZonaDeCarga {
    private Queue<Pedido> colaPedidos = new LinkedList<>();
    private PedidoDAO pedidoDAO = new PedidoDAO();

    public ZonaDeCarga() {
        List<Pedido> desdeBD = pedidoDAO.listarTodos();
        for (Pedido p : desdeBD) {
            if (p.getEstado() == EstadoPedido.PENDIENTE) {
                colaPedidos.add(p);
            }
        }
    }

    public synchronized void agregarPedido(Pedido p) {
        if (pedidoDAO.guardar(p)) {
            colaPedidos.add(p);
        }
    }

    public synchronized Pedido retirarPedido() {
        return colaPedidos.poll();
    }

    public synchronized List<Pedido> getTodosLosPedidos() {
        return pedidoDAO.listarTodos();
    }
}
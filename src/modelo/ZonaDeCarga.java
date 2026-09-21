package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {
    private Queue<Pedido> colaPedidos = new LinkedList<>();
    private List<Pedido> todosLosPedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p) {
        colaPedidos.add(p);
        todosLosPedidos.add(p);
    }

    public synchronized Pedido retirarPedido() {
            return colaPedidos.poll();
        }

    public synchronized List<Pedido> getTodosLosPedidos() {
        return new ArrayList<>(todosLosPedidos);
    }
}


package modelo;

public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while(true) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            try {
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                Thread.sleep(1500);
                pedido.setEstado(EstadoPedido.ENTREGADO);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
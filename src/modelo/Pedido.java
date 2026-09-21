package modelo;

public class Pedido {
    private int id;
    private String direccionEntrega;
    private String tipoPedido;
    private EstadoPedido estado;

    public Pedido(int id, String direccionEntrega, String tipoPedido, EstadoPedido estado) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        this.estado = estado;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }
    public String getTipoPedido() { return tipoPedido; }
    public void setTipoPedido(String tipoPedido) { this.tipoPedido = tipoPedido; }
    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Pedido #" + id + "["  + tipoPedido +  "]  [Destino: " + direccionEntrega + " | Estado: " + estado + "]"; }
}

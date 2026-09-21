# SpeedFast - Interfaz Gráfica para Gestión de Entregas

Sistema en Java para la gestión de entregas en tiempo real. Permite la interacción mediante una interfaz gráfica de usuario (Java Swing) para registrar pedidos, visualizarlos en tablas y coordinar la entrega a múltiples repartidores de forma simultánea mediante hilos Thread, Runnable y acceso a recursos compartidos synchronized.

Estructura del Proyecto

src/

├── modelo/

│   ├── EstadoPedido.java

│   ├── Pedido.java

│   ├── ZonaDeCarga.java

│   └── Repartidor.java

├── vista/

│   ├── VentanaPrincipal.java

│   ├── VentanaRegistroPedido.java

│   └── VentanaListaPedidos.java

└── main/

└── Main.java


# Componentes

EstadoPedido: Enum que define los estados del ciclo de un envío (PENDIENTE, EN_REPARTO, ENTREGADO).

Pedido: Modelo que almacena la información de cada entrega (ID, dirección de entrega, tipo de pedido y estado).

ZonaDeCarga: Recurso compartido que almacena la cola de envíos y la lista de pedidos en memoria utilizando métodos sincronizados para evitar condiciones de carrera.

Repartidor: Clase que implementa Runnable para procesar las entregas en paralelo dentro de hilos independientes, actualizando el estado de cada pedido.

VentanaPrincipal: Interfaz gráfica principal (JFrame) que coordina la navegación hacia el formulario de registro, la tabla de pedidos y la asignación de repartidores.

VentanaRegistroPedido: Formulario visual para registrar nuevos pedidos con campos de texto y JComboBox, incluyendo validación de datos e interacción con JOptionPane.

VentanaListaPedidos: Interfaz visual con JTable y DefaultTableModel para listar y refrescar los pedidos registrados en el sistema.

Main: Clase principal del programa ubicada en el paquete main. Instancia la ZonaDeCarga e inicia la ejecución de la VentanaPrincipal.

# Ejecución

1.  Abre el proyecto en IntelliJ IDEA.


2. Ve a la ruta src/main/Main.java.


3. Ejecuta la clase Main para desplegar la ventana principal de la aplicación y utilizar la interfaz gráfica para registrar, listar y simular las entregas de pedidos.

Alvaro Moreno

Duoc UC
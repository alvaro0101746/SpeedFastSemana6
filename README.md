# SpeedFast - Interfaz Gráfica para Gestión de Entregas

Sistema en Java para la gestión de entregas en tiempo real con conexión a MySQL Workbench mediante JDBC. Permite la interacción mediante una interfaz gráfica de usuario (Java Swing) para registrar pedidos, visualizarlos en tablas y coordinar la entrega a múltiples repartidores de forma simultánea mediante hilos Thread, Runnable y acceso a recursos compartidos synchronized.

Estructura del Proyecto

script_speedfast.sql

src/

├── dao/

│   ├── ConexionDB.java

│   ├── EntregaDAO.java

│   ├── PedidoDAO.java

│   └── RepartidorDAO.java

├── modelo/

│   ├── Entrega.java

│   ├── EstadoPedido.java

│   ├── Pedido.java

│   ├── Repartidor.java

│   └── ZonaDeCarga.java

├── vista/

│   ├── VentanaListaPedidos.java

│   ├── VentanaPrincipal.java

│   └── VentanaRegistroPedido.java

└── main/

└── Main.java


# Componentes

script_speedfast.sql: Script para crear la base de datos speedfast_db y sus tablas en MySQL Workbench.

ConexionDB: Clase para gestionar la conexión a la base de datos mediante JDBC.

EntregaDAO: Clase DAO para guardar el registro de las entregas en la base de datos.

PedidoDAO: Clase DAO para guardar, listar y actualizar pedidos en la base de datos.

RepartidorDAO: Clase DAO para consultar la lista de repartidores.

Entrega: Modelo que almacena la información de la entrega realizada (ID, ID pedido, ID repartidor, fecha y hora).

EstadoPedido: Enum que define los estados del ciclo de un envío (PENDIENTE, EN_REPARTO, ENTREGADO).

Pedido: Modelo que almacena la información de cada entrega (ID, dirección de entrega, tipo de pedido y estado).

ZonaDeCarga: Recurso compartido que almacena la cola de envíos y la lista de pedidos utilizando métodos sincronizados para evitar condiciones de carrera.

Repartidor: Clase que implementa Runnable para procesar las entregas en paralelo dentro de hilos independientes, actualizando el estado de cada pedido y guardando la entrega en la base de datos.

VentanaPrincipal: Interfaz gráfica principal (JFrame) que coordina la navegación hacia el formulario de registro, la tabla de pedidos y la asignación de repartidores.

VentanaRegistroPedido: Formulario visual para registrar nuevos pedidos con campos de texto y JComboBox, incluyendo validación de datos e interacción con JOptionPane.

VentanaListaPedidos: Interfaz visual con JTable y DefaultTableModel para listar y refrescar los pedidos registrados en el sistema.

Main: Clase principal del programa ubicada en el paquete main. Instancia la ZonaDeCarga e inicia la ejecución de la VentanaPrincipal.

# Ejecución

1. Ejecuta el script script_speedfast.sql en MySQL Workbench.


2. Abre el proyecto en IntelliJ IDEA.


3. Ve a la ruta src/main/Main.java.


4. Ejecuta la clase Main para desplegar la ventana principal de la aplicación y utilizar la interfaz gráfica para registrar, listar y simular las entregas de pedidos.

Alvaro Moreno

Duoc UC
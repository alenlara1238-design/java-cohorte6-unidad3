
### ¿Por qué existen las excepciones?
La razón de ser es el Control de Daños. En lugar de que el programa "explote" y se cierre abruptamente (un crash), las excepciones permiten que el hilo de ejecución se desvíe a un camino seguro, informando al usuario o intentando una recuperación.

#### 4 categorías generales de falla:

**1. Dependencias Externas (Fuera de nuestro control)**
Es cuando tu código depende de algo que no vive dentro de la memoria RAM de tu programa. Si el recurso no responde, el flujo se rompe.

Red: Una API caída o una base de datos que no acepta más conexiones.

Hardware: Una impresora desconectada o un disco duro lleno.

Sistemas de Archivos: Intentar leer un archivo que el usuario borró un segundo antes de que el programa lo abriera.

**2. Datos Corruptos o Inesperados**
Ocurre cuando la estructura de los datos que recibimos no coincide con lo que el código espera procesar.

Formato incorrecto: El usuario escribe "veinte" en un campo que espera un número (tu ejemplo de conversiones).

Protocolos rotos: Un JSON que llega incompleto o un archivo CSV con columnas faltantes.

**3. Agotamiento de Recursos**
El software vive en un mundo físico con límites. Si ignoramos estos límites, el flujo fallará inevitablemente.

Memoria: Crear objetos en un bucle infinito hasta que no quede espacio en el Heap.

Tiempo (Timeout): Una operación que tarda tanto que el sistema decide cortarla por seguridad.

**4. Violaciones de la Lógica de Negocio (Excepciones Semánticas)**
A veces, el código es técnicamente correcto (no hay fallas de red ni de memoria), pero la operación no tiene sentido para el negocio.

Reglas de seguridad: Un usuario intentando retirar más dinero del que tiene en su cuenta.

Estado inválido: Intentar "Enviar un pedido" que aún no tiene productos agregados.
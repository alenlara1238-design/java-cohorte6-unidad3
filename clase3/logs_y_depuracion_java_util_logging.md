# Logs y Depuración con Java Util Logging

¡Hola a todos!

Están a punto de sumergirse en una clase que cambiará la forma en que observan y diagnostican el comportamiento de sus aplicaciones. Hasta ahora han aprendido a estructurar proyectos y manejar excepciones, lo cual es fundamental. Pero cuando una aplicación crece, usar solamente `System.out.println()` deja de ser suficiente.

Hoy aprenderán a registrar eventos importantes dentro de sus programas de manera ordenada y profesional, utilizando **java.util.logging**, la herramienta de logging incorporada en Java.

Esto les permitirá:

- comprender mejor lo que ocurre dentro de una aplicación,
- identificar errores con mayor facilidad,
- registrar eventos importantes,
- almacenar mensajes en archivos,
- y mejorar la mantenibilidad del software.

El logging no es solo imprimir mensajes: es una herramienta clave para desarrollar aplicaciones más profesionales, más fáciles de depurar y más fáciles de mantener.

---

# Objetivos de Aprendizaje

Al finalizar esta clase, serás capaz de:

- Comprender las limitaciones de `System.out.println()` para registrar eventos en aplicaciones reales.
- Entender la importancia del **logging** en el desarrollo y monitoreo de software.
- Utilizar **java.util.logging** para registrar eventos de una aplicación.
- Comprender y aplicar los niveles de log: `SEVERE`, `WARNING`, `INFO`, `CONFIG`, `FINE`.
- Configurar la salida de logs tanto en consola como en archivos usando `Handler` y `FileHandler`.
- Registrar excepciones correctamente utilizando logs.
- Diferenciar entre logging y depuración con debugger.

---

# 1. Las limitaciones de `System.out.println()`

Aunque `System.out.println()` es útil para pruebas rápidas, presenta varias limitaciones cuando una aplicación crece.

## Problemas principales:

### No permite clasificar mensajes
No diferencia entre:

- información,
- advertencias,
- errores.

Todo aparece igual en consola:

```java
System.out.println("Usuario autenticado");
System.out.println("Error al conectar");
```

No hay forma de saber cuál es informativo y cuál es crítico.

---

### No permite registrar en archivos fácilmente
`System.out.println()` solo imprime en consola.

En aplicaciones reales necesitamos conservar registros para análisis posterior.

---

### No agrega contexto automáticamente
No registra:

- fecha y hora,
- nivel de severidad,
- clase origen,
- método origen.

Con logging sí:

```java
INFO: Usuario autenticado correctamente
WARNING: Contraseña incorrecta
SEVERE: Error de conexión
```

---

### Manejo deficiente de excepciones
Con `println` normalmente solo se imprime el mensaje:

```java
System.out.println(e.getMessage());
```

Pero se pierde el detalle completo del error.

---

# 2. Importancia del Logging

El **logging** es el proceso de registrar eventos relevantes que ocurren durante la ejecución de una aplicación.

Permite:

- monitorear el sistema,
- detectar errores,
- analizar comportamientos,
- auditar procesos,
- depurar problemas.

## Ventajas del logging

### Trazabilidad
Permite saber qué ocurrió y cuándo ocurrió.

### Diagnóstico
Facilita encontrar errores.

### Persistencia
Los eventos pueden almacenarse en archivos.

### Mantenimiento
Permite entender el comportamiento del sistema sin detenerlo.

---

# 3. Introducción a `java.util.logging`

Java incorpora de forma nativa la API **java.util.logging**, que permite registrar mensajes clasificados por nivel y enviarlos a distintos destinos.

La idea es sencilla:

- el **Logger** genera mensajes,
- el **Handler** define dónde se escriben.

## Logger
Es el objeto que registra mensajes:

```java
Logger logger = Logger.getLogger(MiClase.class.getName());
```

## Handlers
Definen el destino del log:

- consola → `ConsoleHandler`
- archivo → `FileHandler`

---

# 4. Niveles de Logging

Los niveles permiten clasificar la gravedad de los mensajes.

## SEVERE
Errores graves:

```java
logger.severe("Error crítico en la aplicación");
```

## WARNING
Advertencias:

```java
logger.warning("Dato inválido detectado");
```

## INFO
Información general:

```java
logger.info("Usuario autenticado");
```

## CONFIG
Datos de configuración:

```java
logger.config("Puerto configurado en 8080");
```

## FINE
Detalles de depuración:

```java
logger.fine("Entrando al método login");
```

---

# 5. Logging en Consola y Archivo

Con `java.util.logging` podemos registrar eventos en un archivo usando `FileHandler`.

```java
FileHandler archivo = new FileHandler("app.log", true);
logger.addHandler(archivo);
```

Esto genera un archivo con registros persistentes.

Ejemplo completo:

```java
Logger logger = Logger.getLogger("MiLogger");

FileHandler archivo = new FileHandler("app.log", true);
archivo.setFormatter(new SimpleFormatter());

logger.addHandler(archivo);

logger.info("Aplicación iniciada");
```

---

# 6. Logging de Excepciones

Una buena práctica es registrar errores cuando se capturan excepciones:

```java
catch (Exception e) {
    logger.severe("Error: " + e.getMessage());
}
```

Esto permite conservar evidencia de fallos.

Ejemplo:

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    logger.severe("Error al dividir: " + e.getMessage());
}
```

---

# 7. Logging vs Debugger

Ambos ayudan a detectar errores, pero tienen propósitos distintos.

## Debugger
Permite:

- pausar ejecución,
- inspeccionar variables,
- avanzar paso a paso.

Se usa durante desarrollo.

## Logging
Permite:

- registrar eventos,
- almacenar historial,
- diagnosticar errores en producción.

Se usa tanto en desarrollo como en producción.

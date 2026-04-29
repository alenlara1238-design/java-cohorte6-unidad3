# Taller de logging con Java Util Logging

## Ejercicio 1: Crear logs básicos en consola

### Enunciado

Una aplicación necesita registrar eventos básicos en consola usando `java.util.logging`.

El sistema debe registrar:

- inicio del programa
- carga de datos
- finalización del programa

Todos los mensajes deben mostrarse en consola usando nivel `INFO`.

No debes configurar ningún `Handler`.

### Clases que debes crear

#### Clase `App`

Debe:

1. crear un `Logger`
2. registrar tres mensajes usando `INFO`

### Pasos sugeridos

#### Paso 1: Crear un logger para la clase

```java
Logger logger = Logger.getLogger(App.class.getName());
```

#### Paso 2: Registrar el inicio del sistema

```java
logger.info("Sistema iniciado");
```

#### Paso 3: Registrar otro evento

```java
logger.info("Datos cargados correctamente");
```

#### Paso 4: Registrar la finalización

```java
logger.info("Sistema finalizado");
```

### Objetivo

Comprender:

- cómo crear un `Logger`
- cómo usar `logger.info()`
- cómo funciona el `ConsoleHandler` por defecto

---

## Ejercicio 2: Registrar logs en archivo usando el formatter por defecto

### Enunciado

Ahora la aplicación debe guardar los logs en un archivo llamado `app.log`.

Debes registrar:

- inicio del sistema
- proceso ejecutado
- fin del sistema

Los logs deben guardarse usando el formato por defecto de Java.

### Clases que debes crear

#### Clase `App`

Debe:

1. crear un `Logger`
2. crear un `FileHandler`
3. asociar el handler al logger
4. registrar mensajes `INFO`

### Pasos sugeridos

#### Paso 1: Crear el logger

```java
Logger logger = Logger.getLogger(App.class.getName());
```

#### Paso 2: Crear un `FileHandler`

```java
FileHandler archivo = new FileHandler("app.log", true);
```

#### Paso 3: Asignar el formatter por defecto

```java
archivo.setFormatter(new SimpleFormatter());
```

#### Paso 4: Asociar el handler al logger

```java
logger.addHandler(archivo);
```

#### Paso 5: Evitar duplicar mensajes en consola

```java
logger.setUseParentHandlers(false);
```

#### Paso 6: Registrar mensajes

```java
logger.info("Proceso iniciado");
```

### Objetivo

Comprender:

- cómo usar un `FileHandler`
- cómo escribir logs en archivo
- cómo usar `SimpleFormatter`
- cómo evitar la propagación al logger padre

---

## Ejercicio 3: Registro básico de inventario con formatter personalizado

### Enunciado

Una tienda desea registrar los movimientos básicos de inventario en un archivo `inventario.log`.

Debe registrar:

- inicio del sistema
- entrada de producto
- salida de producto
- cierre del sistema

Usa nivel `INFO`.

Formato esperado:

```text
2026-04-28 10:35:12 [INFO] Producto agregado al inventario
```

### Clases que debes crear

- `MiFormato`
- `Inventario`
- `App`

### Pasos sugeridos

1. Crear clase `MiFormato` que herede de `Formatter`
2. sobrescribir `format(LogRecord record)`
3. configurar `FileHandler`
4. usar `logger.info(...)`

### Código clave

```java
archivo.setFormatter(new MiFormato());
```

MiFormato debe tener esta estructura:
```java
public class MiFormato extends Formatter {

    @Override
    public String format(LogRecord record) {
        // construir el texto del log
    }
}
```
Para que la fecha quede así:

```text
2026-04-28 10:35:12
```
El objeto record tiene la fecha en milisegundos:
```java
record.getMillis()
```
Ahora puedes convertila en fecha usando:
```java
new Date(record.getMillis())
```
Para que la fecha quede así:
```text
2026-04-28 10:35:12
```

usa:
```java
new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
```
Para obtener nivel del log, haz así:
```java
record.getLevel()
```
Eso devuelve valores como:

```text
INFO
WARNING
SEVERE
```
Puedes obtener el mensaje usando:
```java
record.getMessage()
```
Debes construir una salida con esta estructura:
```text
fecha + [nivel] + mensaje
```
Cada log debe terminar con un salto de línea.

Cuando la clase **MiFormato** esté lista, debes asociarla al **FileHandler**:
```java
archivo.setFormatter(new MiFormato());
```

### Objetivo

Comprender:

- formatter personalizado
- formato de salida del log

---

## Ejercicio 4: Retiros bancarios con logging y excepciones

### Enunciado

Un banco necesita registrar operaciones de retiro.

Si el retiro supera el saldo:

- registrar `WARNING`
- lanzar excepción personalizada
- capturar y registrar `SEVERE`

Si es exitoso:

- registrar `INFO`

### Clases que debes crear

- `SaldoInsuficienteException`
- `CuentaBancaria`
- `App`

### Código clave

```java
logger.info("Retiro realizado correctamente");
logger.warning("Intento de retiro superior al saldo");
logger.severe("Error al retirar dinero");
```

### Objetivo

Practicar:

- niveles `INFO`, `WARNING`, `SEVERE`
- excepciones personalizadas

---

## Ejercicio 5: Validación de usuarios en clase de servicio

### Enunciado

Crea un sistema que valide credenciales.

Si son correctas:

```java
logger.info(...)
```

Si son incorrectas:

```java
logger.warning(...)
```

Luego lanzar excepción y capturarla registrando:

```java
logger.severe(...)
```

### Clases sugeridas

- `AutenticacionException`
- `ServicioUsuarios`
- `App`

### Objetivo

Practicar:

- logging en múltiples clases
- propagación y captura

---

## Ejercicio 6: Sistema de pedidos con dos archivos de log

### Enunciado

Registrar logs en:

- `operaciones.log`
- `errores.log`

### Reglas

- `INFO` → `operaciones.log`
- `WARNING` y `SEVERE` → `errores.log`

### Clases sugeridas

- `StockInsuficienteException`
- `ServicioPedidos`
- `App`

### Código clave

```java
handlerInfo.setLevel(Level.INFO);
handlerErrores.setLevel(Level.WARNING);
```

### Objetivo

Practicar:

- múltiples handlers
- separación de logs por nivel

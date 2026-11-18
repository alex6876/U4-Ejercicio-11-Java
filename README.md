Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Sistema Domótico y Hub de Control Inteligente (Interfaces y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 🏠 Simulación de Sistema Domótico y Hub de Control Inteligente (Interfaces y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de automatización del hogar (Smart Home), implementando una arquitectura basada en **interfaces (`interface`)** para desacoplar el centro de control (Hub Central) de los diversos dispositivos inteligentes del ecosistema (focos LED, aires acondicionados y persianas motorizadas) con reglas especializadas para el procesamiento dinámico de comandos. Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **implementación obligatoria de contratos de interfaces**, la inyección de dependencias polimórfica, el uso de colecciones tipadas (`ArrayList<Controlable>`) y la gestión de estados internos en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una interfaz de contrato, sus respectivas clases implementadoras, un componente gestor central y un punto de ejecución:

* **`Controlable` (Interfaz)**: Define el contrato estándar que cualquier dispositivo inteligente del sistema debe cumplir obligatoriamente.
* **Método abstracto**: `void ejecutarAccion(String comando)`: Obliga a las clases implementadoras a definir su propia lógica de interpretación y ejecución ante las órdenes enviadas.


* **`FocoInteligente`**: Implementa la interfaz `Controlable` para modelar iluminación regulable.
* **Atributo privado (`private`)**: `encendida`.
* **Constructor**: Configura el estado inicial apagado (`false`).
* **Sobrescritura (`@Override`)**:
* `ejecutarAccion(String comando)`: Procesa comandos de encendido y apagado actualizando el estado y emitiendo confirmaciones por consola.




* **`AireAcondicionado`**: Implementa `Controlable` para modelar climatizadores con control de temperatura.
* **Atributos privados (`private`)**: `encendido` y `temperatura` (inicializada en 24°C).
* **Sobrescritura (`@Override`)**:
* `ejecutarAccion(String comando)`: Gestiona comandos de encendido, apagado, aumento (`SUBIR`) y reducción (`BAJAR`) de temperatura, manejando también casos de comandos no reconocidos.




* **`PersianaMotorizada`**: Implementa `Controlable` para modelar cortinas automáticas con niveles de apertura.
* **Atributo privado (`private`)**: `apertura` (porcentaje de apertura).
* **Sobrescritura (`@Override`)**:
* `ejecutarAccion(String comando)`: Interpreta órdenes de apertura completa (`100%`) y cierre total (`0%`), reportando errores ante comandos inválidos.




* **`HubCentral`**: Componente controlador encargado de administrar la red de dispositivos del hogar.
* **Atributo privado (`private`)**: `ArrayList<Controlable> dispositivos`.
* **Métodos operativos**:
* `agregarDispositivo(Controlable dispositivo)`: Registra un nuevo artefacto en el hub central.
* `enviarComando(String comando)`: Recorre de forma polimórfica la lista de dispositivos y propaga simultáneamente la orden recibida a cada equipo conectado.




* **`Main`**: Punto de entrada del programa. Instancia el hub central, un foco, un aire acondicionado y una persiana, los registra en la red, y ejecuta una secuencia completa de comandos globales (`ENCENDER`, `BAJAR`, `ABRIR`, `APAGAR`, `CERRAR`) para demostrar la resolución polimórfica de las acciones por consola.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Desacoplamiento Estricto Mediante Interfaces:** El `HubCentral` desconoce por completo las especificaciones internas de los aparatos (`FocoInteligente`, `AireAcondicionado`, etc.); interactúa de forma exclusiva con el contrato genérico `Controlable`, logrando una arquitectura desacoplada y altamente extensible.
2. **Polimorfismo en Colecciones Tipadas:** El uso de `ArrayList<Controlable>` permite almacenar y procesar de manera uniforme dispositivos con comportamientos operativos radicalmente distintos.
3. **Principio Abierto/Cerrado (OCP):** Es posible integrar nuevos dispositivos inteligentes al ecosistema domótico (como cerraduras electrónicas o altavoces inteligentes) simplemente creando una clase que implemente la interfaz `Controlable`, sin modificar una sola línea de código del hub central.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== ENVIANDO COMANDO: ENCENDER =====
Foco Encendido
Aire acondicionado encendido.
Comando no reconocido para la persiana.
===== ENVIANDO COMANDO: BAJAR =====
Comando no reconocido para el foco.
Temperatura reducida a 23 grados.
Comando no reconocido para la persiana.
===== ENVIANDO COMANDO: ABRIR =====
Comando no reconocido para el foco.
Comando no reconocido para el aire acondicionado.
Persiana completamente abierta.
===== ENVIANDO COMANDO: APAGAR =====
Foco Apagado
Aire acondicionado apagado.
Comando no reconocido para la persiana.
===== ENVIANDO COMANDO: CERRAR =====
Comando no reconocido para el foco.
Comando no reconocido para el aire acondicionado.
Persiana completamente cerrada.

```

---

## 🚀 Conceptos de Programación Aplicados

* **Polimorfismo de Interfaces:** Uso de contratos abstractos (`interface`) para unificar el envío de órdenes a artefactos heterogéneos bajo un mismo tipo de referencia.
* **Principio de Inversión de Dependencias:** El componente de control (`HubCentral`) depende de abstracciones y no de implementaciones concretas de hardware.
* **Separación de Responsabilidades:** Clara división entre el estado y lógica de control de cada dispositivo, el componente centralizador de red (`HubCentral`) y la ejecución de casos de prueba en el cliente (`Main`).

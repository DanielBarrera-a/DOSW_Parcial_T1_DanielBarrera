# DOSW_Parcial_T1_DanielBarrera

## Datos del estudiante

- **Nombre completo:** _(completa aquí)_
- **Grupo DOSW:** _(completa aquí)_
- **Enunciado asignado (Parte 3):** _(se completa el día del parcial)_

## Estructura del proyecto

```
DOSW-ParcialT1
├── pom.xml
├── src
│   ├── main/java/edu/dosw/parcial/App.java
│   └── test/java/edu/dosw/parcial/AppTest.java
├── docs/
│   ├── uml/            # Diagramas UML exportados en PDF o PNG
│   ├── images/          # Capturas de ejecución
│   └── requirements/    # Requisitos funcionales y no funcionales
```

## Evidencias — prerrequisitos

### Acceso a herramienta de modelado (Miro)
<img src="https://raw.githubusercontent.com/DanielBarrera-a/DOSW_Parcial_T1_DanielBarrera/eea254f250a25bd79bdd753c9627f3416a2c4e88/docs/images/evidenciaMiro.png" width="600">

### Acceso a Figma
<img src="https://raw.githubusercontent.com/DanielBarrera-a/DOSW_Parcial_T1_DanielBarrera/eea254f250a25bd79bdd753c9627f3416a2c4e88/docs/images/evidenciaFigma.png" width="600">

### El proyecto corre correctamente con Maven
<img src="https://raw.githubusercontent.com/DanielBarrera-a/DOSW_Parcial_T1_DanielBarrera/eea254f250a25bd79bdd753c9627f3416a2c4e88/docs/images/evidenciaMaven.png" width="600">


## Mision

## Mision # 1

<img src="https://github.com/DanielBarrera-a/DOSW_Parcial_T1_DanielBarrera/blob/35b6bfa11275c1de5c01d76b8d67d48285aa84c7/docs/images/evidenciaDiagramaContexto.png">

## Mision # 2

### Requerimientos Funcionales:

1. BOB’S BARBER System debe tener la capacidad de gestionar los turnos en linea para todos los usuarios


2. BOB’S BARBER System debe tener la capacidad de procesar los pagos en las diferentes plataformas ofrecidas


3. BOB’S BARBER System debe tener la capacidad de asignar barberos segun su disponibilidad  y especialidad


4. BOB’S BARBER System debe tener la capacidad de validar cada turno a travez de una cadena de pasos ordenados antes de confirmarlo


### Requerimientos No Funcionales:

1. El sitema BOB’S BARBER System deberia procesar cualquier asignacion de barberos segun su disponibilidad en meximo 10 segundos para el 99.9% de las peticiones bajo condiciones normales de operacion


2. El sitema BOB’S BARBER System deberia confirmar cada turno validado a travez de una cadena de pasos ordenados con un tiempo maximo de 25 segundos para el 50% de de las peticciones bajo condiciones normales de operacion


### Patrones de diseño 

#### Para el requerimeinto funcional numero 1

Este requerimiento debe ser aplicado con el patron de diseño El Chain of Responsibility es un patrón de diseño de comportamiento que permite enviar una solicitud a traves de una cadena de objetos, donde cada objeto decide si maneja la solicitud o la pasa al siguiente en la cadena

### Para el requerimeinto funciona numeor 2

Este requerimiento debe utilizar el patron de daptar ya que al manejar diferentes sistemas de pago y que cada uno maneje su infromacion relevante propia necesitamos un adapter para tranformar esa informacion de las diferentes plataformas de pago en infromacion relevante para nosotros y vicebersa

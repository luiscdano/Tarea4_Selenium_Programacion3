Tarea 4 – Pruebas Automatizadas con Selenium

Programación 3 – ITLA
Autor: Luis Emilio Cedano Martínez (Matrícula: 2024-0128)

Descripción del Proyecto

Este repositorio contiene el desarrollo completo de mi Tarea 4 para la asignatura Programación 3 en el ITLA.
El objetivo principal es automatizar pruebas sobre una aplicación funcional utilizando Selenium WebDriver,cumpliendo con los criterios técnicos, documentales y de presentación exigidos por el profesor.

Para lograrlo preparé:
	•	Una aplicación web funcional llamada BancoAppWeb, que sirve como base para las pruebas.
	•	Un proyecto independiente llamado BancoAppWeb_SeleniumTests, donde implemento todas las pruebas automatizadas.
	•	Un tablero en Jira donde gestiono las historias de usuario, criterios de aceptación y rechazo, y la trazabilidad completa del proyecto.

Este trabajo representa mi evolución como estudiante, combinando análisis, estructura, automatización y buenas prácticas de desarrollo.

⸻

Tecnologías y Herramientas Utilizadas

Aplicación base (BancoAppWeb)
	•	HTML / CSS / JS
	•	PHP o lenguaje base según la necesidad del CRUD
	•	MySQL (si aplica)
	•	Arquitectura simple para facilitar las pruebas

Pruebas automatizadas (BancoAppWeb_SeleniumTests)
	•	Selenium WebDriver
	•	Java
	•	TestNG / JUnit
	•	Extent Reports o HTML Report
	•	Screenshots automáticos
	•	Patrón Page Object Model (POM) (si se usa)

Herramientas de apoyo
	•	Jira Software (historias de usuario, seguimiento y criterios)
	•	GitHub (control de versiones)
	•	YouTube (video demostrativo)
	•	 VS Code

⸻

Estructura del Repositorio

Tarea4_Selenium_Programacion3/
│
├── BancoAppWeb/                     # Proyecto de la aplicación base
│   ├── index.html
│   ├── vistas/
│   ├── controladores/
│   └── ...
│
├── BancoAppWeb_SeleniumTests/       # Proyecto de pruebas automatizadas
│   ├── src/test/java/tests/
│   │   ├── LoginTest.java
│   │   ├── RegistrarClienteTest.java
│   │   ├── EditarClienteTest.java
│   │   ├── EliminarClienteTest.java
│   │   ├── RegistrarTarjetaTest.java
│   │   └── ValidacionesTest.java
│   ├── screenshots/
│   ├── reports/
│   └── ...
│
└── README.md


⸻

Historias de Usuario Incluidas

Desde HU01 hasta HU07:
	•	HU01 – Inicio de sesión exitoso
	•	HU02 – Registrar nuevo cliente
	•	HU03 – Visualizar listado de clientes
	•	HU04 – Editar información de un cliente
	•	HU05 – Eliminar un cliente
	•	HU06 – Registrar tarjeta de crédito
	•	HU07 – Validación negativa de campos vacíos

⸻

Sobre las Pruebas Automatizadas

Implementé al menos un caso de prueba por cada historia de usuario, cumpliendo los tipos:
	•	 Camino feliz
	•	Pruebas negativas
	•	Pruebas de límites
	•	Capturas automáticas
	•	Reporte HTML

Estas pruebas fueron diseñadas para validar el correcto comportamiento del sistema bajo interacciones reales del usuario.


Video Demostrativo

El video público mostrando la ejecución de las pruebas se encuentra en:
🔗 (Colocar enlace aquí cuando esté listo)

⸻

Aporte Personal

Este proyecto me permitió profundizar en el uso profesional de Selenium, la creación de casos de prueba, la organización basada en historias de usuario y la importancia de la automatización en el desarrollo moderno.
También representó un reto personal que me ayudó a mejorar mis habilidades en Git, Jira, documentación y buenas prácticas.

Mi objetivo fue no solo cumplir con la tarea, sino crear un proyecto que realmente represente lo que puedo hacer como desarrollador en formación.

⸻

📝 Accesos del Profesor

Se otorgó acceso a:
📧 ktejada@itla.edu.do
📧 20186927@itla.edu.do

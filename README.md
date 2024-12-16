# Aplicación Bancaria (En Desarrollo)

## Descripción

Una aplicación bancaria de escritorio que permite a los administradores realizar transacciones como depósitos, retiros y transferencias. La aplicación incluye un sistema de autenticación seguro, visualización de cuentas y un historial de transacciones. Está diseñada inicialmente como una aplicación de escritorio en Java y se planea desarrollar una versión móvil para Android para los usuarios.

## Características

### Gestión de Usuarios
- Registro de usuarios con contraseñas encriptadas.
- Autenticación de usuarios mediante nombre y contraseña.

### Gestión de Cuentas Bancarias
- Varios tipos de cuentas (ahorros, corriente).
- Visualización de saldo y detalles de la cuenta.

### Operaciones Bancarias
- Depósitos y retiros.
- Transferencias entre cuentas.

### Historial de Transacciones
- Registro completo de las transacciones realizadas (depósitos, retiros, transferencias).

## Requisitos

### Herramientas necesarias
- Java JDK 11 o superior
- MySQL para la base de datos
- IDE recomendado: IntelliJ IDEA, Eclipse, NetBeans (o cualquier otro IDE que soporte Java)

### Dependencias
- JDBC para la conexión con la base de datos.
- Swing para la interfaz gráfica de escritorio.
- bcrypt para la encriptación de contraseñas (opcional).

## Instalación

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone ttps://github.com/martins25/central-bank.git
    ```

2. Abre el proyecto en tu IDE preferido.

3. Configura la conexión a la base de datos MySQL en el archivo de configuración.

4. Compila y ejecuta la aplicación.

## Uso

1. Regístrate como nuevo usuario proporcionando tu correo electrónico y una contraseña segura.
2. Inicia sesión con tus credenciales.
3. Crea y gestiona tus cuentas bancarias.
4. Realiza depósitos, retiros y transferencias entre cuentas.
5. Consulta el historial de transacciones para ver todas las operaciones realizadas.


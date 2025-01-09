# ChatGlobal

**ChatGlobal** es un plugin de Minecraft diseñado para permitir que los jugadores de múltiples plataformas (Spigot, BungeeCord, y Velocity) interactúen en un chat global común, independientemente de qué servidor estén jugando. Este plugin facilita la comunicación entre servidores y es especialmente útil para redes multiserver, donde los jugadores puedan enviar mensajes desde diferentes servidores a un chat único.

## Características

- **Chat global**: Permite a los jugadores de diferentes servidores interactuar en un solo chat.
- **Compatibilidad multiplataforma**: Funciona con Spigot, BungeeCord y Velocity.
- **PlaceholderAPI**: Soporte para PlaceholderAPI (solo en Spigot).
- **Fácil configuración**: Personaliza el formato del chat, servidores habilitados y más.
- **Permisos personalizables**: Puedes configurar los permisos para acceder a los comandos del chat global y gestionar los servidores.

## Requisitos

- **Spigot** (1.16.5 o superior)
- **BungeeCord** (compatible con tu versión)
- **Velocity** (compatible con tu versión)
- **PlaceholderAPI** (solo en Spigot)

## Instalación

### 1. Descargar el Plugin

1. Clona o descarga este repositorio.
2. Compílalo usando Maven (`mvn clean package`).
3. Copia el archivo `.jar` generado desde la carpeta `target/` a la carpeta `plugins/` de tu servidor (Spigot, BungeeCord o Velocity).

### 2. Configurar el Plugin

Edita el archivo `config.yml` para configurar los servidores y el formato del chat global. Aquí puedes establecer qué servidores están habilitados para el chat global, así como personalizar el formato y los permisos.

```yaml
# Configuración de servidores
servers:
  allowedGlobalChat:
    - server1
    - server2
    - server3
  deniedGlobalChat:
    - server4
    - server5

# Configuración de formato de chat
chatSettings:
  format: '{PLAYER_NAME}: {MESSAGE}'  # Formato del mensaje en el chat global
  prefix: '[Global]'                 # Prefijo a añadir al mensaje

# Configuración de habilitación de plataformas
pluginConfig:
  enableBungee: true
  enableVelocity: false
  enableSpigot: true

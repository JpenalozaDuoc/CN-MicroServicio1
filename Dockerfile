# Usar una imagen base adecuada
FROM openjdk:17-jdk-alpine

# Definir el directorio de trabajo
WORKDIR /app

# Copiar el JAR de tu aplicación al contenedor
COPY target/datos-paciente-0.0.1-SNAPSHOT.jar /app/datos-paciente-0.0.1-SNAPSHOT.jar

# Copiar el Oracle Wallet al contenedor
COPY ./src/wallet /app/src/wallet

# Definir la variable de entorno para Oracle Wallet
ENV TNS_ADMIN=/app/wallet

# Exponer el puerto de la aplicación (si es necesario)
EXPOSE 9092

# Ejecutar la aplicación Java
CMD ["java", "-jar","datos-paciente-0.0.1-SNAPSHOT.jar"]


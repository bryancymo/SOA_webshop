# Web
FROM openjdk:17-jdk
WORKDIR /app
COPY /target/SOA_webshop-0.0.1-SNAPSHOT.jar /opt/web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/web.jar"]

# Productservice
FROM openjdk:17-jdk
WORKDIR /app
COPY /target/SOA_webshop-0.0.1-SNAPSHOT-productService.jar /opt/productService.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/productService.jar"]

# Cartservice
FROM openjdk:17-jdk
WORKDIR /app
COPY /target/SOA_webshop-0.0.1-SNAPSHOT-cartService.jar /opt/cartService.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/cartService.jar"]

# Checkoutservice
FROM openjdk:17-jdk
WORKDIR /app
COPY /target/SOA_webshop-0.0.1-SNAPSHOT-checkoutService.jar /opt/checkoutService.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/opt/checkoutService.jar"]

# Loginservice
FROM openjdk:17-jdk
WORKDIR /app
COPY /target/SOA_webshop-0.0.1-SNAPSHOT-loginService.jar /opt/loginService.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/opt/loginService.jar"]

# Shippingservice
FROM openjdk:17-jdk
WORKDIR /app
COPY /target/SOA_webshop-0.0.1-SNAPSHOT-shippingService.jar /opt/shippingService.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/opt/shippingService.jar"]

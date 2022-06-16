#JDK kurulumunu yapıyoruz
FROM java:8-jdk-alpine

#Projemizin olduğu yeri gösteriyoruz ve kopyalıyoruz
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} SpringBoot-LaboratuvarRaporlamaUygulamasi-0.0.1-SNAPSHOT.jar

#Çalışacağı portu belirliyoruz
EXPOSE 9980

#Projemizi calistıracak komutu yazıyoruz.
ENTRYPOINT ["java","-jar","/SpringBoot-LaboratuvarRaporlamaUygulamasi-0.0.1-SNAPSHOT.jar"]

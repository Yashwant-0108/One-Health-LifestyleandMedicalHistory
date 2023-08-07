FROM openjdk:17

ADD target/OneHealth_Test-3_Postgres-2.3.4.jar OneHealth_Test-3_Postgres-2.3.4.jar

ENTRYPOINT [ "java" , "-jar" ,"/OneHealth_Test-3_Postgres-2.3.4.jar" ]
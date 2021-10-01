# kafka-spring-project
project created to study kafka and avro

#to climb the Kafka
docker-compose up

#to build the project
mvn clean install

#to execute the project
mvn spring-boot:run

# to see the Landoop interface and see registered topics and sent messages
http://localhost:3030/kafka-topics-ui

# postman request POST for:
http://localhost:8080/kafka/user

{
    "nome": "name",
    "sobreNome": "lastName"
}

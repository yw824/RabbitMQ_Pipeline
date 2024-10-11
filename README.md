# RabbitMQ를 사용한 간단한 메세지 큐 구현 

## 아키텍처 : 
- RabbitMQ [Local Docker Container]
- Producer [SpringBoot]
- Consumer Group
    - Consumer1 [SpringBoot]
    - Consumer2 [SpringBoot]
    - Consumer3 [SpringBoot]

### RabbitMQ 구축 : Docker  
```bash
docker pull rabbitmq:3.10.5-management
docker run -it -p 15672:15672 -p 5672:5672 rabbitmq:3.10.5-management
```

### SpringBoot Server : 
- 3.2.11 [SNAPSHOT]
- Java
- Gradle 

#### Plugins
- Spring Web
- Lombok
- Spring for RabbitMQ
- Spring for RabbitMQ Streams [amqp]
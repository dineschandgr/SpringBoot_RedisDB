# SpringBoot_RedisDB
Spring Boot App connecting to Redis Database for CRUD operations

Redis is used as a database for CRUD operations in this application

#Preqequisites

1. Download and install Redis in local machine
2. After unzipping the redis jar, open redis-server.exe file to start the redis server. Redis runs on port 6379 on localhost
3. Then start the redis-cli.exe to open the client

There are 2 types of Java Redis clients namely

1. Jedis (Synchronous and single threaded. Easy to use)
2. Lettuce ( uses asynchronous and reactive API. Multithreaded. difficult to use)

#Replication

- Redis Sentinel provides high availability for Redis
- Uses Master Slave concept.
- Only master can take writes

#MessageBroker

- Redis can also be used as Message Broker with Publish and Subscribe

#Steps

1. Create a Jedis Connection Fcatory and set it to the RedisTemplate
2. Provide redis configuration in application.properties file
3. Use hashOperations provided by Spring Boot in the Repository
4. Use HashOperations to perform the CRUD operation
5. Go to postman and enter the url http://localhost:8080/redis/addUser and enter the payload for the post method
6. For update, use http://localhost:8080/redis/update with the payload
7. FindAll users, http://localhost:8080/redis/findAll
8. Get a user, http://localhost:8080/redis/getUser/1
9. Delete a user, http://localhost:8080/redis/delete/1

#Verify
1. Check the redis-cli with the command keys *
2. Open another cli with the command monitor
3. This cli will display all the operations done in the redis server


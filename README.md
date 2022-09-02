# kuro-chat-ktor

WebApp made with ktor to chat in real-time via WebSockets

## Docker image

You can run this project with the [docker image](https://hub.docker.com/r/kurovale/kuro-chat) of this project

## Quick setup

Try this app in your local machine

1. ```git clone https://github.com/kuro-vale/kuro-chat-ktor.git```
2. Set environment variables 
    - DATABASE_URL = the url of the mysql database e.g. "mysql://user:password@localhost:3306/db-name"
3. Meet gradle dependencies
4. run ```./gradlew run```
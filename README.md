# kuro-chat-ktor

WebApp made with ktor to chat in real-time via WebSockets

Visit the [deployment](https://kuro-chat.herokuapp.com/)


## Quick setup

Try this app in your local machine

1. ```git clone https://github.com/kuro-vale/kuro-chat-ktor.git```
2. Checkout before setup for Heroku deployment ```git checkout a4bbffa0```
3. Set environment variables 
    - DATABASE_URL = the url of the mysql database e.g. "mysql://user:password@localhost:3306/db-name"
4. Meet gradle dependencies
5. run ```./gradlew run```
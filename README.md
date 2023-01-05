# kuro-chat-ktor

[![PWD](https://raw.githubusercontent.com/play-with-docker/stacks/master/assets/images/button.png)](https://labs.play-with-docker.com/?stack=https://raw.githubusercontent.com/kuro-vale/kuro-chat-ktor/main/pwd-stack.yml)

WebApp made with ktor to chat in real-time via WebSockets

## Screenshots
#### Chats
![Screenshot_20230105_154513](https://user-images.githubusercontent.com/87244716/210876600-34aaa9ae-72cd-4547-aab2-293b6f98d78a.png)
#### Register
![Screenshot_20230105_154120](https://user-images.githubusercontent.com/87244716/210876024-3cd731b0-e0ae-49e2-abfe-193a2cac2f25.png)


## Deploy

Follow any of these methods and open http://localhost:8080/ to see the WebApp.

### Docker

Run the command below to quickly deploy this project on your machine, see the [docker image](https://hub.docker.com/r/kurovale/kuro-chat) for more info.

```bash
docker run -d -p 8080:8080 kurovale/kuro-chat:sqlite
```

## Quick setup

Try this app in your local machine

1. ```git clone https://github.com/kuro-vale/kuro-chat-ktor.git```
2. Set environment variables 
    - DATABASE_URL = the url of the mysql database e.g. "mysql://user:password@localhost:3306/db-name"
3. Meet gradle dependencies
4. run ```./gradlew run```

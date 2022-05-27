<#import "../_layout.ftl" as layout />
<@layout.header>
    <h3 class="text-center"># books</h3>
        <ul id="messages" class="list-group overflow-auto mb-1" style="height: 75vh;">
            <#list messages as message>
                <li class="list-group-item">[${message.username}]: ${message.body}</li>
            </#list>
        </ul>
        <form action="" onsubmit="sendMessage(event)" class="d-flex flex-row">
            <input type="text" id="messageText" autocomplete="off" class="form-control">
            <button class="btn btn-outline-primary">Send</button>
        </form>
        <script>var ws = new WebSocket("ws://localhost:8080/books?username=${username}");</script>
        <script src="/static/WebSocketClient.js">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</@layout.header>
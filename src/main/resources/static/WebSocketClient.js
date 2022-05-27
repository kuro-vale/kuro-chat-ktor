var box = document.getElementById("messages")
box.scrollTop = box.scrollHeight;

ws.onmessage = function(event) {
    var messages = document.getElementById("messages")
    var message = document.createElement("li")
    var content = document.createTextNode(event.data)
    message.classList.add("list-group-item");
    message.appendChild(content)
    messages.appendChild(message)
    messages.scrollTop = messages.scrollHeight;
};
function sendMessage(event) {
    var input = document.getElementById("messageText")
    ws.send(input.value)
    input.value = ''
    event.preventDefault()
}
window.greet = function search(name, element) {
    console.log("Hi, " + name);
    element.$server.greet("server");
    element.innerHTML = "It works!";
}

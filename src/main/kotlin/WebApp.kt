import reactor.netty.http.server.HttpServer

fun main() {
    val port = 9999
    val host = "127.0.0.1"

    val service = ReplyService()

    HttpServer.create()
        .port(port)
        .host(host)
        .route { routes ->
            routes.get("/hello") { _, response -> response.sendString(service.something()) }
            routes.get("/nothing") { _, response -> response.sendString(service.nothing()) }
        }
        .bindNow()
        .onDispose()
        .block()
}
import reactor.core.publisher.Flux

class ReplyService {
    fun something(): Flux<String> = Flux.just("Hello!")

    fun nothing(): Flux<String> = Flux.empty()
}
import org.junit.jupiter.api.Test
import reactor.kotlin.test.test

class ReplyServiceTests {

    @Test
    fun `GIVEN a service WHEN replying something THEN hello is sent`() {
        val flux = ReplyService().something()

        flux.test()
            .expectNext("Hello!")
            .verifyComplete()
    }

    @Test
    fun `GIVEN a service WHEN replying nothing THEN it just does nothing`() {
        val flux = ReplyService().nothing()

        flux.test()
            .verifyComplete()
    }
}
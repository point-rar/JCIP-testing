import org.jetbrains.kotlinx.lincheck.*
import org.jetbrains.kotlinx.lincheck.annotations.*
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.*
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.*
import java.util.concurrent.*

class ConcurrentDequeTest {
    private val deque = ConcurrentLinkedDeque<Int>()

    @Operation
    fun addFirst(e: Int) = deque.addFirst(e)

    @Operation
    fun addLast(e: Int) = deque.addLast(e)

    @Operation
    fun pollFirst() = deque.pollFirst()

    @Operation
    fun pollLast() = deque.pollLast()

    @Operation
    fun peekFirst() = deque.peekFirst()

    @Operation
    fun peekLast() = deque.peekLast()

    // Run Lincheck in the stress testing mode
    @Test
    fun stressTest() = StressOptions()
        .actorsAfter(0)
        .actorsBefore(0)
        .actorsPerThread(3)
        .iterations(20)
        .threads(3)
        .minimizeFailedScenario(true)
        .logLevel(LoggingLevel.INFO).check(this::class)

    // Run Lincheck in the model checking testing mode
    @Test
    fun modelCheckingTest() = ModelCheckingOptions()
        .actorsAfter(0)
        .actorsBefore(0)
        .actorsPerThread(3)
        .iterations(20)
        .threads(3)
        .minimizeFailedScenario(true)
        .logLevel(LoggingLevel.INFO)
        .check(this::class)
}
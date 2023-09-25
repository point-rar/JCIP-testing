import org.jetbrains.kotlinx.lincheck.LinChecker
import org.jetbrains.kotlinx.lincheck.LoggingLevel
import org.jetbrains.kotlinx.lincheck.Options
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.paramgen.IntGen
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.Test
import rar.BoundedBuffer

@Param(name = "value", gen = IntGen::class, conf = "1:3")
class LincheckTesting {
    private val buffer = BoundedBuffer<Int>(CAPACITY)

    @get:Operation
    val isEmpty: Boolean
        get() = buffer.isEmpty

    @get:Operation
    val isFull: Boolean
        get() = buffer.isFull

    @Operation
    @Throws(InterruptedException::class)
    fun put(@Param(name = "value") x: Int) {
        buffer.put(x)
    }

    @Operation
    @Throws(InterruptedException::class)
    fun take(): Int {
        return buffer.take()
    }

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

    companion object {
        private const val CAPACITY = 10
    }
}

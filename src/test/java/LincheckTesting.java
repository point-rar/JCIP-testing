import org.jetbrains.kotlinx.lincheck.LinChecker;
import org.jetbrains.kotlinx.lincheck.LoggingLevel;
import org.jetbrains.kotlinx.lincheck.Options;
import org.jetbrains.kotlinx.lincheck.annotations.Operation;
import org.jetbrains.kotlinx.lincheck.annotations.Param;
import org.jetbrains.kotlinx.lincheck.paramgen.IntGen;
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions;
import org.junit.Test;
import rar.BoundedBuffer;

//@Param(name = "value", gen = IntGen.class, conf = "1:3")
//public class LincheckTesting {
////    private final static int CAPACITY = 10;
////    private final BoundedBuffer<Integer> buffer = new BoundedBuffer<>(CAPACITY);
//

//    @Operation
////    public boolean isEmpty() {
////        return buffer.isEmpty();
////    }

//    @Operation
////    public boolean isFull() {
////        return buffer.isFull();
////    }

//    @Operation
////    public void put(@Param(name = "value") Integer x) throws InterruptedException {
////        buffer.put(x);
//    }

//    @Operation
////    public Integer take() throws InterruptedException {
////        return buffer.take();
//    }

//    @Test
//    public void LinCheckTest() {
////        Options opts = new StressOptions()
////                .actorsAfter(0)
////                .actorsBefore(0)
////                .actorsPerThread(8)
////                .iterations(5)
////                .threads(3)
////                .minimizeFailedScenario(true)
////                .logLevel(LoggingLevel.INFO);
////        LinChecker.check(LincheckTesting.class, opts);
//    }
//}

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class NumberTypesExample {
    public static void main(String[] args) {
        // BigInteger - Handling Large Integer Values
        BigInteger bigInt1 = new BigInteger("9876543210123456789");
        BigInteger bigInt2 = new BigInteger("1234567890123456789");

        BigInteger sumBigInt = bigInt1.add(bigInt2);
        BigInteger multiplyBigInt = bigInt1.multiply(bigInt2);

        System.out.println("BigInteger Sum: " + sumBigInt);
        System.out.println("BigInteger Product: " + multiplyBigInt);

        //  BigDecimal - Handling High-Precision Decimal Values
        BigDecimal bigDec1 = new BigDecimal("12345.67890123456789");
        BigDecimal bigDec2 = new BigDecimal("0.000000000123456789");

        BigDecimal sumBigDec = bigDec1.add(bigDec2);
        BigDecimal divideBigDec = bigDec1.divide(new BigDecimal("2"), BigDecimal.ROUND_HALF_UP);

        System.out.println("BigDecimal Sum: " + sumBigDec);
        System.out.println("BigDecimal Division: " + divideBigDec);

        //  AtomicInteger - Thread-safe integer operations
        AtomicInteger atomicInt = new AtomicInteger(100);
        atomicInt.incrementAndGet(); // Equivalent to atomicInt = atomicInt + 1
        atomicInt.addAndGet(50); // Equivalent to atomicInt += 50

        System.out.println("AtomicInteger Value: " + atomicInt.get());

        // AtomicLong - Thread-safe long operations
        AtomicLong atomicLong = new AtomicLong(1000000000L);
        atomicLong.incrementAndGet(); // atomicLong += 1
        atomicLong.addAndGet(5000000000L); // atomicLong += 5000000000L

        System.out.println("AtomicLong Value: " + atomicLong.get());

        //  DoubleAdder - Efficient addition for high concurrency
        DoubleAdder doubleAdder = new DoubleAdder();
        doubleAdder.add(10.5);
        doubleAdder.add(20.5);

        System.out.println("DoubleAdder Sum: " + doubleAdder.sum());

        //  LongAdder - Similar to DoubleAdder but for long values
        LongAdder longAdder = new LongAdder();
        longAdder.add(100);
        longAdder.add(200);

        System.out.println("LongAdder Sum: " + longAdder.sum());
    }
}

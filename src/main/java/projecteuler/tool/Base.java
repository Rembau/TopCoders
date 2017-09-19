package projecteuler.tool;

import org.junit.After;
import org.junit.Before;

public class Base {
    long start;

    @Before
    public void before() {
        start = System.nanoTime();
    }

    @After
    public void after() {
        long n = System.nanoTime() - start;
        System.out.println("花费时间" + n + " ns，" + n/1000000 +" ms，" + n/1000000000.0 + " s");
    }
}

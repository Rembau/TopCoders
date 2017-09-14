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
        System.out.println("花费时间" + (System.nanoTime()-start)/1000.0);
    }
}

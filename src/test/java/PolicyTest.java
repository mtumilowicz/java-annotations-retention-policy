import org.junit.Test;

import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-09-30.
 */
public class PolicyTest {
    @Test
    public void runtimePolicy() {
        assertThat(RuntimePolicy.class.getAnnotations(), arrayWithSize(1));
        assertEquals(Deprecated.class, RuntimePolicy.class.getAnnotations()[0].annotationType());
    }

    @Test
    public void sourcePolicy() {
        assertThat(SourcePolicy.class.getAnnotations(), arrayWithSize(0));
    }

    @Test
    public void classPolicy() {
        assertThat(ClassPolicy.class.getAnnotations(), arrayWithSize(0));
    }
}
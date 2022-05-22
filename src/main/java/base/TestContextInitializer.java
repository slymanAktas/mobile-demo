package base;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestContextInitializer implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private static Statement statement(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                TestContext context = TestContext.init(description.getClassName(), description.getMethodName());
                Runtime.getRuntime().addShutdownHook(new Thread(context::whenTestStoppedByJvm, "shutdown-thread-when-test-stopping-somehow"));
                try {
                    base.evaluate();
                } finally {
                    TestContext.remove();
                }
            }
        };
    }
}

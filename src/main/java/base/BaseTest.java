package base;

import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class BaseTest {
    @Rule
    public TestRule chain = RuleChain
            .outerRule(new TestContextInitializer())
            .around(new TestStopper())
            .around(new TestWatcherItems());
}

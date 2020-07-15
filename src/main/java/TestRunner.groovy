import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BasePageTest.class)
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString())
        }
        SummaryGeneratingListener sum = new SummaryGeneratingListener()
        //sum.getSummary()
        System.out.println(result.wasSuccessful())
    }
}

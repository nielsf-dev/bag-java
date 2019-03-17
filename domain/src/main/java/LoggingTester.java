import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTester {
    private static final Logger logger = LoggerFactory.getLogger(LoggingTester.class);
    public static void main(String[] args){
        logger.debug("hello from logger");
        System.out.println("yello");
    }
}

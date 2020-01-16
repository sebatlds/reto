package com.google.www.interactions;

import com.google.www.util.TimeUtility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.awaitility.Awaitility;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import static com.google.www.util.TimeUtility.sucessfulCondition;

public class ImplicitWait implements Interaction {
    private static final Logger LOGGER = Logger.getLogger(ImplicitWait.class.getName());
    private int time;
    TimeUnit unit;

    public ImplicitWait(int time,TimeUnit unit) {
        this.time = time;
        this.unit=unit;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            Awaitility.await().forever().pollInterval(time, unit).until(TimeUtility.sucessfulCondition());

        } catch (Exception e) {
            LOGGER.info("=====INFO===== failed implicit wait sent.");
        }

    }

    public static ImplicitWait implicitWait(int time,TimeUnit unit) {

        return Tasks.instrumented(ImplicitWait.class, time,unit);
    }
}

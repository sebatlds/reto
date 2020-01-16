package com.google.www.tasks;

import com.google.www.userinterfaces.Wongpage;
import com.google.www.util.RandomValue;
import com.google.www.util.ChooseItemType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.google.www.userinterfaces.Wongpage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectArticleType implements Task {
    ChooseItemType chooseItemType = new ChooseItemType();
    RandomValue randomValue = new RandomValue();
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CLOSE_ALERT),
                Click.on(Wongpage.getArticleCategory(chooseItemType.getArticle(randomValue.getRandomValue(8))))
        );
    }

    public static SelectArticleType ofTheWongPage() {
        return instrumented(SelectArticleType.class);
    }
}

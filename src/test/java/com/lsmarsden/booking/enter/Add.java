package com.lsmarsden.booking.enter;

import com.lsmarsden.booking.navigation.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Add implements Task {

    private String todoItem;

    public Add(String todoItem) {
        this.todoItem = todoItem;
    }

    public static Add theItem(String todoItem) {
        return instrumented(Add.class, todoItem);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(todoItem).into(HomePage.TODO_FIELD),
                Click.on(HomePage.ADD_TODO_BUTTON)
        );
    }
}

package com.lsmarsden.booking.steps.parametertypes;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;

public class ParameterTypes {

    @ParameterType("[A-z]+")
    public Actor actor(String actor) {
        return Actor.named(actor);
    }
}

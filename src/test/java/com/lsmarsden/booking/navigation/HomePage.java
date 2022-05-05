package com.lsmarsden.booking.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://localhost:8080")
public class HomePage extends PageObject {
//    public static final Target TODO_FIELD = Target.the("Add todo field").located(By.id("todoField"));
    public static final Target TODO_FIELD = Target.the("Add todo field").located(By.id("vaadin-text-field-0"));

    public static final Target ADD_TODO_BUTTON = Target.the("Add todo button").located(By.id("addTodoButton"));

    public static final Target TODO_LIST = Target.the("Todo list").located(By.id("todoList"));

    public static final Target TODO_ITEMS = Target.the("Todo items").located(By.className("todoItem"));
}

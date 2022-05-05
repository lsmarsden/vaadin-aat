package com.lsmarsden.booking.steps;

import com.lsmarsden.booking.enter.Add;
import com.lsmarsden.booking.navigation.HomePage;
import com.lsmarsden.booking.navigation.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.CollectionEnsure;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.AnElementThat;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class HomePageSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{} opens the home page")
    public void openTheHomePage(String actor) {

        theActorCalled(actor).attemptsTo(NavigateTo.theHomePage());
    }

    @When("he/she/they add(s) an item to the to do list")
    public void theyAddAnItemToTheToDoList() {
        theActorInTheSpotlight().attemptsTo(Add.theItem("Banonos"));
    }

    @Then("the item is added to the to do list")
    public void theItemShouldBeInTheToDoList() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(HomePage.TODO_LIST).containsElements(By.className("todoItem"))
                .then(Ensure.thatTheListOf(ElementsLocated.by(HomePage.TODO_ITEMS)).hasSize(1))
                .then(Ensure.thatTheListOf(ElementsLocated.by(HomePage.TODO_ITEMS)).allMatch(AnElementThat.containsOnlyText("Banonos"))));
    }
}

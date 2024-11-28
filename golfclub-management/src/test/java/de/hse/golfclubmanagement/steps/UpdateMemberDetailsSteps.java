package de.hse.golfclubmanagement.steps;

import de.hse.golfclubmanagement.models.Member;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
public class UpdateMemberDetailsSteps {
    
    private Member member;

    @Given("a member exists")
    public void member_exists(){
        member = new Member();
        member.setName("Max Mustermann");
    }

    @When("the user changes their name")
    public void user_changes_name(){
        member.setName("Franz Mustermann");
    }

    @Then("the new name should be saved")
    public void using_new_name(){
        assertEquals("Franz Mustermann",member.getName());

    }
}



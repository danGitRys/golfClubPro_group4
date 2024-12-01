package de.hse.golfclubmanagement.steps;

import de.hse.golfclubmanagement.models.Member;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CancelMemebershipSteps {


    private Member member;

    @Given("user is a member")
    public void user_is_member() {
        member = new Member();
        member.setMembershipStatus("active");
    }

    @When("the user cancels his membership")
    public void user_cancels_membership() {
        member.setMembershipStatus("canceled");
    }

    @Then("the user should be no member anymore")
    public void user_no_member_anymore() {
        assertEquals("canceled", member.getMembershipStatus());
    }
}

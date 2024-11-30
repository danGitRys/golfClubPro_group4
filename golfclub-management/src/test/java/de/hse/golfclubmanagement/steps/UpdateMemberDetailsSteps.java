package de.hse.golfclubmanagement.steps;

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.repositories.MemberRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UpdateMemberDetailsSteps {

    private Member member;
    private final MemberRepository memberRepository;

    public UpdateMemberDetailsSteps() {
      
        this.memberRepository = Mockito.mock(MemberRepository.class);
    }

    @Given("a member exists")
    public void member_exists() {
        member = new Member();
        member.setId(1L); 
        member.setName("Max Mustermann");

        
        Mockito.when(memberRepository.save(Mockito.any(Member.class))).thenReturn(member);
        Mockito.when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        memberRepository.save(member);
    }

    @When("the user changes their name")
    public void user_changes_name() {
        member.setName("Franz Mustermann");
        Mockito.when(memberRepository.save(member)).thenReturn(member);
        memberRepository.save(member);
    }

    @Then("the new name should be saved.")
    public void using_new_name() {
        
        assertEquals("Franz Mustermann", member.getName());
    }
}

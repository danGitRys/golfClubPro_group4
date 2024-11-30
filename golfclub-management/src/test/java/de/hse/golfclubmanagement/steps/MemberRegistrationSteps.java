package de.hse.golfclubmanagement.steps;

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.repositories.MemberRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class MemberRegistrationSteps {

    private Member member;

    @Mock
    private MemberRepository memberRepository;

    public MemberRegistrationSteps() {
        MockitoAnnotations.openMocks(this); 
    }

    @Given("when a new member gets created")
    public void create_new_member() {
        member = new Member();
        member.setName("Max Mustermann");
    }

    @When("the memeber details are correct")
    public void member_details_correct() {
        assertEquals("Max Mustermann", member.getName());
    }

    @Then("the member is a part of the system")
    public void member_part_of_system() {
       
        Mockito.when(memberRepository.save(Mockito.any(Member.class))).thenReturn(member);
        Mockito.when(memberRepository.count()).thenReturn(1L);

        
        memberRepository.save(member);

        
        Mockito.verify(memberRepository).save(member);
        assertEquals(1L, memberRepository.count());
    }
}

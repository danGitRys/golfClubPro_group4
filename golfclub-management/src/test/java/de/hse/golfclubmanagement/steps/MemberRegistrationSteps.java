package de.hse.golfclubmanagement.steps;

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.repositories.MemberRepository;
import de.hse.golfclubmanagement.models.Member;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class MemberRegistrationSteps {
    private Member member;

    @Mock
    MemberRepository memberRepository;
    
     @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Given("when a new member gets created")
    public void create_new_member(){
        member = new Member();
        member.setName("Max Mustermann");
    }

    @When("the memeber details are correct")
    public void member_details_correct(){
        assertEquals("Max Mustermann",member.getName());
    }

    @Then("the member is a part of the system")
    public void memeber_part_of_system(){
        memberRepository.save(member);
        
        assertEquals(1L, memberRepository.count());
    }


}

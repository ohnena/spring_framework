package me.ohnena.demospring51;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // 왜 못찾지?
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest
public class OurEventControllerTest {
    //
    // 12 데이터바인딩#1 PropertyEditor...
    //

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {
        //System.out.println("JUNIT4------------------------------FirstTEST");
        mockMvc.perform(get("/event/1")). //인텔리제이가 get을 못찾는다?
                andExpect(status().isOk()).
                andExpect(content().string("1"));



    }


}
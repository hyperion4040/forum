/**
 * Created by Dawid Stankiewicz on 25.07.2016
 */
package edu.adrianKozlowski.forum;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class LoginPageTest extends ConfigTest {

    @Before
    public void setup() {
        this.mockMvc =
            MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testLoginView() throws Exception {

        mockMvc.perform(get("/login")).andExpect(view().name("login"));
    }

    @Test
    @Ignore
    public void testLogin() throws Exception {

        this.mockMvc
            .perform(post("/login")
                .param("username", "admin")
                .param("password", "password"))
            .andExpect(status()
                .is3xxRedirection())
            .andExpect(redirectedUrl("/"));
    }

}

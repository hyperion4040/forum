/**
 * Created by Dawid Stankiewicz on 29.07.2016
 */
package edu.adrianKozlowski.forum.exception;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.adrianKozlowski.forum.ConfigTest;
import org.junit.Test;


public class ExceptionHandlerTest extends ConfigTest {
    
    @Test
    public void notFoundErrorPage() throws Exception {
        mockMvc.perform(get("/fsasa4eraw4rffsref")).andExpect(status().isNotFound());
    }
}

package seg3102.basiccalculator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class WebControllerTest {
    @Autowired lateinit var mockMvc: MockMvc

    @Test
    fun request_to_home() {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.view().name("home"))
    }

    @Test
    fun basic_calc1() {
        mockMvc.perform(
           
                        MockMvcRequestBuilders.get("/calc")
                                .param("val1", "123")
                                .param("val2", "432")
                                .param("operation", "sum")
                )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.model().attribute("res", "555.00"))
                .andExpect(MockMvcResultMatchers.view().name("home"))

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/calc")
                                .param("val1", "0043")
                                .param("val2", "3234")
                                .param("operation", "difference")
                )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.model().attribute("res", "-3191.00"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
        
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/calc")
                                .param("val1", "341")
                                .param("val2", "-21")
                                .param("operation", "product")
                )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.model().attribute("res", "-7161.00"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
        mockMvc.perform(
           
                        MockMvcRequestBuilders.get("/calc")
                                .param("val1", "46")
                                .param("val2", "4")
                                .param("operation", "quotient")
                )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.model().attribute("res", "11.50"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
    }

}

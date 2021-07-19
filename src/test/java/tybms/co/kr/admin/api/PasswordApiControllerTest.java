package tybms.co.kr.admin.api;

import tybms.co.kr.admin.entity.Password;
import tybms.co.kr.admin.service.PasswordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PasswordApiController.class)
@AutoConfigureMockMvc
class PasswordApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordService passwordService;

    @DisplayName("Password 확인 요청")
    @Test
    void isMatch() throws Exception {
        Password password = Password.builder()
                .password("password")
                .build();
        String content = new ObjectMapper().writeValueAsString(password);
        given(this.passwordService.isMatch(any())).willReturn(true);

        ResultActions perform = mockMvc.perform(post("/passwords")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON));

        perform.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
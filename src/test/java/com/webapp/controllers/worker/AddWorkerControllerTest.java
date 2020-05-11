package com.webapp.controllers.worker;

import com.webapp.service.WorkerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/workerTestAdd.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/workerTestDel.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithUserDetails("testName")
class AddWorkerControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WorkerService workerService;

    @Test
    void testAddWorkerGet() throws Exception
    {
        this.mockMvc.perform(get("/worker/add"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testAddWorkerPost() throws Exception
    {
        this.mockMvc.perform(post("/worker/add")
                        .param("name", "name")
                        .param("lastname", "lastname")
                        .param("password", "password")
                        .param("role", "DIR")
                        .param("department", "testDepartment")
                        .param("post", "testPost")
                        .with(csrf()))
                .andDo(print())
                .andExpect(redirectedUrl("/worker/add"));
        Assert.assertNotNull(workerService.findByName("name"));
    }
}
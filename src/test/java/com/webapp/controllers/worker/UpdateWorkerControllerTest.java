package com.webapp.controllers.worker;

import com.webapp.entity.Worker;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
class UpdateWorkerControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WorkerService workerService;

    @Test
    void updateWorker() throws Exception
    {
        this.mockMvc.perform(get("/worker/update/10"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateWorker() throws Exception
    {
        Worker worker = workerService.findById(10L);

        this.mockMvc.perform(post("/worker/update")
                        .param("id","10")
                        .param("name","NameAssfAssd")
                        .param("lastname","testLastname")
                        .param("password","$2y$12$CeDWMqvJ.9FX3nP7sfTBR.TRxzO1kwEsSrNEDzFq7vrK6Iypm1Dgu")
                        .param("role", "GEN_DIR")
                        .param("department", "testDepartment")
                        .param("post", "testPost").with(csrf())
        )
                .andDo(print())
                .andExpect(redirectedUrl("/main"));
        Worker worker1 = workerService.findById(10L);
        Assert.assertNotEquals(worker, worker1);
    }
}
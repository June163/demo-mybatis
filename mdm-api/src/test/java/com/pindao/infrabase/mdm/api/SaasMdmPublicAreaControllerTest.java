package com.pindao.infrabase.mdm.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@Slf4j
public class SaasMdmPublicAreaControllerTest extends MdmApiApplicationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void queryByAreaId() throws Exception {
        /**
         * 构造参数
         */
        MdmPublicAreaQuery mdmPublicAreaQuery = new MdmPublicAreaQuery();
        mdmPublicAreaQuery.setAreaDepths((byte) 2);
        mdmPublicAreaQuery.setAreaId(86);
        log.info("param -> [{}]", mapper.writeValueAsString(mdmPublicAreaQuery));

        /**
         * url:不需要添加 server.servlet.context-path
         * 调用接口，传入添加的用户参数
         *
         */
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/publicArea/queryByAreaId")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(mdmPublicAreaQuery)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        /**
         * 设置返回结果
         */
        resultActions.andExpect(MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print());
    }
}
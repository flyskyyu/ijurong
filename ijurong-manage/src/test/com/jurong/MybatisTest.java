package com.jurong;

import com.party.ijurong.dto.StaffTokenDto;
import com.party.ijurong.mapper.StaffTokenMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class MybatisTest {
    @Test
    public void testStaffToken() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*");
        StaffTokenMapper mapper = (StaffTokenMapper)context.getBean("staffTokenMapper");
        StaffTokenDto dto = new StaffTokenDto();
        dto.setToken("882b89ea2e313b467be5db062aa02795");
        dto = mapper.queryByTokenDto(dto);
        System.out.println(dto);
        context.close();
    }
}

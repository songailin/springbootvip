package com.easysoft.dao;

import com.easysoft.App;
import com.easysoft.model.Users;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class UsersMapperTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void testAdd() {
        Users user = new Users();
        user.setUsername("songail");
        user.setPasswd("123456");
        usersMapper.insertSelective(user);
    }

    @Test
    public void testFindUser() {
        Users user = usersMapper.findByUsernameAndPasswd("songail", "123456");
        Assert.assertNotNull(user);
        Assert.assertEquals("songail", user.getUsername());
        Assert.assertEquals("123456", user.getPasswd());
    }
}

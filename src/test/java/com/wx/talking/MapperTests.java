package com.wx.talking;

import com.wx.talking.dao.DiscussPostMapper;
import com.wx.talking.dao.LoginTicketMapper;
import com.wx.talking.dao.UserMapper;
import com.wx.talking.entity.DiscussPost;
import com.wx.talking.entity.LoginTicket;
import com.wx.talking.entity.User;
import com.wx.talking.service.UserService;
import com.wx.talking.util.TalkingUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TalkingApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){

        User user = new User();
        for (int i = 0; i < 150; i++) {
            user.setUsername("test"+i);
//            user.setPassword("123"+ TalkingUtil.);
            user.setSalt("ads");
            user.setEmail("test"+i+"@qq.com");
            user.setHeaderUrl("https://images.nowcoder.com/head/"+i+"m.png");
            user.setCreateTime(new Date());
            int rows = userMapper.insertUser(user);
            System.out.println(rows);
        }

    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(2,1);
        System.out.println(rows);

        rows = userMapper.updateHeader(2,"http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(2,"hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10,0);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(2);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setStatus(0);
        loginTicket.setTicket("abc");
        loginTicket.setExpired(new Date(System.currentTimeMillis()+1000*60*10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc",1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Autowired
    private UserService userService;

    @Test
    public void testRegister(){
        User user = new User();
        user.setUsername("qq");
        user.setPassword("qq");
        user.setEmail("123@qq.com");

        System.out.println(userService.register(user));
    }
}

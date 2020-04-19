package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void findUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = ssf.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findById(0);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findByIds() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = ssf.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);

        List<User> userList = mapper.findByIds(list);

        System.out.println(userList);
    }

    @Test
    public void findOne() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = ssf.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        //user.setId(1);
        // user.setUsername("zhangsan");
        //user.setPassword("123");
        List<User> userList = mapper.findOne(user);

        System.out.println(userList);
    }
}

package com.yingjf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yingjf.mapper.UserMapper;
import com.yingjf.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void test1() {
        List list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    void test2() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("id",1);
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
    @Test
    void test3() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.ge("id" ,2);  //大于
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
    @Test
    void test4() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.le("id" ,2);  //大于
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
    @Test//不自增
    void test5() {
        User user = new User().setId(6L).setAge(3).setName("yingjf").setEmail("1374993958@qq.com");
        int i = userMapper.insert(user);
        System.out.println(user);
        System.out.println(i);
    }
    @Test//自增
    void test6() {
        User user = new User().setAge(3).setName("xxx").setEmail("xxx@qq.com");
        int i = userMapper.insert(user);
        System.out.println(user);
        System.out.println(i);
    }
    @Test//分页
    void test7() {
        Page page = new Page(2,3);
        List list = userMapper.selectPage(page, null).getRecords();
        list.forEach(System.out::println);
    }
}

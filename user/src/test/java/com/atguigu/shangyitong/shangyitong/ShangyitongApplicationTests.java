package com.atguigu.shangyitong.shangyitong;

import com.atguigu.shangyitong.shangyitong.entity.UserTable;
import com.atguigu.shangyitong.shangyitong.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ShangyitongApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //mp实现复杂查询操作
    @Test
    public void  testSelect(){
        QueryWrapper<UserTable> queryWrapper = new QueryWrapper<>();
        //ge,gt,le,lt
        queryWrapper.ge("age",22);
        List<UserTable> userTableList = userMapper.selectList(queryWrapper);
        System.out.println(userTableList);
    }

    //简单条件查询--条件构造器--分页
    @Test
    public void testSelectPage(){
        Page<UserTable> page = new Page(1,3);
        Page<UserTable> userpage = userMapper.selectPage(page,null);
        long pages = userpage.getPages();//获取总页数
        long current = userpage.getCurrent();//获取当前页
        List<UserTable> records = userpage.getRecords();//查询数据集合
        long total = userpage.getTotal(); //总记录数
        boolean hasNext = userpage.hasNext();//下一页
        boolean hasPrivious = userpage.hasPrevious();//上一页

        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrivious);
    }

    //多个id批量查询
    @Test
    public void testSelect1(){
        List<UserTable> userTableList = userMapper.selectBatchIds(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println(userTableList);
    }

    //测试乐观锁
    @Test
    public void testoptimisticLocker(){
        //根据Id
        UserTable userTable = userMapper.selectById(8);
        //修改
        userTable.setName("zhongyan");
        userMapper.updateById(userTable);
    }

    //添加
    @Test
    public void testAdd(){
        UserTable userTable = new UserTable();
        userTable.setAge(22);
        userTable.setName("zhongyan1");
        userTable.setEmail("156235132@qq.com");
        int result = userMapper.insert(userTable);
        System.out.println(result);
    }

    //修改
    @Test
    public void update(){
        UserTable userTable = new UserTable();
        userTable.setId(2);
        userTable.setName("zhaoxidi");
        int count = userMapper.updateById(userTable);
        System.out.println(count);
    }

    @Test
    public void findAll(){
        List<UserTable> userEntityList = userMapper.selectList(null);
        System.out.println(userEntityList);
    }

}

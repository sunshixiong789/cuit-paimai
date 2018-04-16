package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CuitAdminDaoTest {
    @Autowired
    private CuitAdminDao cuitAdminDao;

    @Test
    public void findByName(){
        System.out.println(cuitAdminDao.queryOne(1));
    }

    @Test
    public void queryTest(){
        CuitAdmin cuitAdmin = new CuitAdmin();
        cuitAdmin.setName("sun");
        Example example = Example.of(cuitAdmin);
        List<Object[]> list =cuitAdminDao.querytest(example);
        System.out.println(list);
    }
}
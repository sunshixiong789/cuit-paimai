package cn.edu.cuit.dao;

import cn.edu.cuit.dao.CuitPictureDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CuitPictureDaoTest {

    @Autowired
    private CuitPictureDao cuitPictureDao;

    @Test
    public void findByCuitCommodityId(){


    }
}
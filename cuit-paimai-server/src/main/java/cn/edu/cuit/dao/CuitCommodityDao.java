package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitCommodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ApplicationPower.
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitCommodityDao extends JpaRepository<CuitCommodity,Integer> {

    @Modifying
    @Query(value = "update CuitCommodity c set c.presentPrice = ?1 where c.id = ?2")
    public Integer updateById(String presentPrice,Integer id);
}
package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitCommodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

/**
 * Created by ApplicationPower.
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitCommodityDao extends JpaRepository<CuitCommodity,Integer> {

    /**
     * 通过id更新当前价格
     * @param presentPrice
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update CuitCommodity c set c.presentPrice = ?1,c.buyUserId = ?3, c.buyUserName = ?4 where c.id = ?2")
    Integer updateById(String presentPrice,Integer id,String buyUserId,String buyUserName);

    /**
     * 查看已经结束的商品
     * @param time
     * @param pageable
     * @return
     */
    Page<CuitCommodity> findByEndTimeBefore(Timestamp time, Pageable pageable);

}
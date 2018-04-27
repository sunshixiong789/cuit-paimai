package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitBid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/25 22:31
 */
public interface CuitBidDao extends JpaRepository<CuitBid,Integer> {

    public List<CuitBid> findByCommodityIdAndUserId(Integer commodityId,Integer userId);
}

package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitUserMoney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunshixiong
 * @date 2018/4/16 22:04
 */
public interface CuitUserMoneyDao extends JpaRepository<CuitUserMoney,Integer> {

    public CuitUserMoney findByUserId(String userId);
}

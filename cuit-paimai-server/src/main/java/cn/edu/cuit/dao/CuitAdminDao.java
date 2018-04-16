package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitAdmin;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ApplicationPower.
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitAdminDao extends JpaRepository<CuitAdmin,Integer>/*,JpaSpecificationExecutor*/ {

    /**
     * 通过登录名查询用户信息
     * @param name
     * @return
     */
    public CuitAdmin findByName(String name);

    @Query(value = "select u from CuitAdmin u where u.id = ?1",nativeQuery = false)
    public CuitAdmin queryOne(Integer id);

    @Query(value = "SELECT u.name,u.pass_word,u.type,p.bid_increment,p.auction_organization,p.cuit_commodity_id FROM cuit_admin u,cuit_auction_attribute p",nativeQuery = true)
    public List<Object[]> querytest(Example<CuitAdmin> example);
}
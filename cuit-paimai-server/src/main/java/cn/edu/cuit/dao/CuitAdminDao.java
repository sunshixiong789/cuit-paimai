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
    CuitAdmin findByName(String name);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    @Query(value = "select u from CuitAdmin u where u.id = ?1")
    CuitAdmin queryOne(Integer id);

    /**
     * 关联查找
     * @param example
     * @return
     */
    @Query(value = "SELECT u.name,u.pass_word,u.type,p.bid_increment,p.auction_organization,p.cuit_commodity_id FROM cuit_admin u,cuit_auction_attribute p",nativeQuery = true)
    List<Object[]> querytest(Example<CuitAdmin> example);
}
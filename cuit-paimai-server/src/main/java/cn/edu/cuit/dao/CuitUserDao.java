package cn.edu.cuit.dao;

import cn.edu.cuit.model.CuitUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ApplicationPower.
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitUserDao extends JpaRepository<CuitUser,Integer> {

    public CuitUser findByUserName(String userName);
}
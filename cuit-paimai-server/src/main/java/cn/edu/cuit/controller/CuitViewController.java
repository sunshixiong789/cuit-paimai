package cn.edu.cuit.controller;
import cn.edu.cuit.dao.CuitAuctionAttributeDao;
import cn.edu.cuit.dao.CuitCommodityDao;
import cn.edu.cuit.model.CuitCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * 页面控制层
 * @author sunshixiong
 * @date 2018/3/15 10:28
 */
@Controller
@RequestMapping("/")
public class CuitViewController {

    @Autowired
    private CuitCommodityDao cuitCommodityDao;
    @Autowired
    private CuitAuctionAttributeDao attributeDao;

    @GetMapping
    public String index(Model model,@AuthenticationPrincipal UserDetails user){
        model.addAttribute("commoditys",cuitCommodityDao.findAll());
        return "index";
    }
    @GetMapping("/user/view")
    public String user(Model model, Authentication authentication){
        model.addAttribute("hello","sdfasdfasdfasfasf");
        return "user_info";
    }
    @GetMapping("/login")
    public String login(Model model,String error){
        if ("false".equals(error)){
            model.addAttribute("error",error);
            model.addAttribute("login_message","你输入的登录信息有错");
        }
        return "loginin";
    }
    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("commoditys",cuitCommodityDao.findAll());
        return "shop";
    }

    @GetMapping(value = "/register")
    public String register(){

        return "register";
    }
    @GetMapping(value = "/userinfo")
    public String userinfo(){

        return "user_info";
    }
    @GetMapping(value = "/single-product")
    public String singleProduct(Model model,Integer id){
        Optional commodity = cuitCommodityDao.findById(id);
        CuitCommodity cuitCommodity = (CuitCommodity) commodity.get();
        model.addAttribute("commodity",cuitCommodity);
        model.addAttribute("attribute",attributeDao.findByCuitCommodityId(String.valueOf(cuitCommodity.getId())));
        return "single-product";
    }
    @GetMapping(value = "/car")
    public String car(){
        return "car";
    }

}

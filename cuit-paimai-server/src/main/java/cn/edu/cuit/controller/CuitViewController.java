package cn.edu.cuit.controller;
import cn.edu.cuit.dao.CuitAuctionAttributeDao;
import cn.edu.cuit.dao.CuitBidDao;
import cn.edu.cuit.dao.CuitCommodityDao;
import cn.edu.cuit.model.*;
import cn.edu.cuit.service.CuitBidHistoryService;
import cn.edu.cuit.service.CuitDescribeService;
import cn.edu.cuit.service.CuitUserMoneyService;
import cn.edu.cuit.service.CuitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
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
    @Autowired
    private CuitBidDao bidDao;

    @Autowired
    private CuitUserService userService;
    @Autowired
    private CuitUserMoneyService moneyService;

    @Autowired
    private CuitDescribeService describeService;
    @Autowired
    private CuitBidHistoryService bidHistoryService;

    @GetMapping
    public String index(Model model,@AuthenticationPrincipal UserDetails user){
        model.addAttribute("commoditys",cuitCommodityDao.findAll());
        return "index";
    }
    @GetMapping("/user/view")
    public String user(Model model, Authentication authentication){
        return "user_info";
    }
    @GetMapping("/login")
    public String login(Model model,String error){
        String key = "false";
        if (key.equals(error)){
            model.addAttribute("error",error);
            model.addAttribute("login_message","你输入的登录信息有错");
        }
        return "loginin";
    }
    @GetMapping("/shop")
    public String shop(Model model,String name){
        CuitCommodity cuitCommodity = new CuitCommodity();
        cuitCommodity.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
        Example example = Example.of(cuitCommodity,matcher);
        model.addAttribute("commoditys",cuitCommodityDao.findAll(example));
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

    /**
     * 展示商品详细信息
     * @param model
     * @param id
     * @param session
     * @return
     */
    @GetMapping(value = "/single-product")
    public String singleProduct(Model model,Integer id,HttpSession session){
        Optional commodity = cuitCommodityDao.findById(id);
        CuitCommodity cuitCommodity = (CuitCommodity) commodity.get();
        model.addAttribute("commodity",cuitCommodity);
        model.addAttribute("attribute",attributeDao.findByCuitCommodityId(cuitCommodity.getId()));
        model.addAttribute("describes",describeService.listByCommodityUuid(id));
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"endTime");
        CuitBidHistory bidHistory = new CuitBidHistory();
        bidHistory.setCuitCommodityId(String.valueOf(id));
        model.addAttribute("bidHistory",bidHistoryService.queryPage(bidHistory,pageable));
        CuitUser user = userService.findByUsername((String) session.getAttribute("username"));
        model.addAttribute("user",user);
        List<CuitBid> list = bidDao.findByCommodityIdAndUserId(id,user.getId());
        if(list.size()!=0){
            model.addAttribute("bidDao",list.get(0));
            model.addAttribute("bid",true);
        }
        else {
            model.addAttribute("bid",false);
        }
        return "single-product";
    }
    @GetMapping(value = "/car")
    public String car(Model model, HttpSession session){
        CuitUser user = userService.findByUsername((String) session.getAttribute("username"));
        model.addAttribute("user",user);
        return "car";
    }

    @GetMapping(value = "/money")
    public String money(Model model, HttpSession session){
        CuitUser user = userService.findByUsername((String) session.getAttribute("username"));
        CuitUserMoney money = moneyService.findByUserId(String.valueOf(user.getId()));
        model.addAttribute("user",user);
        if (money == null){
            model.addAttribute("money",new CuitUserMoney());
        }else {
            model.addAttribute("money",money);
        }
        return "money";
    }

    /**
     * @return
     */
    @GetMapping(value = "/message")
    public String message(){
        return "message";
    }

    @GetMapping(value = "/address")
    public String address(){
        return "address";
    }
    @GetMapping(value = "/bidhistory")
    public String bidhistory(Model model, HttpSession session){
        CuitUser user = userService.findByUsername((String) session.getAttribute("username"));
        model.addAttribute("user",user);
        return "bidhistory";
    }

    @GetMapping(value = "/timeLimt")
    public String timeLimt(Model model){
        CuitCommodity cuitCommodity = new CuitCommodity();
        cuitCommodity.setStatus("2");
        Example example = Example.of(cuitCommodity);
        model.addAttribute("commoditys",cuitCommodityDao.findAll(example));
        return "timeLimt";
    }

    @GetMapping(value = "/help")
    public String help(){
        return "help";
    }

}

package cn.algerfan.springboot.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author algerfan
 * @date 2019/10/16 13:29
 */
@Controller
public class TestController {

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    /**
     * 登陆页
     * @return
     */
    @GetMapping("/userLogin")
    public String loginPage() {
        return "pages/login";
    }

    /**
     * product页面映射
     * @param path
     * @return
     */
    @GetMapping("/product/{path}")
    public String product(@PathVariable("path")String path) {
        return "pages/product/"+path;
    }

    /**
     * order页面映射
     * @param path
     * @return
     */
    @GetMapping("/order/{path}")
    public String order(@PathVariable("path")String path) {
        return "pages/order/"+path;
    }

    /**
     * admin页面映射
     * @param path
     * @return
     */
    @GetMapping("/admin/{path}")
    public String admin(@PathVariable("path")String path) {
        return "pages/admin/"+path;
    }

}


package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.demo.domain.User;
import springboot.demo.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    /**
     * 登录
     *
     * @param user
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping("/loginsession")
    public String login(User user, HttpSession httpSession, Model model) {
        //验证用户名和密码，输入正确
        User u = userRepository.findByAccount(user.getAccount());
        //当账号存在时
        if (u!=null){
            String password=u.getPassword();
            if (user.getPassword().equals(password)) {
                httpSession.setAttribute("user", user.getAccount());
                return "redirect:/";
            } else  //输入错误，清空session，提示用户名密码错误
            {
                httpSession.invalidate();
                model.addAttribute("message", "密码错误，请重新输入！");
                return "login";
            }
        }else {   //账号不存在
            httpSession.invalidate();
            model.addAttribute("message", "账号不存在，请注册！");
            return "login";
        }
    }

    @RequestMapping("/dologin")
    public String dologin() {
        return "login";
    }

    /**
     * 退出登录
     *
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping("/logoff")
    public String logoff(HttpSession httpSession, Model model) {
        httpSession.invalidate();
        model.addAttribute("message", "您已退出，请重新登录！");
        return "login";
    }
}

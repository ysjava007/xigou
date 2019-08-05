package cn.itsource.plat.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.plat.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/user")
    public AjaxResult user(@RequestBody User user){
        if ("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())) {
            return AjaxResult.getAjaxResult().setSuccess(true).setMessage("登录成功").setRestObj(user);
        }
        return AjaxResult.getAjaxResult().setSuccess(false).setMessage("登录失败");
    }
}

package cn.itsource.common.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @PostMapping("/redis")
    public AjaxResult set(@RequestParam("key") String key,@RequestParam("value") String value){

        try {
            RedisUtils.INSTANCE.set(key, value);
            return AjaxResult.getAjaxResult().setSuccess(true).setMessage("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setSuccess(false).setMessage("失败");
        }

    }


    @GetMapping("/redis")
    public AjaxResult get(@RequestParam("key") String key){
        try {
            String s = RedisUtils.INSTANCE.get(key);
            return AjaxResult.getAjaxResult().setSuccess(true).setMessage("成功").setRestObj(s);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setSuccess(false).setMessage("失败");
        }
    }
}

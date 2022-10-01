package cn.j2go.mall.demo.error;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@ControllerAdvice
public class ErrorControllerAdvice {

//    @ExceptionHandler(BadCredentialsException.class)
//    public ModelAndView loginError(BadCredentialsException e) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code", 403);
//        map.put("msg", "用户不存在, username:" + e.getMessage());
//        map.put("tes", "用户不存在, username:" + e.getMessage());
//        return new ModelAndView("/login", map);
//    }

}

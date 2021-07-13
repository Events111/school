package com.evz.school.controller;

import com.evz.school.utils.MathNumGame;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/math")
public class GetMathController {
    /**
     * 设置数据，返回到freemarker视图
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public String getMath(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message", "SpringBoot 大爷你好！");
        mav.setViewName("helloWorld");

        MathNumGame mng = new MathNumGame();
        String s = mng.print2File();
        return s;
    }

    @RequestMapping("/get2")
    public ModelAndView addMath(){
        ModelAndView mav=new ModelAndView();
        MathNumGame mng = new MathNumGame();
        String s = mng.print2File();
        mav.addObject("msg",s);
        mav.setViewName("exam.html");
        return mav;
    }
}

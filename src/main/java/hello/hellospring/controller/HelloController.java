package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 1. 궁금증 requestMapping과 GetMapping 의 차이점
    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data","hello!!");

        return "Hello";
    }

    // 2. 궁금증 @RequestParam 왜? rmsid HttlServletRequest 쓰면 안되나?
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name",name); 

        return "hello-templet";
    }
    // ResponseBody의 의미 응답을 BODY에 직접하겠다. HTML BODY(X) HTTP BODY ! 객체는 JSON 형태로 반환한다.
    // viewresoler가 아니라 HttpMessageConveter가 동작
    // ResponseBody를 만나면 ㅇ
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello " + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName("Spring");
        return hello;
    }

    static class Hello
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

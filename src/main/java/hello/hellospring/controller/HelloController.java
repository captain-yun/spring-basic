package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    // http://localhost:8080/hello 에 접속했을 때 맵핑하여
    // hello 문자를 반환
//    @GetMapping("hello1")
//    @ResponseBody
//    public String hello1() {
//       return "hello";
//    }

    // "thymeleaf 템플릿 엔진"을 사용하여 뷰 전달
    // 데이터를 전달하기 위해 Model이 필요
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Joe");
        // 여기서 리턴값 hello는? -> view name
        return "hello";
    }

    // 클라이언트로부터 name을 받아 타임리프엔진을 통해 동적 html 반환
//    @PostMapping("hello-template")
//    @RequestMapping("hello-template")
    @GetMapping("hello-template")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방식 (response body에 직접 넣어서 응답)
    // @ResponseBody -> 뷰 리졸버 거치지 않음 (뷰 호출 x)
    @GetMapping("hello-api")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello, " + name;
    }

    // API 방식 (객체 반환, JSON)
    // member : name, age
    // View를 반환하는게 아니므로 Model은 필요 x
    @GetMapping("hello-api-json")
    @ResponseBody
    public Member helloApiJson(@RequestParam("name") String name,
                               @RequestParam("age") int age) {
        Member member = new Member();
        member.setName(name);
        member.setAge(age);

        return member;
    }

    static class Member {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

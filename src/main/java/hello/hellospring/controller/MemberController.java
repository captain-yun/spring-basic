package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원등록
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // 회원 데이터가 POST방식으로 들어옴
    @PostMapping("/members/new")
    public String createMember(@RequestParam String name,
                               @RequestParam int age) {
        Member member = new Member(name, age);

        memberService.join(member);

        return "redirect:/";
    }
    // 회원 리스트 출력 (JSON)
//    @GetMapping("/members")
//    public List<Member> memberList() {
//        List<Member> members = memberService.findMembers();
//        return members;
//    }
    // 회원 리스트 출력 (VIEW)
    @GetMapping("/members")
    public String memberList(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/members/delete")
    public String createDeleteForm() {
        return "members/deleteMemberForm";
    }

//    @DeleteMapping("/members/{name}")
//    public String deleteMember(@PathVariable ) {
//
//    }
}

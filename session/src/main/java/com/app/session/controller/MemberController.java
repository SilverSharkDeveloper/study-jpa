package com.app.session.controller;

import com.app.session.domain.MemberDTO;
import com.app.session.exception.LoginFailedException;
import com.app.session.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("join")
    public String goToJoinForm(MemberDTO memberDTO){
        return "/member/join";
    }

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO);
        return new RedirectView("/member/login");
    }

    @GetMapping("login")
    public String goToLoginForm(){
        return "/member/login";
    }

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO, HttpSession session){
        memberService.login(memberDTO.getMemberId(), memberDTO.getMemberPassword())
                .ifPresentOrElse(member -> {
                    session.setAttribute("role", member.getMemberRole().name());
                    session.setAttribute("memberId", member.getMemberId());
                    session.setAttribute("id", member.getId());
                    session.setMaxInactiveInterval(1800);
                },  () -> {throw new LoginFailedException();});

        return new RedirectView("/board/list");
    }

    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/member/login");
    }

}






















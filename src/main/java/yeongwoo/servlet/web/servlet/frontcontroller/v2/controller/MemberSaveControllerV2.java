package yeongwoo.servlet.web.servlet.frontcontroller.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yeongwoo.servlet.domain.member.Member;
import yeongwoo.servlet.domain.member.MemberRepository;
import yeongwoo.servlet.web.servlet.frontcontroller.MyView;
import yeongwoo.servlet.web.servlet.frontcontroller.v1.ControllerV1;
import yeongwoo.servlet.web.servlet.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        Member member = new Member(username, Integer.parseInt(age));
        memberRepository.save(member);

        req.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}


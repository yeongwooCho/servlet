package yeongwoo.servlet.web.servlet.frontcontroller.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yeongwoo.servlet.domain.member.Member;
import yeongwoo.servlet.domain.member.MemberRepository;
import yeongwoo.servlet.web.servlet.frontcontroller.v1.ControllerV1;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        Member member = new Member(username, Integer.parseInt(age));
        memberRepository.save(member);

        req.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}

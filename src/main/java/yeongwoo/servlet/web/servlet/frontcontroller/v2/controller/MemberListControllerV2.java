package yeongwoo.servlet.web.servlet.frontcontroller.v2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yeongwoo.servlet.domain.member.MemberRepository;
import yeongwoo.servlet.web.servlet.frontcontroller.MyView;
import yeongwoo.servlet.web.servlet.frontcontroller.v2.ControllerV2;

public class MemberListControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("members", memberRepository.findAll());
        return new MyView("/WEB-INF/views/members.jsp");
    }
}

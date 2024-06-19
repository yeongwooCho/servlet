package yeongwoo.servlet.web.servlet.frontcontroller.v3.controller;

import yeongwoo.servlet.domain.member.Member;
import yeongwoo.servlet.domain.member.MemberRepository;
import yeongwoo.servlet.web.servlet.frontcontroller.ModelView;
import yeongwoo.servlet.web.servlet.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);

        return modelView;
    }
}

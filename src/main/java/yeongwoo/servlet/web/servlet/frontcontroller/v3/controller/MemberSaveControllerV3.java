package yeongwoo.servlet.web.servlet.frontcontroller.v3.controller;

import yeongwoo.servlet.domain.member.Member;
import yeongwoo.servlet.domain.member.MemberRepository;
import yeongwoo.servlet.web.servlet.frontcontroller.ModelView;
import yeongwoo.servlet.web.servlet.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}

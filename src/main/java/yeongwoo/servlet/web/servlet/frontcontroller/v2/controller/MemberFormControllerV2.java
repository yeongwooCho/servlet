package yeongwoo.servlet.web.servlet.frontcontroller.v2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yeongwoo.servlet.web.servlet.frontcontroller.MyView;
import yeongwoo.servlet.web.servlet.frontcontroller.v2.ControllerV2;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}

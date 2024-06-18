package yeongwoo.servlet.web.servlet.frontcontroller.v2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yeongwoo.servlet.web.servlet.frontcontroller.MyView;

public interface ControllerV2 {
    MyView process(HttpServletRequest req, HttpServletResponse resp);
}

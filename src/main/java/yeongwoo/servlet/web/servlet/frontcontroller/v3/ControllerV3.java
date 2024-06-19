package yeongwoo.servlet.web.servlet.frontcontroller.v3;

import yeongwoo.servlet.web.servlet.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}

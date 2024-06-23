package yeongwoo.servlet.web.servlet.frontcontroller.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yeongwoo.servlet.web.servlet.frontcontroller.ModelView;
import yeongwoo.servlet.web.servlet.frontcontroller.MyView;
import yeongwoo.servlet.web.servlet.frontcontroller.v3.controller.MemberFormControllerV3;
import yeongwoo.servlet.web.servlet.frontcontroller.v3.controller.MemberListControllerV3;
import yeongwoo.servlet.web.servlet.frontcontroller.v3.controller.MemberSaveControllerV3;
import yeongwoo.servlet.web.servlet.frontcontroller.v4.ControllerV4;
import yeongwoo.servlet.web.servlet.frontcontroller.v4.controller.MemberFormControllerV4;
import yeongwoo.servlet.web.servlet.frontcontroller.v4.controller.MemberListControllerV4;
import yeongwoo.servlet.web.servlet.frontcontroller.v4.controller.MemberSaveControllerV4;
import yeongwoo.servlet.web.servlet.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import yeongwoo.servlet.web.servlet.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        // v3
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        // v4
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 핸들러 찾기
        Object handler = getHandler(req);
        if (handler == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler); // 핸들러 어댑터 찾기

        ModelView mv = adapter.handle(req, resp, handler); // 핸들러 호출

        MyView view = viewResolver(mv.getViewName()); // 뷰 리졸버 호출: 논리이름을 물리이름으로 변경

        view.render(mv.getModel(), req, resp); // 뷰 렌더링
    }

    private Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}

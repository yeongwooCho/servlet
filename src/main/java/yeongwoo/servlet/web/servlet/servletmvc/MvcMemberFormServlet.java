package yeongwoo.servlet.web.servlet.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // Controller에서 View로 이동할 때 사용하는 인터페이스
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);

        // forward를 이용하면 servlet에서 jsp를 호출할 수 있다.
        // forward는 서버 내부에서 다시 호출이 발생한다. -> 제어권을 JSP에게 넘긴다.
        dispatcher.forward(req, resp);
    }
}

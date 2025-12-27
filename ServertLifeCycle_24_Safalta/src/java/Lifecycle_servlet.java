import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ServletLifeCycle")
public class Lifecycle_servlet extends HttpServlet {
    String message = "";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message += "init() method called<br>";
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        message += "service() method called<br>";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Servlet Life Cycle Demo</h2>");
        out.println("<hr>");
        out.println(message);
    }
    @Override
    public void destroy() {
        message += "destroy() method called<br>";
    }
}
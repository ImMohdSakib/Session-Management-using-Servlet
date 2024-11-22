import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        req.getRequestDispatcher("link.html").include(req, res);

        Cookie ck = new Cookie("name", "");
        ck.setMaxAge(0);
        res.addCookie(ck);
        pw.print("You are successfully logged out!");
        pw.close();
    }
}

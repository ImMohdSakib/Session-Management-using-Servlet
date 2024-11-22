import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        req.getRequestDispatcher("link.html").include(req, res);

        Cookie[] cookies = req.getCookies();
        String name = null;
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("name".equals(ck.getName())) {
                    name = ck.getValue();
                    break;
                }
            }
        }

        // Check if name is not null and not empty
        if (name != null && !name.trim().equals("")) {
            pw.print("<br> Welcome to Profile");
            pw.print("<br> Welcome, " + name);
        } else {
            pw.print("Please log in first");
            req.getRequestDispatcher("login.html").include(req, res);
        }

        pw.close();
    }
}

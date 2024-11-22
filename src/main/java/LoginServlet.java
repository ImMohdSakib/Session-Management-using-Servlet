import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        req.getRequestDispatcher("link.html").include(req, res);

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if ("admin123".equals(password)) {
            pw.print("You are successfully logged in");
            pw.print("<br> Welcome, " + name);

            // Creating and setting cookie correctly
            Cookie ck = new Cookie("name", name);
            ck.setMaxAge(60*60); // Cookie ko expire hone ke liye 1 hour set karna
            res.addCookie(ck);
        } else {
            pw.print("Sorry username or password error!");
            req.getRequestDispatcher("login.html").include(req, res);
        }
        pw.close();
    }
}

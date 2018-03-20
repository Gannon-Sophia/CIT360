
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sophie
 */
public class MyFirstServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                    
                out.println("<h1>Welcome to my Servlet application</h1>");
                out.println("<h3>Perseverance</h3>");
                out.println("<p>Perseverance is demonstrated by those who keep going when the going gets tough,"
                        + "<br> who donot give up even when others say, It canot be done, "
                        + "James E Faust.</p>");
                    
        } finally {
                out.close();
        }

    }
}

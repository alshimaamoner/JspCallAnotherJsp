import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
    userValidation userValidation=new userValidation();
    TodoService todoService=new TodoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
       String name=request.getParameter("name");
       String pass=request.getParameter("password");
       String todos=todoService.retriveTodo().toString();
       if(userValidation.isValid(name,pass)) {
           request.setAttribute("name", name);
           request.setAttribute("password", pass);
           request.setAttribute("todos",todos);
           request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);

       }else{
           request.setAttribute("errorMessage", "Invalid Username or Pass");

           request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

       }
    }
}

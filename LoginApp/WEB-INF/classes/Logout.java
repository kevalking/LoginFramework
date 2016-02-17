import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.gvp.log.*;

public class Logout extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        doPost(req, res);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
		HttpSession session = req.getSession(true);
		if(req.getRequestedSessionId()!=null && !req.isRequestedSessionIdValid())
		{
				LogManager.getInstance().log("Session Invalidate ",LogManager.State.INFO);
				res.sendRedirect("/LoginApp/");
		}
        String unm=req.getParameter("unm");
        out.println("<html><head><link rel='stylesheet' href='stylesheet\\style.css'>" + 
		"</head><body>" +
        "<center><h1><font face='arial' color='gray'>Login Success</font></h1>" +
        "<div id='logout'><a href='/LoginApp/'>Logout</a></div></center>" +
        "<h2>Welcome "+unm+" ...</h2>" +
        "</body></html>");
		//LogManager.getInstance().log("Logout successful ",LogManager.State.INFO);
		session.invalidate();
		
    }
}
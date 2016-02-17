import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

import org.gvp.cryptography.*;
import org.gvp.database.*;
import org.gvp.log.*;
import org.gvp.exception.*;

public class Login extends HttpServlet
{
    Connection con=null;
    Statement st;
    ConnectionFactory conn_fact=new MySqlFactory();
    Application app = new Application(conn_fact);
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        doGet(req,res);
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        //LogManager.getInstance().log("Hello");
        PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        LogManager.getInstance().log("Application started.. ",LogManager.State.INFO);
        String btnName=req.getParameter("btn");

        if(btnName.equals("Login"))
        {
            String unm=req.getParameter("unm");
            String pass=req.getParameter("pass");
            Chain notNull=new NotNull(Chain.Three);
            Chain pwdGT5=new PwdGT5(Chain.Two);
            Chain alNum=new AlNum(Chain.One);
            if(unm.equals("") || pass.equals(""))
            {
                out.println("<html><body><center><h1><font color='red'>Exception</font></h1><br>");
                out.println("<h3>"+notNull.writeMessage()+"</h3>");
                out.println("<a href='/LoginApp'><--Go Back</a>");
                out.println("</center></body></html>");
				LogManager.getInstance().log("Error in Application",LogManager.State.ERROR);

            }
            else if(pass.length()<5)
            {
                pwdGT5 = new PwdGT5(Chain.Two);
                notNull.setNext(pwdGT5);
                out.println("<html><body><center><h1><font color='red'>Exception</font></h1><br>");
                out.println("<h3>"+pwdGT5.writeMessage()+"</h3>");
                out.println("<a href='/LoginApp'><--Go Back</a>");
                out.println("</center></body></html>");
				LogManager.getInstance().log("Error in Application ",LogManager.State.ERROR);

            }
            else
            {
                if(this.isAlphaNumeric(pass))
                {
                    alNum = new AlNum(Chain.One);
                    pwdGT5.setNext(alNum);
                    out.println("<html><body><center><h1><font color='red'>Exception</font></h1><br>");
                    out.println("<h3>"+alNum.writeMessage()+"</h3>");
                    out.println("<a href='/LoginApp'><--Go Back</a>");
                    out.println("</center></body></html>");
					LogManager.getInstance().log("Error in Application ",LogManager.State.ERROR);
                }
                else
                {
                    try
                    {
						LogManager.getInstance().log("Database Connecting.. ",LogManager.State.INFO);
                        boolean flag=true;
                        con=app.connect("localhost", "test", "root","root");
                        st=con.createStatement();
                        ResultSet rs;
                        Cryptography cr=new Cryptography(new AES());
                        String qry="select * from registration where unm='"+unm+"'";
                        rs=st.executeQuery(qry);
                        byte[] b;
                        while(rs.next() && flag)
                        {
                            b=rs.getBytes("pass");
                            String p=cr.getDecrypted(b).toString();
							if(pass.equals(p))
								flag=false;
                        }
						LogManager.getInstance().log("Password Authenticating.. ",LogManager.State.INFO);
						HttpSession session = req.getSession(true);
						if(!flag)
						{
							if(req.getRequestedSessionId()!=null && !req.isRequestedSessionIdValid())
							{
								LogManager.getInstance().log("Login Successful..",LogManager.State.INFO);
								LogManager.getInstance().log("Session Created.. ",LogManager.State.INFO);
								session.setAttribute("unm", unm);
								res.sendRedirect("/LoginApp/logout?unm='"+unm+"'");
							}
							else
							{
								session.invalidate();
								session.setAttribute("unm", unm);
								res.sendRedirect("/LoginApp/logout?unm='"+unm+"'");
							}
							
						}
                        else
                        {
							LogManager.getInstance().log("Login Error..",LogManager.State.ERROR);
                            out.println("<html><body><center><h1><font color='red'>Exception</font></h1><br>");
                            out.println("<h3>"+"Invalid UserName/Password"+"</h3>");
                            out.println("<a href='/LoginApp'><--Go Back</a>");
                            out.println("</center></body></html>");
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if(btnName.equals("Register"))
        {
			 String unm=req.getParameter("unm");
			 String pass=req.getParameter("pass");
			 String city=req.getParameter("city");
			 String dob=req.getParameter("dob");
			 String mobile=req.getParameter("mob");
			 Cryptography cr=new Cryptography(new AES());
             byte byte_pass[]=cr.getEncrypted(pass);
			 try
			 {

					con=app.connect("localhost", "test", "root","root");
                    st=con.createStatement();
                    String qry1="insert into registration (unm,pass,city,dob,mob) values (?,?,?,?,?) ";
                    out.println(qry1);
                    PreparedStatement psmt=con.prepareStatement(qry1);
                    psmt.setString(1, unm);
                    psmt.setBytes(2, byte_pass);
                    psmt.setString(3, city);
					psmt.setString(4, dob);
					psmt.setString(5, mobile);
					
					if((psmt.executeUpdate())>0)
					{
						LogManager.getInstance().log("Registration Successful..",LogManager.State.INFO);
						JOptionPane.showMessageDialog(null,"Successful", "Done...!",JOptionPane.INFORMATION_MESSAGE);
						res.sendRedirect("/LoginApp");
					}
					else
					{
						LogManager.getInstance().log("Registration not Done..",LogManager.State.ERROR);
						JOptionPane.showMessageDialog(null,"Unsuccessful", "Error...!",JOptionPane.ERROR);
					}
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
        }
        else
        {
            out.println("<h1>Invalid</h1>");
        }
    }
    private boolean isAlphaNumeric(String s)
    {
        String pattern="^[A-Za-z]*$";
        String pattern2="^[0-9]*$";
        if(s.matches(pattern2) || s.matches(pattern))
            return true;
     
       return false;
    }
}
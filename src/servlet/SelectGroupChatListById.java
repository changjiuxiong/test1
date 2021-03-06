package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Group;
import model.User;
import service.GroupService;
import service.UserService;
import serviceImpl.GroupServiceImpl;
import serviceImpl.UserServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class SelectGroupChatListById
 */
@WebServlet("/SelectGroupChatListById")
public class SelectGroupChatListById extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		/*设置响应头允许ajax跨域访问*/
		response.setHeader("Access-Control-Allow-Origin","*");  
		/*星号表示所有的异域请求都可以接受，*/  
		response.setHeader("Access-Control-Allow-Methods","GET,POST");  
		
		String id = request.getParameter("id");
		List<Group> groups=new ArrayList<Group>();
		GroupService groupService=new GroupServiceImpl();
		groups = groupService.selectGroupChatListById(id);
		PrintWriter out=response.getWriter();
		
		Gson gson =new Gson();
	    String str=gson.toJson(groups);
	    
		out.print(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

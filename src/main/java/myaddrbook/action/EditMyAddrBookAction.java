package myaddrbook.action;

import com.alibaba.fastjson.JSONObject;
import myaddrbook.pojo.MyAddrBook;
import myaddrbook.service.IMyAddrBookService;
import myaddrbook.service.IMyAddrBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Servlet implementation class EditMyAddrBookAction
 */
@WebServlet("/editMyAddrBook.action")
public class EditMyAddrBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//控制层依赖于业务逻辑层
	private IMyAddrBookService myAddrbookService = new IMyAddrBookServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMyAddrBookAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get value
		InputStream in = request.getInputStream();
		InputStreamReader reader = new InputStreamReader(in,"utf-8");
		char[] ch = new char[1024];
		int len = 0;
		StringBuffer buffer = new StringBuffer();
		while( (len=reader.read(ch)) != -1 ){
			buffer.append(new String(ch,0,len));
		}
		System.out.println("buffer="+buffer.toString());
		MyAddrBook myAddrBook = JSONObject.parseObject(buffer.toString(),MyAddrBook.class);

		if(myAddrBook == null){
			throw new RuntimeException("MyAddrBook is null");
		}
		int id = myAddrBook.getId();

//		String id = request.getParameter("id");
//		String firstName = request.getParameter("firstName");
//		System.out.println("firstName="+firstName);
//		String lastName = request.getParameter("lastName");
//		String jobTitle = request.getParameter("jobTitle");
//		String department = request.getParameter("department");
//		String mobile = request.getParameter("mobile");
//		String offPh = request.getParameter("offPh");
//		String email = request.getParameter("email");
//
//		//封装成MyAddrBook对象
//		MyAddrBook myAddrBook = new MyAddrBook();
//		myAddrBook.setFirstName(firstName);
//		myAddrBook.setLastName(lastName);
//		myAddrBook.setJobTitle(jobTitle);
//		myAddrBook.setDepartment(department);
//		myAddrBook.setMobile(mobile);
//		myAddrBook.setOffPh(offPh);
//		myAddrBook.setEmail(email);

		Boolean flag = false;
		if(id > 0) {
			myAddrBook.setId(id);
			flag = myAddrbookService.updateMyAddrBook(myAddrBook);
		}else {
			//调用业务逻辑层去保存
			flag = myAddrbookService.saveMyAddrBook(myAddrBook);
		}

//		String url="editMyAddrBook.jsp";
		JSONObject jsonObject = new JSONObject();
		if(flag) {
			jsonObject.put("res",1);
//			url="editMyAddrBookSuccess.jsp";
		}else {
			jsonObject.put("res",0);
//			request.setAttribute("message", "保存失败");
		}
		response.getWriter().println(jsonObject);
		//请求转发
//		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

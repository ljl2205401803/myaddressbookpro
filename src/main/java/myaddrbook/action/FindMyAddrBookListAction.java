package myaddrbook.action;

import com.alibaba.fastjson.JSONArray;
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
import java.util.List;

/**
 * Servlet implementation class FindMyAddrBookListAction
 */
@WebServlet("/findMyAddrBookList.action")
public class FindMyAddrBookListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//控制层依赖于业务逻辑层
	private IMyAddrBookService myAddrbookService = new IMyAddrBookServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMyAddrBookListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "list.jsp";
		//get Value
		String id = request.getParameter("id");
		if(id!=null && !"".equals(id.trim())) {
			MyAddrBook myAddrBook = myAddrbookService.findMyAddrBookById(Integer.parseInt(id));
			String strJson = JSONObject.toJSONString(myAddrBook);
			JSONObject object = JSONObject.parseObject(strJson);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(object);
//			request.setAttribute("myAddrBook", myAddrBook);
//			url="editMyAddrBook.jsp";
		}else {
			List<MyAddrBook> list = myAddrbookService.findAll();
			JSONArray jsonArray = new JSONArray();
			for(MyAddrBook myAddrBook : list){
				String strJson = JSONObject.toJSONString(myAddrBook);
				JSONObject object = JSONObject.parseObject(strJson);
				jsonArray.add(object);
			}
//			response.setHeader();
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(jsonArray);
			//将list保存为request的属性
//			request.setAttribute("myAddrBookList", list);
		}
		
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

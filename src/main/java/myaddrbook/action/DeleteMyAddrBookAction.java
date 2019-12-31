package myaddrbook.action;

import myaddrbook.service.IMyAddrBookService;
import myaddrbook.service.IMyAddrBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteMyAddrBookAction
 */
@WebServlet("/deleteMyAddrBook.action")
public class DeleteMyAddrBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//���Ʋ�������ҵ���߼���
	private IMyAddrBookService myAddrbookService = new IMyAddrBookServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMyAddrBookAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="findMyAddrBookList.action";
		String id = request.getParameter("id");
		Boolean flag = false;
		if(id!=null && !"".equals(id.trim())) {
			flag = myAddrbookService.deleteById(Integer.parseInt(id));
		}
		if(!flag) {
			request.getSession().setAttribute("message", "ɾ��ʧ��");
		}
		//����ת��
		//request.getRequestDispatcher(url).forward(request, response);
		//�ض���
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

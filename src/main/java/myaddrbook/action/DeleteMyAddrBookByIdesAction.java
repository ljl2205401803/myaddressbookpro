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
 * Servlet implementation class DeleteMyAddrBookByIdesAction
 */
@WebServlet("/deleteMyAddrBookByIdes.action")
public class DeleteMyAddrBookByIdesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMyAddrBookService myAddrbookService = new IMyAddrBookServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMyAddrBookByIdesAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get value
		String[] str = request.getParameterValues("ides");
		
		String url="findMyAddrBookList.action";
		Boolean flag = false;
		if(str!=null && str.length>0) {
			int[] ides = new int[str.length];
			for(int i=0;i<str.length;i++) {
				ides[i] = Integer.parseInt(str[i]);
			}
			
			flag = myAddrbookService.deleteByIdes(ides);
		}
		if(!flag) {
			request.getSession().setAttribute("message", "É¾³ıÊ§°Ü");
		}

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

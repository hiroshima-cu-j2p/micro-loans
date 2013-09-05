package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import dto.UserList;

import service.GetBorrowerData;
import service.GetInvestorData;
import service.GetUserData;

/*
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String borrowerIdUi = request.getParameter("borrowerId");
		RequestDispatcher rd = null;
		if (borrowerIdUi != null) {
			GetBorrowerData borrowerData = new GetBorrowerData();
			try {
				UserList investorList = borrowerData.getBorrowerData(borrowerIdUi);
				request.getSession().setAttribute("InvesterBorrowerData", investorList);

				rd = request.getRequestDispatcher("borrower.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GetUserData userData = new GetUserData();
		String userNameUi = request.getParameter("username");
		String passwordUi = request.getParameter("password");
		String lendingAmountUi = request.getParameter("Lending");
		String investRequest = request.getParameter("param");
		if(investRequest!=null && investRequest.equals("invest")){
			RequestDispatcher rd = null;
			GetInvestorData investMoney = new GetInvestorData();
			try {
				UserList userList=investMoney.updateMoney(lendingAmountUi);
				request.getSession().setAttribute("investorHistoryData", userList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("investHistory.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = null;
	
			User user = null;
			try {
				user = userData.userAuthentication(userNameUi, passwordUi);
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			String dbUserName = user.getUser_name();
			String dbPassword = user.getPwd();
			String dbAuth = user.getAuth();
			String dbId = user.getId();
	
			if (userNameUi.equals(dbUserName) && passwordUi.equals(dbPassword)) {
				request.getSession().setAttribute("UserData", userNameUi);
				if (dbAuth.equals("1")) {
					UserList userList = new UserList();		
					GetInvestorData investorData = new GetInvestorData();					
					try {
						userList = investorData.getBorrowerList(dbId);
						request.getSession().setAttribute("BorrowerData", userList);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rd = request.getRequestDispatcher("investMoney.jsp");
					rd.forward(request, response);
				} else if (dbAuth.equals("0")) {
					UserList borrowerList = new UserList();
					GetBorrowerData borrowerData = new GetBorrowerData();
	
					try {
						borrowerList = borrowerData.getBorrowerList();
						request.getSession().setAttribute("BorrowerList",
								borrowerList);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
					rd = request.getRequestDispatcher("borrowerList.jsp");
					rd.forward(request, response);
				}
	
			} else {
				response.sendRedirect("login.jsp");
				return;
			}
		}
	}

}

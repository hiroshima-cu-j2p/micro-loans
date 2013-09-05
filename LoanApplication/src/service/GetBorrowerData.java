package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionManager;
import dto.User;
import dto.UserList;

public class GetBorrowerData {
	public GetBorrowerData() {

	}

	/*
	 * METHOD NAME: userAuthentication DESCRIPTION: the method to refer a user
	 * to the Database PARAMETER: UserName(sting) Password(string)
	 */

	public UserList getBorrowerList() throws SQLException {
		ConnectionManager conManger = new ConnectionManager();
		Connection con = conManger.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		String sql = "select ID, auth, user_name, first_name, middle_name, family_name, pwd, location, brw_ID, req_amount from MS_USER MSU, MS_BORROWER MSB where MSU.ID = MSB.user_ID and MSU.auth = '2'";

		stmt = con.prepareStatement(sql);

		rs = stmt.executeQuery();
		String id = "";
		UserList borrowerList = new UserList();
		List userList = new ArrayList();
		while (rs.next()) {
			User usr = new User();
			usr.setId(rs.getString("ID"));
			usr.setAuth(rs.getString("auth"));
			usr.setUser_name(rs.getString("user_name"));
			usr.setFirst_name(rs.getString("first_name"));
			usr.setMiddle_name(rs.getString("middle_name"));
			usr.setFamily_name(rs.getString("family_name"));
			usr.setPwd(rs.getString("pwd"));
			usr.setLocation(rs.getString("location"));
			usr.setBrw_id(rs.getString("brw_ID"));
			usr.setReq_amount(rs.getInt("req_amount"));
			userList.add(usr);

		}

		borrowerList.setUsers(userList);
		return borrowerList;

	}

	public UserList getBorrowerData(String id) throws SQLException {
		ConnectionManager conManger = new ConnectionManager();
		Connection con = conManger.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		String sql = "select "
				+ "MSU.ID as borrower_user_id, "
				+ "MSU.user_name as borrower_name, "
				+ "MSI.location as inv_location, "
				+ "MSI.ID as inv_user_id, "
				+ "MSI.user_name as inv_user_name, "
				+ "MSI.first_name as inv_first_name, "
				+ "MSI.middle_name as inv_middle_name, "
				+ "MSI.family_name as inv_family_name, "
				+ "TRI.amount_invested, "
				+ "TRI.amount_repaid, "
				+ "TRI.date_invested, "
				+ "TRI.date_repayed "
				+ "from  "
				+ "MS_USER MSU, "
				+ "MS_BORROWER MSB, "
				+ "TR_INVEST TRI, "
				+ "(select * from MS_USER sMSU, MS_INVERSTER sMSI where sMSU.ID = sMSI.user_ID) MSI  "
				+ "where  " + "MSU.ID = MSB.user_ID "
				+ "and MSI.inv_ID = TRI.inv_ID  "
				+ "and MSB.brw_ID = TRI.brw_ID  " + "and MSU.ID = '" + id + "'";
		stmt = con.prepareStatement(sql);

		rs = stmt.executeQuery();

		
		UserList investorList = new UserList();
        List userList = new ArrayList();
		if (rs != null) {
			while (rs.next()) {
                User investor = new User();
				investor.setUser_name(rs.getString("borrower_name"));
				investor.setInv_name(rs.getString("inv_user_name"));
				investor.setLocation(rs.getString("inv_location"));
				investor.setAmount_invested(rs.getInt("amount_invested"));
				investor.setAmount_repaid(rs.getInt("amount_repaid"));
				userList.add(investor);
			}
			investorList.setUsers(userList);
		}
		return investorList;
	}
}
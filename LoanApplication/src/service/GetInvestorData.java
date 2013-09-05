package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionManager;
import dto.User;
import dto.UserList;

public class GetInvestorData {

	public UserList getBorrowerList(String id) throws SQLException {
		ConnectionManager conManger = new ConnectionManager();
		Connection con = conManger.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		String sql = "select  MSU.ID as investor_user_id,"
				+ "MSU.auth as auth,"
				+ "MSI.inv_ID as investor_inv_id,"
				+ "MSU.user_name as investor_name, "
				+ "MSB.brw_ID as borrower_brw_id,"
				+ "MSB.first_name as brw_first_name,"
				+ "MSB.middle_name as brw_middle_name,"
				+ "MSB.family_name as brw_family_name,"
				+ "MSB.location as borrower_location,"
				+ "MSB.req_amount as req_amount,"
				+ "TRI.amount_invested,"
				+ "TRI.date_invested "
				+ "from "
				+ "MS_USER MSU,"
				+ "MS_INVERSTER MSI,"
				+ "TR_INVEST TRI,"
				+ "(select * from MS_USER sMSU, MS_BORROWER sMSB where sMSU.ID = sMSB.user_ID) MSB "
				+ "where " + "MSU.ID = MSI.user_ID "
				+ "and MSI.inv_ID = TRI.inv_ID "
				+ "and MSB.brw_ID = TRI.brw_ID " + "and MSU.ID = '" + id + "'";

		stmt = con.prepareStatement(sql);

		rs = stmt.executeQuery();
		UserList investorList = new UserList();
		List userList = new ArrayList();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		while (rs.next()) {
			User usr = new User();
			usr.setId(rs.getString("investor_user_id"));
			usr.setAuth(rs.getString("auth"));
			usr.setInv_id(rs.getString("investor_inv_id"));
			usr.setUser_name(rs.getString("investor_name"));
			usr.setFirst_name(rs.getString("brw_first_name"));
			usr.setMiddle_name(rs.getString("brw_middle_name"));
			usr.setFamily_name(rs.getString("brw_family_name"));
			usr.setLocation(rs.getString("borrower_location"));
			usr.setReq_amount(rs.getInt("req_amount"));
			usr.setInv_amount(rs.getInt("amount_invested"));
			usr.setDate_invested(dateFormatter.format(rs
					.getTimestamp("date_invested")));
			userList.add(usr);

		}
		investorList.setUsers(userList);
		return investorList;

	}

	public UserList updateMoney(String lendingAmountUi) throws SQLException {
		ConnectionManager conManger = new ConnectionManager();
		Connection con = conManger.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		String updatesql = "";
		stmt = con.prepareStatement(updatesql);
		rs = stmt.executeQuery();
		
		String getsql = "";
		stmt = con.prepareStatement(getsql);
		rs = stmt.executeQuery();
		
		

		UserList borrowerList = new UserList();
		List userList = new ArrayList();
		while (rs.next()) {
			User usr = new User();
			usr.setFirst_name(rs.getString("brw_first_name"));
			usr.setMiddle_name(rs.getString("brw_middle_name"));
			usr.setFamily_name(rs.getString("brw_family_name"));
			usr.setLocation(rs.getString("borrower_location"));
			usr.setAmount_invested(rs.getInt("amount_invested"));
			usr.setAmount_repaid(rs.getInt("amount_repaid"));
			usr.setInvest_date(rs.getDate("date_invested"));
			usr.setRepaid_date(rs.getDate("date_repayed"));
			userList.add(usr);

		}
		borrowerList.setUsers(userList);
		return borrowerList;
	}

}

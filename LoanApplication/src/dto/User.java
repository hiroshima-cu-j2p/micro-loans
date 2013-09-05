package dto;

import java.util.Date;

/**
 * 
 * @author shogo.sugahara
 * @date 2013/8/29 Description:
 */

public class User {
	private String id = "";
	private int inv_amount = 0;
	private String user_name = "";
	private String first_name = "";
	private String middle_name = "";
	private String family_name = "";
	private String pwd = "";
	private String location = "";
	private String inv_id = "";
	private String brw_id = "";
	private String adm_id = "";
	private String auth = "";
	private String date_invested = "";
	private String date_repayed = "";
	private int amount_invested = 0;
	private int amount_repaid = 0;
	private int req_amount = 0;
	private String inv_name = "";
	private Date invest_date;
	private Date repaid_date;
	
	
	
	public Date getInvest_date() {
		return invest_date;
	}

	public void setInvest_date(Date invest_date) {
		this.invest_date = invest_date;
	}

	public Date getRepaid_date() {
		return repaid_date;
	}

	public void setRepaid_date(Date repaid_date) {
		this.repaid_date = repaid_date;
	}

	public String getInv_name() {
		return inv_name;
	}

	public void setInv_name(String inv_name) {
		this.inv_name = inv_name;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	

	/*
	 * Get the "req_amount"
	 */
	public int getReq_amount() {
		return req_amount;
	}

	/*
	 * @param "req_amount"
	 */
	public void setReq_amount(int req_amount) {
		this.req_amount = req_amount;
	}
	/*
	 * Get the "family_name"
	 */
	public String getFamily_name() {
		return family_name;
	}
	/*
	 * @param "Family_name"
	 */
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	/*
	 * Get the "Pwd"
	 */
	public String getPwd() {
		return pwd;
	}
	/*
	 * @param "pwd"
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/*
	 * Get the "location"
	 */
	public String getLocation() {
		return location;
	}
	/*
	 * @param "location"
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/*
	 * Get the "inv_id"
	 */
	public String getInv_id() {
		return inv_id;
	}
	/*
	 * @param "inv_id"
	 */
	public void setInv_id(String inv_id) {
		this.inv_id = inv_id;
	}
	/*
	 * Get the "brw_id"
	 */
	public String getBrw_id() {
		return brw_id;
	}
	/*
	 * @param "brw_id"
	 */
	public void setBrw_id(String brw_id) {
		this.brw_id = brw_id;
	}

	/*
	 * Get the "adm_id"
	 */
	public String getAdm_id() {
		return adm_id;
	}
	/*
     * @param "adm_id"
     */
	public void setAdm_id(String adm_id) {
		this.adm_id = adm_id;
	}

	/*
	 * Get the "amount_invested"
	 */
	public int getAmount_invested() {
		return amount_invested;
	}

	/*
	 * @param "amount_invested"
	 */
	public void setAmount_invested(int amount_invested) {
		this.amount_invested = amount_invested;
	}

	/*
	 * Get the "amount_repaid"
	 */
	public int getAmount_repaid() {
		return amount_repaid;
	}

	/*
	 * @param "amount_repaid"
	 */
	public void setAmount_repaid(int amount_repaid) {
		this.amount_repaid = amount_repaid;
	}

	/*
	 * Get the "middle_name"
	 */
	public String getMiddle_name() {
		return middle_name;
	}
	
	/*
	 * @param "middle_name"
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	/*
	 * Get the "first_name"
	 */
	public String getFirst_name() {
		return first_name;
	}

	/*
	 * @param "first_name"
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/*
	 * Get the "user_name" 
	 */
	public String getUser_name() {
		return user_name;
	}

	/*
	 * @param "user_name"
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	/*
	 * Get the "id"
	 */
	public String getId() {
		return id;
	}

	/*
	 * @param the "id"
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * Get the "inv_amount"
	 */
	public int getInv_amount() {
		return inv_amount;
	}

	/*
	 * @param "inv_amount"
	 */
	public void setInv_amount(int inv_amount) {
		this.inv_amount = inv_amount;
	}

	public String getDate_invested() {
		return date_invested;
	}

	public void setDate_invested(String date_invested) {
		this.date_invested = date_invested;
	}

	public String getDate_repayed() {
		return date_repayed;
	}

	public void setDate_repayed(String date_repayed) {
		this.date_repayed = date_repayed;
	}
}
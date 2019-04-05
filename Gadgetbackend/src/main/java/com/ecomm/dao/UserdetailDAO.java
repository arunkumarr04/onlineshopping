package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Userdetail;


public interface UserdetailDAO 
{


	public boolean addUserdetail(Userdetail userdetail);
	public boolean updateUserdetail(Userdetail userdetail);
	public Userdetail getUserdetail(String userName);
	//public boolean registerUser(Userdetail user);
}


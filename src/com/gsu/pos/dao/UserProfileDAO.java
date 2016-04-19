package com.gsu.pos.dao;

import java.util.ArrayList;

import com.gsu.pos.bean.ProfileBean;

public interface UserProfileDAO {
	String createUserProfileDAO(ProfileBean profileBean);
	int deleteUserProfileDAO(ArrayList<String> str);
	boolean updateUserProfileDAO(ProfileBean profileBean);
	ProfileBean findByID(String str);
	ArrayList<ProfileBean> findAll();
}

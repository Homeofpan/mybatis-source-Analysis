package com.pan.dao;

import com.pan.pojo.Country;

public interface ICountryDao {
	Country selectCountryById(int cid);
	
}

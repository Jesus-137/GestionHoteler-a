package com.jesus.authorization.service;

public interface AuthService {
	
	String authenticate(String username, String password) throws Exception;

}

package projectwork.service;

import java.util.List;

import projectwork.model.Admin;

public interface AdminService {
	List<Admin> findAll();
	Admin findByUsername(String username);
	
}
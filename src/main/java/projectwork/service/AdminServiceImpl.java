package projectwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import projectwork.dao.AdminDao;
import projectwork.model.Admin;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public List<Admin> findAll() {
		return (List<Admin>) adminDao.findAll();
	}

	@Override
	public Admin findByUsername(String username) {
		return adminDao.findByUsername(username);
	}

}
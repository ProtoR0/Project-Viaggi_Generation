package projectwork.dao;

import org.springframework.data.repository.CrudRepository;

import projectwork.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer>{
	Admin findByUsername(String username);
}

package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

	Admin findByLoginAndPassword(String login, String password);

}

package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.models.RH;

public interface RHRepo extends JpaRepository<RH, Long> {

	RH findByLoginAndPassword(String login, String password);

}

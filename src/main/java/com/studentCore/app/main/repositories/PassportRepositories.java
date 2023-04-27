package com.studentCore.app.main.repositories;

import com.studentCore.app.main.Entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepositories extends JpaRepository<Passport, Long> {
}

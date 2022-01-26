package com.n11.application.infrastructure.acl.repository;

import com.n11.application.infrastructure.acl.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}

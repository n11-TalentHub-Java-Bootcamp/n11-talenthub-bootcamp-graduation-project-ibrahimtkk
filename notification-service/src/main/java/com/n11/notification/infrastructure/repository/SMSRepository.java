package com.n11.notification.infrastructure.repository;

import com.n11.notification.infrastructure.entity.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSRepository extends JpaRepository<Sms, String> {
}

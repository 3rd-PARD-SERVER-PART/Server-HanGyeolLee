package com.pard.hw4.user.repo;

import com.pard.hw4.user.entity.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLoanRepo  extends JpaRepository<UserLoanHistory, Long> {

//      List<UserLoanHistory> findByUserId(Long userId);
      List<UserLoanHistory> findByUserUserId(Long userId);
}


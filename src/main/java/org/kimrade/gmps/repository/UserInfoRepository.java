package org.kimrade.gmps.repository;

import org.kimrade.gmps.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
	

}
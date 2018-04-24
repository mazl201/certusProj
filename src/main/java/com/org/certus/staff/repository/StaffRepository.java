package com.org.certus.staff.repository;

import com.org.certus.entity.user.CertusUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<CertusUser,Long> {
    public CertusUser findCertusUserByUserJobNumber(String jobNumber);
}

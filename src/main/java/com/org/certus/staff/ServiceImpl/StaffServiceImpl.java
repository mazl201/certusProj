package com.org.certus.staff.ServiceImpl;

import com.org.certus.entity.user.CertusUser;
import com.org.certus.staff.repository.StaffRepository;
import com.org.certus.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        CertusUser certusUser = staffRepository.findCertusUserByUserJobNumber(s);
        if (certusUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return certusUser;
    }
}

package com.exam.service;

import com.exam.dto.MemberDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface AuthenticationService {

    MemberDTO authenticate(Map<String, String> map);
}
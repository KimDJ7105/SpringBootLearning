package com.exam.service;

import com.exam.dto.MemberDTO;
import com.exam.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface MemberService {

    @Transactional
    int signup(MemberDTO member);
}
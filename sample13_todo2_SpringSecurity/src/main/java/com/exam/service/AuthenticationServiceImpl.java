package com.exam.service;

import com.exam.dto.MemberDTO;
import com.exam.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("AuthenticationService")
//getBean을 사용하지 않기 때문에 별명은 필요없다.
public class AuthenticationServiceImpl implements AuthenticationService {

    MemberMapper memberMapper;

    public AuthenticationServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

//    @Override
//    public MemberDTO authenticate(Map<String, String> map) {
//        return memberMapper.authenticate(map);
//    }

    @Override
    public MemberDTO findById(String id) {
        return memberMapper.findById(id);
    }
}
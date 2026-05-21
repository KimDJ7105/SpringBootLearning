package com.exam.service;

import com.exam.dto.MemberDTO;
import com.exam.mapper.MemberMapper;
import com.exam.mapper.TodoMapper;
import com.exam.dto.TodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("MemberService")
//getBean을 사용하지 않기 때문에 별명은 필요없다.
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    @Override
    @Transactional
    public int signup(MemberDTO member) {
        return memberMapper.signup(member);
    }

}
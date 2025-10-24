package kr.ai.kjun.api.member.service;

import kr.ai.kjun.api.member.domain.MemberDto;

public interface MemberService {
    public void save(MemberDto memberDto);
    public void update(MemberDto memberDto);
    public void delete(MemberDto memberDto);
    public void findByID(MemberDto memberDto);
    public void findAll(MemberDto memberDto);
}

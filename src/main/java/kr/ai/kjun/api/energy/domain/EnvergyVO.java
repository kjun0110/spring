package kr.ai.kjun.api.energy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnvergyVO {
    
    private String corporateName;
    private String supervisingAuthority;
    private String designationType;
    private String industry;
    private String ghge;
    private String energy;
    private String verification;
}

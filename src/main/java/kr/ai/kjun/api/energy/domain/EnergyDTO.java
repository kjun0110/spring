package kr.ai.kjun.api.energy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyDTO {

    private String corporateName;
    private String supervisingAuthority;
    private String designationType;
    private String industry;
    private String ghge;
    private String energy;
    private String verification;

}

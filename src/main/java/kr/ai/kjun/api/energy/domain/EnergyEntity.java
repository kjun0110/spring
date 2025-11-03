package kr.ai.kjun.api.energy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; 

@Data
@Entity
@Table(name = "energys")
public class EnergyEntity {

    @Id
    private Long id;
    private String corporateName;
    private String supervisingAuthority;
    private String designationType;
    private String industry;
    private String ghge;
    private String energy;
    private String verification;
}

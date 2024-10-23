package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "LANDING_TYPE")
@Table(name = "CREATIVE_LANDING_INFO")
public abstract class AbstractLandingInfo extends DomainBase<Long> {
    @OneToOne
    private AbstractCreative creative;
}

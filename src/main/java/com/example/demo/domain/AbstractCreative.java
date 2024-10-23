package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "creative")
public abstract class AbstractCreative extends DomainBase<Long> {
    @Column(nullable = false, length = 50)
    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private AbstractCreative copySourceCreative;

    @ManyToOne(optional = false)
    private AdGroup adGroup;
}

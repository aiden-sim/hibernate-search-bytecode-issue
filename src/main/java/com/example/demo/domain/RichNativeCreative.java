package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("RICH_NATIVE")
public class RichNativeCreative extends AbstractCreative {

    @OneToOne(mappedBy = "creative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private AbstractLandingInfo landingInfo;
}

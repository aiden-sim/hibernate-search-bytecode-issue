package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "AD_GROUP")
public class AdGroup extends DomainBase<Long> {

    @OneToMany(mappedBy = "adGroup")
    private List<AbstractCreative> creatives = new ArrayList<>();

    private String status;

    @JsonIgnore
    public long getCreativesCount() {
        return this.creatives.stream().count();
    }
}

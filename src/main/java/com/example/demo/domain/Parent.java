package com.example.demo.domain;

import com.example.demo.service.ParentDetailService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "sample")
@Configurable
@Indexed
public abstract class Parent extends DomainBase<Long> {
    @Column(nullable = false, length = 50)
    @NotNull
    @GenericField(projectable = Projectable.YES, sortable = Sortable.YES, searchable = Searchable.YES)
    private String name;

    @Transient
    @JsonIgnore
    @Autowired
    @Expose(serialize = false, deserialize = false)
    protected transient ParentDetailService parentDetailService;

    public ParentDetail getParentDetails() {
        return parentDetailService.getParentDetail(getId());
    }

}

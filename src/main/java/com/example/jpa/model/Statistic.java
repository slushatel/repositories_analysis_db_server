package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "statistic")
@IdClass(StatisticPK.class)
@Data
public class Statistic {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "metric_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
    @JsonIdentityReference(alwaysAsId=true)
    @Id
    private Metric metric;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repository_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
    @JsonIdentityReference(alwaysAsId=true)
    @Id
    private CodeRepository repository;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technology_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
    @JsonIdentityReference(alwaysAsId=true)
    @Id
    private Technology technology;

    @NotNull
    @Column(name = "report_date")
    @Id
    private Date reportDate;

    @NotNull
    @Column(precision=33, scale=8)
    private BigDecimal value;
}

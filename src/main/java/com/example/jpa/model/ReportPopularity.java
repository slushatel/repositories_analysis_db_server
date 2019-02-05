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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "popularity")
@IdClass(ReportPopularityPK.class)
@Data
public class ReportPopularity {
    @Id
    private String metric;

    @Id
    private String repository;

    @Id
    private String technology;

    @Column(name = "report_date")
    @Id
    private Date reportDate;

    @Column(precision=33, scale=8)
    private BigDecimal value;
}

@Data
class ReportPopularityPK implements Serializable {
    private String metric;
    private String repository;
    private String technology;
    private Date reportDate;
}

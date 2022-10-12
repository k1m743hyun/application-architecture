package com.k1m743hyun.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaAuditing
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
public class Demo {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}

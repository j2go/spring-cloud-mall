package cn.j2go.mall.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime;

    @LastModifiedBy
    protected String editor;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;

}

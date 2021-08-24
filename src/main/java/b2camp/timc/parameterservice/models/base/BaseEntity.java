package b2camp.timc.parameterservice.models.base;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_on", columnDefinition = "DATE")
    @CreatedDate
    private Timestamp createdOn;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name="is_deleted")
    private Boolean deleted;

    @Column(name = "last_modified_on", columnDefinition = "DATE")
    @LastModifiedDate
    private Timestamp lastModifiedOn;
    @PrePersist
    public void prePersist(){
        this.createdBy = getCreatedBy()!=null?getCreatedBy():"SYSTEM";
        this.lastModifiedBy = getLastModifiedBy()!=null?getLastModifiedBy():"SYSTEM";
    }
    @PreUpdate
    public void preModified(){
        this.lastModifiedBy = "SYSTEM MODIFIED";
    }
}

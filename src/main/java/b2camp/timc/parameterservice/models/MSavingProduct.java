package b2camp.timc.parameterservice.models;

import b2camp.timc.parameterservice.models.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="m_saving_account")
@SuperBuilder
public class MSavingProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false,length = 50)
    private Long id;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "description",nullable = false)
    private String description;
}

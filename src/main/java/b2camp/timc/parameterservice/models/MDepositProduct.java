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
@Table(name="m_deposit_product")
@SuperBuilder
public class MDepositProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false,length = 50)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name= "interest_rate", nullable = false)
    private Double interestRate;

    @Column(name = "code", nullable = false)
    private String code;
}

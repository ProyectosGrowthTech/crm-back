package org.crm.crmback.domain.model.stakeholders;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stakeholders")
public class Stakeholder implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Size(max = 255)
  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @Size(max = 20)
  @NotNull
  @Column(name = "type", nullable = false, length = 20)
  private String type;

  @Size(max = 255)
  @Column(name = "identification_code")
  private String identificationCode;

  @Size(max = 255)
  @NotNull
  @Column(name = "email", nullable = false)
  private String email;

  @Size(max = 20)
  @Column(name = "phone", length = 20)
  private String phone;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "business_address_id")
  private Address businessAddress;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tax_address_id")
  private Address taxAddress;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "stakeholder_type_id", nullable = false)
  private StakeholderType stakeholderType;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @OneToMany(mappedBy = "stakeholder")
  private Set<InvoicesStakeholder> invoicesStakeholders = new LinkedHashSet<>();
}

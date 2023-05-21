package org.crm.crmback.infrastructure.addresses;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;
import org.crm.crmback.infrastructure.stakeholders.StakeholderEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Size(max = 255)
  @NotNull
  @Column(name = "street", nullable = false)
  private String street;

  @Size(max = 255)
  @NotNull
  @Column(name = "city", nullable = false)
  private String city;

  @Size(max = 255)
  @NotNull
  @Column(name = "postal_code", nullable = false)
  private String postalCode;

  @Size(max = 255)
  @NotNull
  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @OneToMany(mappedBy = "businessAddress")
  private Set<StakeholderEntity> stakeholdersBussinessAddress = new LinkedHashSet<>();

  @OneToMany(mappedBy = "taxAddress")
  private Set<StakeholderEntity> stakeholdersTaxAddress = new LinkedHashSet<>();
}

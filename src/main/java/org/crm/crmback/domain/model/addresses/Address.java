package org.crm.crmback.domain.model.addresses;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

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
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @OneToMany(mappedBy = "businessAddress")
  private Set<Stakeholder> stakeholdersBusinessAddress = new LinkedHashSet<>();

  @OneToMany(mappedBy = "taxAddress")
  private Set<Stakeholder> stakeholdersTaxAddress = new LinkedHashSet<>();
}

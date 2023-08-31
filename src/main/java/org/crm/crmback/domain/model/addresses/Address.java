package org.crm.crmback.domain.model.addresses;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;
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
  @Column(name = "address_line", nullable = false)
  private String addressLine;

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

  @Size(max = 255)
  @NotNull
  @Column(name = "address_name", nullable = false)
  private String addressName;

  @Size(max = 255)
  @NotNull
  @Column(name = "state", nullable = false)
  private String state;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;
}

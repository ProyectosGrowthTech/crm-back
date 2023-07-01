package org.crm.crmback.domain.model.services;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
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
@Table(name = "service_types")
public class ServiceType implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Size(max = 255)
  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @Size(max = 255)
  @Column(name = "description")
  private String description;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @OneToMany(mappedBy = "serviceType")
  private Set<Service> services = new LinkedHashSet<>();
}

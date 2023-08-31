package org.crm.crmback.domain.model.stakeholders;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stakeholder_types")
public class StakeholderType implements Serializable {

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

  @ManyToOne
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @OneToMany(mappedBy = "stakeholderType")
  @JsonBackReference
  private Set<Stakeholder> stakeholders = new LinkedHashSet<>();
}

package dev.igraciarena.domain.entities;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.CascadeType.MERGE;
import static org.hibernate.annotations.CascadeType.PERSIST;
import static org.hibernate.annotations.CascadeType.REMOVE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

/**
 * @author ivan.graciarena
 * @project igraciarena-backend
 */
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  UUID id;

  BigDecimal totalPrice;
  BigDecimal deliveryCost;
  String status;

  @ManyToOne
  @Cascade(MERGE)
  @JoinColumn(name = "client_id", nullable = false)
  AddressEntity address;

  @OneToMany(fetch = LAZY, targetEntity = OrderItemEntity.class)
  @Cascade({REMOVE, MERGE, PERSIST})
  @JoinColumn(name = "order_id", nullable = false)
  List<OrderItemEntity> items;

  LocalDate createdDate;
  LocalDate modifiedDate;
  boolean isDeleted;
  @Builder.Default boolean isActive = true;
}

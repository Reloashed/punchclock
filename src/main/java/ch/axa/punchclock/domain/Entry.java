package ch.axa.punchclock.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "check_in", nullable = false)
  private LocalDateTime checkIn;

  @Column(name = "check_out", nullable = false)
  private LocalDateTime checkOut;

  private String description;

  @Column(name = "fk_category_id")
  private long fkCategoryId;
}
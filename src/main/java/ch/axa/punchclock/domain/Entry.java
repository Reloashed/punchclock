package ch.axa.punchclock.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "check_in", nullable = false)
  private LocalDateTime checkIn;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "check_out", nullable = false)
  private LocalDateTime checkOut;

  private String description;

  @Column(name = "fk_category_id")
  private long fkCategoryId;
}
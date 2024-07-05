package ch.axa.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Entry {
  @Id
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "check_in", nullable = false)
  @NotNull(message = "Check In Time must not be NULL")
  private LocalDateTime checkIn;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "check_out", nullable = false)
  @NotNull(message = "Check Out Time must not be NULL")
  private LocalDateTime checkOut;

  @Column(nullable = false)
  @NotBlank(message = "Description must not be empty!")
  private String description;

  @ManyToOne
  private Category category;

  @ManyToMany(mappedBy = "entries")
  private Set<Tag> tags = new HashSet<>();

  @JsonIgnore
  @AssertTrue(message = "The check out date must be after the check in date!")
  public boolean isCheckOutAfterCheckIn() {
    if (checkIn == null || checkOut == null) {
      return true;
    }
    return checkIn.isBefore(checkOut);
  }
}
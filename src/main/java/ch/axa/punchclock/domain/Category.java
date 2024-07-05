package ch.axa.punchclock.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull(message = "The name must not be NULL!")
  private String name;

  @OneToMany(mappedBy = "category")
  private Set<Entry> entries = new HashSet<>();
}

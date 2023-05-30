package acustic.notes.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Notes {

    // 2 next annotations are for incrementing id by 1 and not by 50 (default)
    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_SEQ")
    @Id
    private Long id;


    @Column(columnDefinition = "TEXT")
    private String text;
}

package acustic.notes.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NoteDTO {

    private Long id;

    private String text;

    private String title;
}

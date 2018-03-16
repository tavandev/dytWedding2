package me.wedding.dytwedding.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EngagementSession {

    private LocalDateTime sessionDate;

    private String sessionLocation;

}

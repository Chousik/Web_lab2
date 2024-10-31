package org.chousik.weblab2.models;

import lombok.*;

@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public final class Point {
    private final double x;
    private final double y;
    private final double r;
    private boolean inFlag;
    private String time; //В точке время строка.
    private long executionTime;
}

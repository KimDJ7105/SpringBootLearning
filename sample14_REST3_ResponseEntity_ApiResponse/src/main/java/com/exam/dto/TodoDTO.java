package com.exam.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("TodoDTO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {
    int id;
    String name;
    String job;
}

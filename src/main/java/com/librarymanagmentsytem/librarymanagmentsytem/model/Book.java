package com.librarymanagmentsytem.librarymanagmentsytem.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  @ApiModelProperty(notes ="notes go here", example = "sdfs32423423423", required = true)
  private String id;
  @ApiModelProperty(notes ="notes go here", example = "Design Patterns", required = true)
  private String name;
  @ApiModelProperty(notes ="notes go here", example = "Author Name", required = true)
  private String author;
}

package com.te.pcm.pcmdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductDto {
private int productId;
private String ProductTitle;
}

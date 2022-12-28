package com.te.pcm.pcmDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VariationTypesDto {
private int variationTypeId;
private String variationTypeTitle;
private int categoryId;
}

package com.te.pcm.pcmdto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductVariationOptionsDto {
private int productvariationOptionId;
private int productvariationId;
private int optionId;
}

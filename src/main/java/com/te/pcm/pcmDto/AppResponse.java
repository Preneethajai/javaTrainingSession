package com.te.pcm.pcmdto;



import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class AppResponse {
private String message;
private String satus;
private Object data;

}

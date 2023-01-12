package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDTO {
    private int payment_code;
    private String payment_type;
    private int payment_uid;
}

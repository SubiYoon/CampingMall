package com.camp.camping.DTO;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
	
	private String imp_uid;
	private String merchant_uid;
	

=======
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
>>>>>>> a7783e95bd5427b35a647b8c979cce0094b6f3e4
}

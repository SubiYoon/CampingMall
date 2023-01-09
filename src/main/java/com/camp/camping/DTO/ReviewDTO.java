package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {
    private int review_code;
    private int site_code;
    private int user_code;
    private String review_content;
    private int review_score;
    private String review_img1;
}

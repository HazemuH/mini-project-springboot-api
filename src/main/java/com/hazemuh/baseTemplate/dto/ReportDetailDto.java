package com.hazemuh.baseTemplate.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class ReportDetailDto {
    public String transactionId;
    public String Date;
    public String type;
    public String description;
    public Long amount;

}

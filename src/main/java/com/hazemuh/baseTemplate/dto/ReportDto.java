package com.hazemuh.baseTemplate.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class ReportDto {
    public String nama;
    public String usersId;
    public String Periode;
    public List<ReportDetailDto> reportDetailDtos;
    public Long total;

}

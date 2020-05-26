package com.example.business.vo;

import com.example.business.entity.Datasets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class DatasetsVo extends Datasets {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids;//接收多个ID

    private String projectName;

    public DatasetsVo (Datasets datasets){
        setId(datasets.getId());
        setName(datasets.getName());
        setPath(datasets.getPath());
        setTypeid(datasets.getTypeid());
    }

}

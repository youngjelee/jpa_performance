package com.allmytour.ai.app.mock.v1.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchCriteria {

    List<Long> ids = new ArrayList<>();

    List<String> names = new ArrayList<>();

}

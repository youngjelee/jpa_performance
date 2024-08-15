package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.JoinData;

import java.util.List;

public interface NoForCustom {

    List<JoinData> getJoinData(Long limit , String name );
}

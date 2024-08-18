package com.allmytour.ai.app.mock.repository.custom;

import com.allmytour.ai.app.mock.dto.PostResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepositoryCustom  {

    List<PostResponseDto> getListPostResponseDto(Long userId , Pageable pageable);

    Long getListPostResponseDtoLongCount(Long userId , Pageable pageable) ;
}

package com.HoloClip.Collector.mapper;

import com.HoloClip.Collector.model.YoutubeShort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YoutubeShortMapper {
    List<YoutubeShort> findShortsByCriteria(@Param("search") String search, @Param("channelId") String channelId);
}
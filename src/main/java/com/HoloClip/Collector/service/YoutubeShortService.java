package com.HoloClip.Collector.service;

import com.HoloClip.Collector.mapper.YoutubeShortMapper;
import com.HoloClip.Collector.model.YoutubeShort;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YoutubeShortService {

    private final YoutubeShortMapper youtubeShortMapper;

    @Autowired
    public YoutubeShortService(YoutubeShortMapper youtubeShortMapper) {
        this.youtubeShortMapper = youtubeShortMapper;
    }

    /**
     * Retrieves a paginated list of YouTube shorts based on search criteria.
     *
     * For optimal performance, it is recommended to have a composite index on the `youtube_shorts` table
     * on the columns (channel_id, published_at). This will significantly speed up filtering and sorting.
     *
     * @param search    A search term to filter shorts by title (optional).
     * @param channelId The ID of the channel to retrieve shorts from (optional).
     * @param page      The page number (0-based).
     * @param size      The number of items per page.
     * @return A {@link Page} of {@link YoutubeShort} objects.
     */
    public Page<YoutubeShort> getShorts(String search, String channelId, int page, int size) {
        // PageHelper counts pages from 1, but our frontend sends 0-based page index.
        // We also explicitly pass the sorting order to PageHelper.
        PageHelper.startPage(page + 1, size, "published_at DESC");
        return (Page<YoutubeShort>) youtubeShortMapper.findShortsByCriteria(search, channelId);
    }
}
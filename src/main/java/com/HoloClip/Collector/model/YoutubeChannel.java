package com.HoloClip.Collector.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class YoutubeChannel {

    private String channelId;
    private String channelName;
    private Long subscriberCount;
    private Long videoCount;
    private String thumbnailUrl;
    private Boolean isVerified;
    private String videosPlaylistId;
    private String shortsPlaylistId;
    private OffsetDateTime lastUpdated;
    private OffsetDateTime createdAt;

    public YoutubeChannel() {
    }

    public YoutubeChannel(String channelId, String channelName, Long subscriberCount, Long videoCount, String thumbnailUrl, Boolean isVerified, String videosPlaylistId, String shortsPlaylistId, OffsetDateTime lastUpdated, OffsetDateTime createdAt) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.subscriberCount = subscriberCount;
        this.videoCount = videoCount;
        this.thumbnailUrl = thumbnailUrl;
        this.isVerified = isVerified;
        this.videosPlaylistId = videosPlaylistId;
        this.shortsPlaylistId = shortsPlaylistId;
        this.lastUpdated = lastUpdated;
        this.createdAt = createdAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(Long subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    public Long getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Long videoCount) {
        this.videoCount = videoCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getVideosPlaylistId() {
        return videosPlaylistId;
    }

    public void setVideosPlaylistId(String videosPlaylistId) {
        this.videosPlaylistId = videosPlaylistId;
    }

    public String getShortsPlaylistId() {
        return shortsPlaylistId;
    }

    public void setShortsPlaylistId(String shortsPlaylistId) {
        this.shortsPlaylistId = shortsPlaylistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YoutubeChannel that = (YoutubeChannel) o;
        return Objects.equals(channelId, that.channelId) &&
                Objects.equals(channelName, that.channelName) &&
                Objects.equals(subscriberCount, that.subscriberCount) &&
                Objects.equals(videoCount, that.videoCount) &&
                Objects.equals(thumbnailUrl, that.thumbnailUrl) &&
                Objects.equals(isVerified, that.isVerified) &&
                Objects.equals(videosPlaylistId, that.videosPlaylistId) &&
                Objects.equals(shortsPlaylistId, that.shortsPlaylistId) &&
                Objects.equals(lastUpdated, that.lastUpdated) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, channelName, subscriberCount, videoCount, thumbnailUrl, isVerified, videosPlaylistId, shortsPlaylistId, lastUpdated, createdAt);
    }

    @Override
    public String toString() {
        return "YoutubeChannel{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", subscriberCount=" + subscriberCount +
                ", videoCount=" + videoCount +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", isVerified=" + isVerified +
                ", videosPlaylistId='" + videosPlaylistId + '\'' +
                ", shortsPlaylistId='" + shortsPlaylistId + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", createdAt=" + createdAt +
                '}';
    }
}

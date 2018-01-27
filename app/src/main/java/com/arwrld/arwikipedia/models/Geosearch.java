package com.arwrld.arwikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geosearch {
    @SerializedName("dist")
    @Expose
    private Double dist;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     *
     * @return
     * The dist
     */
    public Double getDist() {
        return dist;
    }

    /**
     *
     * @param dist
     * The dist
     */
    public void setDist(Double dist) {
        this.dist = dist;
    }

    /**
     *
     * @return
     * The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     * The ns
     */
    public Integer getNs() {
        return ns;
    }

    /**
     *
     * @param ns
     * The ns
     */
    public void setNs(Integer ns) {
        this.ns = ns;
    }

    /**
     *
     * @return
     * The pageid
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     *
     * @param pageid
     * The pageid
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    /**
     *
     * @return
     * The primary
     */
    public String getPrimary() {
        return primary;
    }

    /**
     *
     * @param primary
     * The primary
     */
    public void setPrimary(String primary) {
        this.primary = primary;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}

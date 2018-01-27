package com.arwrld.arwikipedia.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Query {
    @SerializedName("geosearch")
    @Expose
    private List<Geosearch> geosearch = new ArrayList<>();

    /**
     *
     * @return
     * The geosearch
     */
    public List<Geosearch> getGeosearch() {
        return geosearch;
    }

    /**
     *
     * @param geosearch
     * The geosearch
     */
    public void setGeosearch(List<Geosearch> geosearch) {
        this.geosearch = geosearch;
    }
}

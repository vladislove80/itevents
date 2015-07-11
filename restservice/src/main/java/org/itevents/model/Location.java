package org.itevents.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.NONE)
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private Double latitude;
    @XmlElement
    private Double longitude;

    public Location() {
    }

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event ");
        sb.append("latitude=").append(latitude);
        sb.append("longitude=").append(longitude);
        return sb.toString();
    }
}

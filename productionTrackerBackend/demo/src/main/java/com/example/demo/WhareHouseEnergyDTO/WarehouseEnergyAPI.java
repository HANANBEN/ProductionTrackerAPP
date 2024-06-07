package com.example.demo.WhareHouseEnergyDTO;
import java.util.Date;

public class WarehouseEnergyAPI
 {
    private Long wh_id;
    private String wh_code;
    private String wh_name;
    private Long energy;
    private Date year;

    
    public Long getWh_id() {
        return wh_id;
    }

    public void setWh_id(Long wh_id) {
        this.wh_id = wh_id;
    }

    public String getWh_code() {
        return wh_code;
    }

    public void setWh_code(String wh_code) {
        this.wh_code = wh_code;
    }

    public String getWh_name() {
        return wh_name;
    }

    public void setWh_name(String wh_name) {
        this.wh_name = wh_name;
    }

    public Long getEnergy() {
        return energy;
    }

    public void setEnergy(Long energy) {
        this.energy = energy;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}

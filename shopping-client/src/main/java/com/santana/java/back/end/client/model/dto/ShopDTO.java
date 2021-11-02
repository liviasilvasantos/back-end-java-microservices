package com.santana.java.back.end.client.model.dto;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ShopDTO {

    //@NotBlank
    private String userIdentifier;
    //@NotNull
    private Float total;
    //@NotNull
    private Date shopDate;
    //@NotNull
    private List<ItemDTO> items;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getShopDate() {
        return shopDate;
    }

    public void setShopDate(Date shopDate) {
        this.shopDate = shopDate;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

}

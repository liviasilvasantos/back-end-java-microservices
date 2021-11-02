package com.santana.java.back.end.shoppingapi.model;

import com.santana.java.back.end.client.model.dto.ShopDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userIdentifier;
    private float total;
    private Date shopDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item",joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getShopDate() {
        return shopDate;
    }

    public void setShopDate(Date shopDate) {
        this.shopDate = shopDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static Shop convert(ShopDTO shopDTO){
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
        shop.setShopDate(shopDTO.getShopDate());
        shop.setItems(shopDTO.getItems().stream().map(Item::convert).collect(Collectors.toList()));
        return shop;
    }
}

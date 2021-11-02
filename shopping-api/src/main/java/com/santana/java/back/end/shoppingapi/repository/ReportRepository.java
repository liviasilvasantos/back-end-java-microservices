package com.santana.java.back.end.shoppingapi.repository;

import com.santana.java.back.end.shoppingapi.dto.ShopReportDTO;
import com.santana.java.back.end.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}

package com.example.data.mappers

import com.example.data.models.CompanyModelItemData
import com.example.data.models.CompaniesListModelItemData
import com.example.domain.models.CompanyModelItem
import com.example.domain.models.CompanyListModelItem

fun CompanyModelItemData.toDomain(): CompanyModelItem {
    return CompanyModelItem(
        this.description,
        this.id,
        this.img,
        this.lat,
        this.lon,
        this.name,
        this.phone,
        this.www
    )
}

fun CompaniesListModelItemData.toDomain(): CompanyListModelItem {
    return CompanyListModelItem(this.id, this.img, this.name)
}

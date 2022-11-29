package com.example.data.mappers

import com.example.data.models.UserModelItem
import com.example.data.models.UsersListModelItem
import com.example.domain.models.UserModelItemDomain
import com.example.domain.models.UsersListModelItemDomain

fun UserModelItem.toDomain(): UserModelItemDomain {
    return UserModelItemDomain(
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

fun UsersListModelItem.toDomain(): UsersListModelItemDomain {
    return UsersListModelItemDomain(this.id, this.img, this.name)
}
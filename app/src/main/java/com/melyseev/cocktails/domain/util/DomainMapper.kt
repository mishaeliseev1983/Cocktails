package com.melyseev.cocktails.domain.util

interface DomainMapper <T, DomainModel>{
    fun mapToDomain(drinkShortDto: T): DomainModel
    fun mapFromDomain(domainModel: DomainModel): T
}
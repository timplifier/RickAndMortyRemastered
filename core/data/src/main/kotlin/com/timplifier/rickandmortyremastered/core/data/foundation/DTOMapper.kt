package com.timplifier.rickandmortyremastered.core.data.foundation

interface DTOMapper<T> {
    fun toDomain(): T
}
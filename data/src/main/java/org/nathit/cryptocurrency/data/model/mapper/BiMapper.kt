package org.nathit.cryptocurrency.data.model.mapper

interface BiMapper<E, D> {
    fun mapFromEntity(input: E): D
    fun mapToEntity(input: D): E
}
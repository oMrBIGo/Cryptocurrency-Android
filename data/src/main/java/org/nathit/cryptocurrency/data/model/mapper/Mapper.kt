package org.nathit.cryptocurrency.data.model.mapper

interface Mapper<E, D> {
    fun map(input: E): D
}
package com.max.secondworld.globaltestprojectwithcustomview.core.bases

interface Mapper<T, R> {

    fun map(data : T) : R
}
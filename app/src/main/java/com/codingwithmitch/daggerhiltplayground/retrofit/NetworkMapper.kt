package com.codingwithmitch.daggerhiltplayground.retrofit

import com.codingwithmitch.daggerhiltplayground.model.Blog
import com.codingwithmitch.daggerhiltplayground.room.BlogCacheEntity
import com.codingwithmitch.daggerhiltplayground.util.EntityMapper
import javax.inject.Inject

/**
 *      Class responsible for mapping the network objects to the domain objects
 */

class NetworkMapper
@Inject
constructor() : EntityMapper<BlogNetworkEntity, Blog> {
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    // Convert list of entity objects to list of blog objects
    fun mapFromEntityList(entities: List<BlogNetworkEntity>): List<Blog> {
        return entities.map { mapFromEntity(it) }
    }
}
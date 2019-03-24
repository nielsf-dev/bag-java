package org.bag.dto

class UpdaterProjectListItem(
        val id: Int,
        val title: String
){
    override fun toString(): String {
        return title;
    }
}
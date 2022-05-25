package com.kurovale.dao

import com.kurovale.models.User

interface UserDAOFacade {
    suspend fun storeUser(username: String, password: String): User?
    suspend fun editUser(id: Int, username: String): Boolean
    suspend fun deleteUser(id: Int): Boolean
}
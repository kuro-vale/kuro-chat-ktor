package com.kurovale.dao

import com.kurovale.dao.DatabaseFactory.dbQuery
import com.kurovale.models.User
import com.kurovale.models.Users
import org.jetbrains.exposed.sql.*

class UserDAOFacadeImpl : UserDAOFacade {
    private fun resultRowToUser(row: ResultRow) = User(
        id = row[Users.id],
        username = row[Users.username]
    )

    override suspend fun storeUser(username: String, password: String): User? = dbQuery {
        val insertStatement = Users.insert {
            it[Users.username] = username
            it[Users.password] = password
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToUser)
    }

    override suspend fun editUser(id: Int, username: String): Boolean = dbQuery {
        Users.update({ Users.id eq id }) {
            it[Users.username] = username
        } > 0
    }

    override suspend fun deleteUser(id: Int): Boolean = dbQuery {
        Users.deleteWhere { Users.id eq id } > 0
    }
}

val userDAO: UserDAOFacade = UserDAOFacadeImpl()
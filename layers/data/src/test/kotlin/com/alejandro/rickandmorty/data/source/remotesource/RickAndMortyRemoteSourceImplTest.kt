package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.data.api.RickAndMortyApi
import com.alejandro.rickandmorty.data.source.remotesource.mapper.RickAndMortyRemoteMapper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import retrofit2.HttpException
import retrofit2.Response

class RickAndMortyRemoteSourceImplTest {

    private val api: RickAndMortyApi = mockk()

    private val mapper: RickAndMortyRemoteMapper = mockk()
    private val remoteSource = RickAndMortyRemoteSourceImpl(api, mapper)

    @Test
    fun `returns an empty page when the api responds 404`() = runTest {
        coEvery { api.getCharacterList(1, "xyz") } throws httpError(404)

        val result = remoteSource.getCharacterList(1, "xyz")

        val page = result.getOrThrow()
        assertTrue(page.characters.isEmpty())
        assertFalse(page.hasNextPage)
    }

    @Test
    fun `returns a failure when the api responds with another error`() = runTest {
        coEvery { api.getCharacterList(1, null) } throws httpError(500)

        val result = remoteSource.getCharacterList(1, null)

        assertTrue(result.isFailure)
    }

    private fun httpError(code: Int) =
        HttpException(Response.error<Any>(code, "".toResponseBody(null)))
}
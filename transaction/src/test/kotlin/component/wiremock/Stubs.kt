package component.wiremock

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
import org.pismo.commons.dto.AccountResponse

object AccountStubs {

    fun stubAccountSuccess(accountId: Long = 1, documentNumber: String = "1234567890") =
        stubFor(get(urlMatching("/accounts/[0-9]+"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("""
                        { "account_id": $accountId, "document_number": "$documentNumber" }
                    """.trimIndent())))
        .let { AccountResponse(accountId, documentNumber) }
}
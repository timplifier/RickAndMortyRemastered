package com.timplifier.rickandmortyremastered.konsist.domain.assertions.architecture

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

internal class DomainLayerArchitectureTest {

    @Test
    internal fun `ensure that domain layer is independent`() {
        val coreDomain =
            Layer("Core Domain", "com.timplifier.rickandmortyremastered.core.domain..")
        Konsist.scopeFromProject()
            .assertArchitecture {
                listOf(
                    "com.timplifier.rickandmortyremastered.authentication.domain..",
                    "com.timplifier.rickandmortyremastered.main.domain.."
                ).forEach { definedBy ->
                    val domain = Layer(definedBy, definedBy)
                    domain.dependsOn(coreDomain)
                }
            }
    }
}
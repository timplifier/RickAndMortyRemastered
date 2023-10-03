package com.timplifier.rickandmortyremastered.konsist.data.assertions.architecture

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

internal class DataLayerArchitectureTest {

    @Test
    internal fun `ensure that data layer depends only on core and domain`() {
        val coreData = Layer("Core Data", "com.timplifier.rickandmortyremastered.core.data..")
        Konsist.scopeFromProject()
            .assertArchitecture {
                listOf(
                    "com.timplifier.rickandmortyremastered.authentication.data..",
                    "com.timplifier.rickandmortyremastered.main.data.."
                ).forEach { definedBy ->
                    val data = Layer(definedBy, definedBy)
                    val domain =
                        Layer(
                            definedBy.replace("data", "domain"),
                            definedBy.replace("data", "domain")
                        )
                    data.dependsOn(coreData)
                    data.dependsOn(domain)
                }
            }
    }
}
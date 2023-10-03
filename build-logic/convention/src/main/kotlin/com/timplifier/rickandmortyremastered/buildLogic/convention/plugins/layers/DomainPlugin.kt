package com.timplifier.rickandmortyremastered.buildLogic.convention.plugins.layers

import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.api
import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.implementation
import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.libs
import com.timplifier.rickandmortyremastered.buildLogic.convention.plugins.base.KotlinLibraryPlugin
import org.gradle.kotlin.dsl.dependencies

internal class DomainPlugin : KotlinLibraryPlugin({
    dependencies {
        if (path.split(":").first { it.isNotBlank() } != "core")
            api(project(":core:domain"))
        implementation(libs.bundles.kotlinx.core)
        implementation(libs.androidx.paging.common)
        implementation(libs.javax.inject)
    }
})
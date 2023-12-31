package com.timplifier.rickandmortyremastered.buildLogic.convention.plugins.layers

import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.extractPluginId
import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.implementation
import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.ksp
import com.timplifier.rickandmortyremastered.buildLogic.convention.extensions.libs
import com.timplifier.rickandmortyremastered.buildLogic.convention.plugins.base.AndroidLibraryPlugin
import org.gradle.kotlin.dsl.dependencies

internal class PresentationPlugin : AndroidLibraryPlugin({

    pluginManager.apply {
        apply(libs.plugins.kotlin.serialization.extractPluginId())
        apply(libs.plugins.google.devtools.ksp.extractPluginId())
    }

    dependencies {
        if (path.split(":").first { it.isNotBlank() } != "core")
            implementation(project(":core:presentation"))
        implementation(project(path.replace(":presentation", ":domain")))
        implementation(libs.bundles.androidx.compose)
        implementation(libs.bundles.kotlinx.android)
        implementation(libs.google.dagger)
        ksp(libs.google.dagger.compiler)
    }
}, buildFeaturesConfiguration = {
    compose = true
})
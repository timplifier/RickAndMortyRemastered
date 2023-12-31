package com.timplifier.rickandmortyremastered.buildLogic.convention.extensions

import org.gradle.accessors.dm.LibrariesForAndroidProjectConfig
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.accessors.dm.LibrariesForProjectConfig
import org.gradle.api.Project
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory
import org.gradle.api.plugins.ExtensionAware

private inline fun <reified T> Project.retrieveExtension(name: String): T where T : AbstractExternalDependencyFactory {
    return (this as ExtensionAware).extensions.getByName(name) as T
}

internal inline val Project.libs: LibrariesForLibs
    inline get() =
        retrieveExtension("libs")

internal inline val Project.androidProjectConfig: LibrariesForAndroidProjectConfig
    inline get() = retrieveExtension("androidProjectConfig")

internal inline val Project.projectConfig: LibrariesForProjectConfig
    inline get() = retrieveExtension("projectConfig")
apply {
    from("$rootDir/${Android.androidLibrary}")
}


dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.theme))
    "implementation"(ImageLoading.glide)
    "kapt"(ImageLoading.annotationProcessor)
}
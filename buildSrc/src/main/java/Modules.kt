object Modules {
    const val app = ":app"
    private const val core = ":core"
    const val network = "$core:network"
    private const val features = ":features"
    const val featuresAuth = "$features:auth"
    const val repository = "$core:repository"
    const val featuresMain = "$features:main"
    const val resources = ":resources"
}

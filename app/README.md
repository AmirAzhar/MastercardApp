## How the App Works

This app shows a simple onboarding flow. It has four screens: a cover, three slides, and a terms screen. Users go through each screen step by step.


## What It Uses

- **Jetpack Compose** for UI. It's clean and avoids XML.
- **Kotlin DSL** in `build.gradle.kts` for project config. It’s more readable than Groovy.
- Navigation uses `NavHost` and a sealed class to manage screen routes.

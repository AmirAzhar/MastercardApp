## How the App Works

This app shows a simple onboarding flow. It has four screens: a cover, three slides, and a terms screen. Users go through each screen step by step.

## What It Uses

- **Jetpack Compose** for UI. It's clean and avoids XML.
- **Kotlin DSL** in `build.gradle.kts` for project config. It’s more readable than Groovy.
- Navigation uses `NavHost` and a sealed class to manage screen routes.

## Screen Breakdown

### Cover Screen

This is the first thing you see. It shows the event name, date, and a “Continue” button. The button takes you to the onboarding slides.

### Onboarding Slides

There are three slides. Each one shows:
- A full-width background image
- A title and short description
- Progress dots to show your position
- Back and Next buttons
- A Close button at the top right

The slides are managed by a single composable. It updates based on the current step (page index). You can’t jump ahead.

The layout uses `BoxWithConstraints` to size the image to 60% of screen height. The top app bar is overlaid on the image with a translucent background. The Back button is styled with an orange outline to match the brand. Closing the onboarding takes you back to the cover screen.

### Terms & Conditions

The final screen shows legal information in a fixed text block styled inside a rounded dark card. At the top, there’s a logo and a Close button. At the bottom, users can choose:

- **Agree** -> takes the user back to the cover screen
- **Disagree** -> also goes back to the cover screen

## References

![Jetpack Compose Cheatsheet](https://blog.stackademic.com/jetpack-compose-cheatsheet-your-quick-guide-to-modern-android-ui-development-0f24b5d6b7fe)
![Compose Basics](https://developer.android.com/codelabs/jetpack-compose-basics#0)
![Compose Components](https://developer.android.com/develop/ui/compose/components)
![Hide Statuc Bars](https://developer.android.com/develop/ui/views/layout/immersive)
![Add Overlay Blur](https://timilehin-ty.medium.com/an-overlay-blur-with-androids-jetpack-compose-is-harder-than-it-should-be-e4e4e983cd11)
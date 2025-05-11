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


## References

![Compose Components](https://developer.android.com/develop/ui/compose/components)
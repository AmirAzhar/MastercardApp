## How the App Works

This app shows a simple onboarding flow. It has four screens:
- A cover screen
- Three onboarding slides
- A terms screen

Users go through each screen one step at a time.

## Design Decisions

### Kotlin and Jetpack Compose

I used Android because I don't have a Mac for iOS. I picked Kotlin because I hadn't used it before and would like to explore it

I used Jetpack Compose instead of XML because:
- It’s declarative, like React which i have experience in
- It's cleaner and easier to read
- It handles state better i.e. with remember

## Project Structure
| Folder/File                  | Description                                  |
| ---------------------------- |----------------------------------------------|
| `components/`                | Reusable comps                               |
| `screens/`                   | Composables for each screen                  |
| `ui.theme/`                  | Theme setup: colors, fonts, and typography   |
| `MainActivity.kt`            | App entry point - sets up  screen navigation |
| `res/`                       | fonts and images                             |
| `androidTest/com.example...` | UI tests                                     |
| `test/com.example...`        | Reserved for unit tests (not used yet)       |

## Screens

### Cover Screen

This is the first screen. It shows the event name, date, and a “Continue” button. The button takes you to the slides.

### Intro Screens (Onboarding)

There are three slides. Each slide has:
- A background image
- A title and short text
- Dots to show progress
- Back and Next buttons
- A Close button

All slides are handled by one composable. It updates based on the current index.

### Terms Screen

This screen shows legal text in a dark card. At the top, there’s a logo and Close button. At the bottom, the user can:

- Tap **Agree** – goes back to the cover screen
- Tap **Disagree** – also goes back to the cover screen

## Key Components

### App Bars

This file consists of 2 reusable UI bars - top and bottom. These bars are being used by the intro and terms screens

## Testing Strategy
i decided to write simple tests that cover the core interactions in the app. Since it is built in jetpack compose, I'll be using Compose UI tests to verify. Here's what I'll be testing:

- AppBars.kt
  - Top App Bar
    - Clicking the Close button triggers the callback ✅
    - The Chevron icon is visible or hidden based on the flag ✅
  - Bottom App Bar
    - Clicking Back calls the onBack handler ✅
    - Clicking Next calls the onNext handler ✅

- CoverScreen.kt
  - Tapping Continue navigates to the intro slides ✅

- IntroScreen.kt
  - Next button goes to the next slide ✅
  - Back button navigates prev slide if not on first slide ✅
  - Back button navigates to the Cover screen if on first slide ✅
  - Skip go to the Terms screen ✅
  - The dots update correctly as the slide changes ✅
  
- TermsScreen.kt
  - Tapping Agree returns to the Cover screen ✅
  - Tapping Disagree returns to the Cover screen ✅
  - The terms section is scrollable ✅

If I had more time, maybe I could have done more testing
- visual snapshot tests using tools like Paparazzi to catch any issues with the design and layout

## References

[Jetpack Compose Cheatsheet](https://blog.stackademic.com/jetpack-compose-cheatsheet-your-quick-guide-to-modern-android-ui-development-0f24b5d6b7fe)
[Compose Basics](https://developer.android.com/codelabs/jetpack-compose-basics#0)
[Compose Components](https://developer.android.com/develop/ui/compose/components)
[Hide Status Bars](https://developer.android.com/develop/ui/views/layout/immersive)
[Add Overlay Blur](https://timilehin-ty.medium.com/an-overlay-blur-with-androids-jetpack-compose-is-harder-than-it-should-be-e4e4e983cd11)
[MD lib](https://github.com/jeziellago/compose-markdown)
[Theme](https://medium.com/@riztech.dev/theming-and-styling-in-jetpack-compose-with-materialtheme-c0c8254d8404)
[Text Outline](https://stackoverflow.com/questions/66958260/how-to-outline-text-in-jetpack-compose)
[Fonts](https://developer.android.com/develop/ui/compose/text/fonts)
[States](https://medium.com/mobile-innovation-network/understanding-the-difference-between-remember-and-remembersaveable-in-jetpack-compose-29d7231053e5)
[Testing](https://developer.android.com/develop/ui/compose/testing/testing-cheatsheet)

---

## Pending Tasks
- AppBars.kt
  - add blur - need some weird workaround that is hard to implement
- IntroScreen.kt
  - carousel like animation with ability to swipe - cant find a suitable and good lib
- TermsScreen.kt
  - add scroll bar - scroll bar only for compose desktop, so need create custom or use library
- Theme.kt
  - not integrated properly
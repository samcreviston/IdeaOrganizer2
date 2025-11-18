# IdeaOrganizer2
Kotlin app to organize details, ideas, and notes for projects of any kind.

# Overview

A small Android app built to deepen Kotlin proficiency and solidify core Android patterns. The focus is on clean state management, RecyclerView editing, and showcasing Kotlin language features through practical UI and repository code.

This app manages simple projects, each with a list of notes. You can create projects, edit a project title, add notes, and edit note text inline. Trailing blank notes are pruned using an explicit while loop in the repository to keep data tidy. Data is held in-memory via a lightweight repository; no backend or database is required to run.

The purpose is to demonstrate Kotlin syntax and idioms in a real app context: data classes, immutable/mutable variables, expressions and lambdas, conditionals, explicit loops, functions, and classes. It also highlights RecyclerView binding, EditText with TextWatcher management, and basic activity-to-repository wiring.

[Software Demo Video](https://youtu.be/NKa2oHZW94s)

# Development Environment

Windows, IntelliJ IDEA 2025.2.4, Android SDK, Gradle, Git, and an emulator or device.
Kotlin for app code with AndroidX libraries:
AppCompat, RecyclerView, Material Components.
Project structure highlights:
app/src/main/java/com/example/hello/MainActivity.kt - projects list.
app/src/main/java/com/example/hello/ProjectEditorActivity.kt - editor screen.
app/src/main/java/com/example/hello/ProjectsAdapter.kt and app/src/main/java/com/example/hello/NotesAdapter.kt - RecyclerView adapters.
app/src/main/java/com/example/hello/ProjectsRepository.kt - in-memory data source with pruneTrailingEmptyNotes(...) while loop.
app/src/main/java/com/example/hello/model/Project.kt - Project and Note data classes.

# Useful Websites

{Make a list of websites that you found helpful in this project}

- [Kotlin Language Reference](https://kotlinlang.org/docs/home.html)
- [Android Developers - RecyclerView](https://kotlinlang.org/docs/home.html)
- [Android Developers - EditText and TextWatcher](https://developer.android.com/reference/android/text/TextWatcher)
- [Gradle Build Documentation](https://docs.gradle.org/current/userguide/userguide.html)

# Future Work

{Make a list of things that you need to fix, improve, and add in the future.}

- Persist data across launches (Room or simple JSON storage).
- Drag-and-drop reordering of notes and projects.
- Search and filtering across projects and notes.

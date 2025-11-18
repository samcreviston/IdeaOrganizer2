package com.example.hello

object ProjectsRepository {
    private val projects = mutableListOf<Project>()
    private var nextId = 1L

    init {
        // Prepopulate with an example project for easier testing
        val p = Project(nextId++, "Example Project")
        p.notes.add(Note("Example note"))
        projects.add(p)
    }

    fun getAllProjects(): List<Project> = projects.toList()

    fun getProject(id: Long): Project? = projects.find { it.id == id }

    fun createProject(title: String): Project {
        val p = Project(nextId++, title)
        projects.add(0, p)
        return p
    }

    fun updateProject(project: Project) {
        val idx = projects.indexOfFirst { it.id == project.id }
        if (idx >= 0) projects[idx] = project
    }
}

// Note: Project and Note data classes are defined in `model/Project.kt` to avoid duplication.

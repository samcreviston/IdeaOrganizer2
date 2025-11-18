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

    /**
     * Removes trailing notes whose content is blank (empty or whitespace) from the given project.
     * Returns the number of notes removed.
     */
    fun pruneTrailingEmptyNotes(projectId: Long): Int {
        val project = getProject(projectId) ?: return 0
        var removed = 0
        val notes = project.notes
        while (notes.isNotEmpty() && notes.last().content.isBlank()) {
            notes.removeAt(notes.size - 1)
            removed++
        }
        if (removed > 0) updateProject(project)
        return removed
    }
}

// Note: Project and Note data classes are defined in `model/Project.kt` to avoid duplication.

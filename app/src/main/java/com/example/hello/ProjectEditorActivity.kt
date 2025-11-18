package com.example.hello

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello.databinding.ActivityProjectEditorBinding

class ProjectEditorActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PROJECT_ID = "extra_project_id"
    }

    private lateinit var binding: ActivityProjectEditorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val projectId = intent.getLongExtra(EXTRA_PROJECT_ID, -1L)

        val project = if (projectId == -1L) {
            ProjectsRepository.createProject("New Project")
        } else {
            ProjectsRepository.getProject(projectId) ?: ProjectsRepository.createProject("Untitled")
        }

        // Set title into EditText
        binding.titleTextView.setText(project.title)

        val adapter = NotesAdapter(project)
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.notesRecyclerView.adapter = adapter

        binding.addNoteButton.setOnClickListener {
            project.notes.add(Note("New note"))
            ProjectsRepository.updateProject(project)
            adapter.notifyDataSetChanged()
        }

        binding.saveTitleButton.setOnClickListener {
            project.title = binding.titleTextView.text.toString()
            ProjectsRepository.updateProject(project)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

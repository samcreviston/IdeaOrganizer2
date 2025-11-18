package com.example.hello

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ProjectsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val swipeRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)

        adapter = ProjectsAdapter(
            onProjectClick = { projectId ->
                val intent = Intent(this, ProjectEditorActivity::class.java).apply {
                    putExtra(ProjectEditorActivity.EXTRA_PROJECT_ID, projectId)
                }
                startActivity(intent)
            },
            onAddNewClick = {
                val newProject = ProjectsRepository.createProject("Untitled")
                adapter.submitList(ProjectsRepository.getAllProjects())
                val intent = Intent(this, ProjectEditorActivity::class.java).apply {
                    putExtra(ProjectEditorActivity.EXTRA_PROJECT_ID, newProject.id)
                }
                startActivity(intent)
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Load initial data
        adapter.submitList(ProjectsRepository.getAllProjects())

        swipeRefresh.setOnRefreshListener {
            adapter.submitList(ProjectsRepository.getAllProjects())
            swipeRefresh.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.submitList(ProjectsRepository.getAllProjects())
    }
}

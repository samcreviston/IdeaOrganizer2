package com.example.hello

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectsAdapter(
    private val onProjectClick: (Long) -> Unit,
    private val onAddNewClick: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Project> = emptyList()

    private companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_PROJECT = 1
    }

    inner class HeaderVH(view: View) : RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener { onAddNewClick() }
        }
    }

    inner class ProjectVH(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        fun bind(project: Project) {
            titleTextView.text = project.title
            itemView.setOnClickListener { onProjectClick(project.id) }
        }
    }

    fun submitList(list: List<Project>) {
        items = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int =
        if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_PROJECT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_HEADER) {
            val view = inflater.inflate(R.layout.item_new_project, parent, false)
            HeaderVH(view)
        } else {
            val view = inflater.inflate(R.layout.item_project, parent, false)
            ProjectVH(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_PROJECT) {
            val project = items[position - 1] // shift by 1 for header
            (holder as ProjectVH).bind(project)
        }
    }

    override fun getItemCount(): Int = items.size + 1 // +1 for header
}

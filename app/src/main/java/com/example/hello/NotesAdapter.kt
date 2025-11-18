package com.example.hello

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val project: Project) : RecyclerView.Adapter<NotesAdapter.VH>() {
    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val noteTextView: TextView = view.findViewById(R.id.noteTextView)
        fun bind(note: Note) {
            noteTextView.text = note.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(project.notes[position])
    }

    override fun getItemCount(): Int = project.notes.size
}

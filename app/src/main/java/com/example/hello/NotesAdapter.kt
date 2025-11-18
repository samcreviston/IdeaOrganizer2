package com.example.hello

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val project: Project) : RecyclerView.Adapter<NotesAdapter.VH>() {
    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val noteEditText: EditText = view.findViewById(R.id.noteEditText)
        private var watcher: TextWatcher? = null

        fun bind(note: Note) {
            // Remove old watcher to avoid multiple callbacks on recycled views
            watcher?.let { noteEditText.removeTextChangedListener(it) }

            noteEditText.setText(note.content)

            watcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    val newText = s?.toString() ?: ""
                    if (note.content != newText) {
                        note.content = newText
                        ProjectsRepository.updateProject(project)
                    }
                }
            }
            noteEditText.addTextChangedListener(watcher)
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

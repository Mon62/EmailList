package com.example.emaillistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color

class EmailAdapter(private val emails: List<EmailModel>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {
    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sender: TextView = itemView.findViewById(R.id.sender)
        val subject: TextView = itemView.findViewById(R.id.subject)
        val content: TextView = itemView.findViewById(R.id.content)
        val time: TextView = itemView.findViewById(R.id.time)
        val avatar: TextView = itemView.findViewById(R.id.avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_element, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.time.text = email.time
        holder.content.text = email.content
        holder.avatar.text = email.sender.first().toString()

        // Set the background drawable
        holder.avatar.setBackgroundResource(R.drawable.avatar)

        // Set the dynamic background color
        val backgroundColor = Color.parseColor(email.backgroundColor)
        holder.avatar.background.mutate().setTint(backgroundColor)
    }
}
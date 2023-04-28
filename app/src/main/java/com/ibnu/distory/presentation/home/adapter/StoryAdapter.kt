package com.ibnu.distory.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibnu.distory.data.model.Story
import com.ibnu.distory.databinding.ItemStoryBinding
import com.ibnu.distory.utils.helper.getTimeAgo
import com.ibnu.distory.utils.helper.setImageUrl

class StoryAdapter(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    private var listStory = ArrayList<Story>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listStory: List<Story>) {
        this.listStory.clear()
        this.listStory.addAll(listStory)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = listStory[position]
        holder.bind(story)
    }

    override fun getItemCount(): Int = listStory.size

    inner class StoryViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            binding.apply {
                imgStory.setImageUrl(story.photoUrl)
                imgStory.setOnClickListener {
                    onClick(story.id)
                }
                tvUserName.text = story.name
                tvUploadAt.text = story.createdAt.getTimeAgo(root.context)
                tvDescription.text = story.description
            }
        }
    }
}
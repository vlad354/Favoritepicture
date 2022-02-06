package com.favoritepicture.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.favoritepicture.R
import com.favoritepicture.databinding.ListItemHomeViewBinding
import com.favoritepicture.network.PicsumPageData

class HomeRecyclerAdapter(val clickListener: HomeFavoriteListener): ListAdapter<PicsumPageData, HomeRecyclerAdapter.ViewHolder>(DiffCallback) {


    class ViewHolder(private var binding: ListItemHomeViewBinding) : RecyclerView.ViewHolder(binding.root){

        private val _eventLike = MutableLiveData<Boolean>()
        val eventLike: LiveData<Boolean>
            get() = _eventLike


        fun bind(picsumPageData: PicsumPageData, clickListener: HomeFavoriteListener) {

            binding.allPicture = picsumPageData

            binding.clickListener = clickListener
            _eventLike.value = false

            if (_eventLike.value == false) {
                binding.homeFavoriteHeart.setImageResource(R.drawable.ic_favorite_off)
            }
            else {
                binding.homeFavoriteHeart.setImageResource(R.drawable.ic_favorite_on)
            }

            binding.homeFavoriteHeart.setOnClickListener {
                if (_eventLike.value == true){
                    binding.homeFavoriteHeart.setImageResource( R.drawable.ic_favorite_off)
                    _eventLike.value = false
                }
                else{
                    binding.homeFavoriteHeart.setImageResource(R.drawable.ic_favorite_on)
                    _eventLike.value = true
                }
            }


            binding.executePendingBindings()
        }


    }
    companion object DiffCallback : DiffUtil.ItemCallback<PicsumPageData>() {
        override fun areItemsTheSame(oldItem: PicsumPageData, newItem: PicsumPageData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PicsumPageData, newItem: PicsumPageData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemHomeViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picsumPageData = getItem(position)
        holder.bind(picsumPageData, clickListener)
    }

}

class HomeFavoriteListener(val clickListener: (id: String) -> Unit){
    fun onClick(picsumPageData: PicsumPageData) = clickListener(picsumPageData.id)

}
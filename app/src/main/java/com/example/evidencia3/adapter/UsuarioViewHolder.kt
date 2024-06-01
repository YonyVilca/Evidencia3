package com.example.evidencia3.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.evidencia3.R
import com.example.evidencia3.Usuario
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.evidencia3.databinding.ItemUsuarioBinding // Import the generated binding class

class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Initialize binding object
    val binding = ItemUsuarioBinding.bind(view)

    fun render(usuarioModel: Usuario, OnclickListener:(Usuario)-> Unit) {
        // Access views through binding object
        binding.tvSuperHeroName.text = usuarioModel.superhero
        binding.tvRealName.text = usuarioModel.realName
        binding.tvPublisher.text = usuarioModel.publisher
        Glide.with(binding.ivSuperHero.context).load(usuarioModel.photo).into(binding.ivSuperHero)


        itemView.setOnClickListener{OnclickListener(usuarioModel)

        }
    }
}
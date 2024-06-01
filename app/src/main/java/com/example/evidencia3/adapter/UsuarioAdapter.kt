package com.example.evidencia3.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.example.evidencia3.R
import com.example.evidencia3.Usuario

class UsuarioAdapter(private val usuariosList: List<Usuario>,  val OnClickListener: (Usuario) -> Unit ) : RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_usuario, parent, false))
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = usuariosList[position]
        holder.render(item, OnClickListener)
    }

    override fun getItemCount(): Int = usuariosList.size
}
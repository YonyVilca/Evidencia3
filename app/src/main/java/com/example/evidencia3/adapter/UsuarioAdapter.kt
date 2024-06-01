/**
 * Evidencia 3
 *
 * Practica: RecyclerView
 *
 * @author Yony Alex Vilca Mamani
 *
 *
 * @since [29/05/2024]
 */
package com.example.evidencia3.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.example.evidencia3.R
import com.example.evidencia3.Usuario

// Adaptador para mostrar una lista de usuarios en un RecyclerView.
class UsuarioAdapter(private val usuariosList: List<Usuario>,  val OnClickListener: (Usuario) -> Unit ) : RecyclerView.Adapter<UsuarioViewHolder>() {

    //Crea y devuelve un ViewHolder para un elemento de usuario.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_usuario, parent, false))
    }
//Vincula los datos de un usuario a un ViewHolder.
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = usuariosList[position]
        holder.render(item, OnClickListener)
    }
//Obtiene el número total de elementos en la lista de usuarios
    override fun getItemCount(): Int = usuariosList.size
}
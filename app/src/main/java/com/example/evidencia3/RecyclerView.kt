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
package com.example.evidencia3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evidencia3.adapter.UsuarioAdapter
import com.example.evidencia3.databinding.FragmentRecyclerViewBinding

/**
 * Un fragmento que muestra una lista de usuarios en un RecyclerView.
 */
class RecyclerViewFragment : Fragment() {
    // Enlace para acceder a los elementos de la vista del fragmento.
    private lateinit var binding: FragmentRecyclerViewBinding
    // Lista mutable de usuarios.
    private val usuarioMutableList: MutableList<Usuario> = UsuarioProvider.Usuarioslist.toMutableList()
    /**
     * Método de ciclo de vida del fragmento que infla la vista del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar la vista del fragmento utilizando el enlace.
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerUsuario.layoutManager = manager
        // Devolver la raíz de la vista del fragmento.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }
    /**
     * Inicializa el RecyclerView con un adaptador de usuario.
     */
    private fun initRecyclerView() {
        val adapter = UsuarioAdapter(usuarioMutableList) { usuario -> onItemSelected(usuario) }
        binding.recyclerUsuario.adapter = adapter
    }
    /**
     * Maneja la selección de un usuario en el RecyclerView.
     * Muestra un Toast con el nombre real del usuario seleccionado.
     */
    private fun onItemSelected(usuario: Usuario) {
        Toast.makeText(requireContext(), usuario.realName, Toast.LENGTH_SHORT).show()
    }
}

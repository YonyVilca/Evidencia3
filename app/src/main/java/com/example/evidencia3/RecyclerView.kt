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

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private val usuarioMutableList: MutableList<Usuario> = UsuarioProvider.Usuarioslist.toMutableList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerUsuario.layoutManager = manager
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = UsuarioAdapter(usuarioMutableList) { usuario -> onItemSelected(usuario) }
        binding.recyclerUsuario.adapter = adapter
    }

    private fun onItemSelected(usuario: Usuario) {
        Toast.makeText(requireContext(), usuario.realName, Toast.LENGTH_SHORT).show()
    }
}

package com.example.evidencia3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evidencia3.adapter.UsuarioAdapter
import com.example.evidencia3.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerUsuario.layoutManager = manager
        binding.recyclerUsuario.adapter = UsuarioAdapter(UsuarioProvider.Usuarioslist) { usuario ->
            onItemSelected(usuario)
        }
    }

    fun onItemSelected(usuario: Usuario){
        Toast.makeText(requireContext(), usuario.realName, Toast.LENGTH_SHORT ).show()
    }
}

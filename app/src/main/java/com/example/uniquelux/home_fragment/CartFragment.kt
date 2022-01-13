package com.example.uniquelux.home_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.uniquelux.R
import com.example.uniquelux.databinding.FragmentCartBinding
import kotlinx.android.synthetic.main.fragment_cart.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    //dataBinding
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    //var binding:FragmentCartBinding?=null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //DataBinding Inflate
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

        var hargaMakanan = 7
        binding.AddBtn.setOnClickListener {
            val JumlahPesanan: Int = binding.tvJumlahPesanan.text.toString().toInt() + 1
            binding.tvJumlahPesanan.text = JumlahPesanan.toString()
            val hargaTotal: Int = hargaMakanan * binding.tvJumlahPesanan.text.toString().toInt()
            binding.tvTotalPesanan.text = "Rp${hargaTotal.toString()},000"
            binding.tvTotalBiaya.text = "Rp${(hargaTotal + 6)},000"
        }
        binding.ReduceBtn.setOnClickListener {
            if (binding.tvJumlahPesanan.text.toString() == "1") {
                Toast.makeText(activity, "Should order at least 1 pcs.", Toast.LENGTH_SHORT).show()
            } else {
                val JumlahPesanan: Int = binding.tvJumlahPesanan.text.toString().toInt() - 1
                binding.tvJumlahPesanan.text = JumlahPesanan.toString()
                val hargaTotal: Int = hargaMakanan * binding.tvJumlahPesanan.text.toString().toInt()
                binding.tvTotalPesanan.text = "Rp${hargaTotal.toString()},000"
                binding.tvTotalBiaya.text = "Rp${(hargaTotal + 6)},000"
            }
        }

        // Inflate the layout for this fragment

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}